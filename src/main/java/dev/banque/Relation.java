/**
 * 
 */
package dev.banque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author formation
 *
 */
public class Relation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-pu");
		EntityManager em = entityManagerFactory.createEntityManager();

		

		em.close();
		entityManagerFactory.close();

	}

}
