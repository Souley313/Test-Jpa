/**
 * 
 */
package dev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author souleymaneTHIAM
 *
 */
@Entity // indique que cette classe correspond à une table => Livre est une entité JPA
@Table(name = "LIVRE")
public class Livre {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "TITRE")
	private String titre;
	
	@Column(name = "AUTEUR")
	private String auteur;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre id=" + id + ", titre=" + titre + ", auteur=" + auteur;
	}

}
