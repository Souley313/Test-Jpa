/**
 * 
 */
package dev.banque.entities;

import java.util.Set;

import javax.persistence.*;

/**
 * @author souleymaneTHIAM
 *
 */
@Entity
@Table(name = "COMPTE")
public class Compte {

	@Id
	// Permet de définir la statégie de génération
	// de la clé lors d'une insertion en base de données.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name= "numero_Compte",nullable = false)
	private String numero;

	@Column(name= "solde",nullable = false)
	private Double solde;

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT",

			joinColumns = @JoinColumn(name = "id_compte", referencedColumnName =

			"id"), inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName =

			"id")

	)
	private Set<Client> clients;
}
