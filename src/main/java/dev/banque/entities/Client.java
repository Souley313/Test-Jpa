/**
 * 
 */
package dev.banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

/**
 * @author souleymaneTHIAM
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	private Integer id;

	@Column(name= "nom", nullable = false)
	private String nom;

	@Column(name= "prenom", nullable = false)
	private String prenom;

	@Column(name= "date_naissance",nullable = false)
	private LocalDate dateNaissance;

	@Embedded
	@Column(name= "adresse",nullable = false)
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
    private Banque banque ;
	
	@ManyToMany(mappedBy="clients")
    private Set<Compte> comptes ;

}
