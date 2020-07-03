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
	// Permet de définir la statégie de génération
	// de la clé lors d'une insertion en base de données.
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
