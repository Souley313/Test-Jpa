/**
 * 
 */
package dev.banque.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author souleymaneTHIAM
 *
 */
@Embeddable
public class Adresse {
	
	@Column(name= "numero", nullable = false)
	private Integer numero;
	
	@Column(name= "rue",nullable = false)
	private String rue;
	
	@Column(name= "code_postale",nullable = false)
	private Integer codePostale;
	
	@Column(name= "ville",nullable = false)
	private String ville;

}
