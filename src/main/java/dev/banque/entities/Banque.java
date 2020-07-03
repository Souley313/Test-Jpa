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
@Table(name = "BANQUE")
public class Banque {

	@Id
	private String nom;

	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

}
