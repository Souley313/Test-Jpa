package dev.banque.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

/**
 * @author souleymaneTHIAM
 *
 */
@Entity
@Table(name = "OPERATION")
public class Operation {

	@Id
	// Permet de d�finir la stat�gie de g�n�ration
	// de la cl� lors d'une insertion en base de donn�es.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name= "date",nullable = false)
	private LocalDateTime date;

	@Column(name= "montant",nullable = false)
	private Double montant;

	@Column(name= "motif",nullable = false)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="id_compte")
    private Compte compte ;

}
