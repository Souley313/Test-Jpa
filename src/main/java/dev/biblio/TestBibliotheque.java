/**
 * 
 */
package dev.biblio;

import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.biblio.entities.Client;
import dev.biblio.entities.Emprunt;
import dev.biblio.entities.Livre;

/**
 * @author souleymaneTHIAM
 *
 */
public class TestBibliotheque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Requête qui permet d’extraire un emprunt et tous ses livres associés.
		TypedQuery<Emprunt> query1 = em.createQuery("select e from Emprunt e where e.id = 1", Emprunt.class);
		Emprunt emprunt = query1.getSingleResult();
		
		DateTimeFormatter formatteur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(" -- Emprunté le : " + emprunt.getDateDebut().format(formatteur) 
		+ " par " +emprunt.getClient().getNom() + " "+emprunt.getClient().getPrenom());
		for(Livre livre : emprunt.getLivres()) {
			System.out.println("--"+livre.getTitre() + " de " +livre.getAuteur()+"  Rendu le : " + emprunt.getDateFin().format(formatteur));
		}
		tx.commit();
		
		//Requête qui permet d’extraire tous les emprunts d’un client donné.
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		TypedQuery<Client> query2 = em.createQuery("select c from Client c where c.nom = 'YU'", Client.class);
		Client client = query2.getSingleResult();
		
		client.getEmprunt().forEach(System.out :: println);
		
		tx2.commit();
		
		em.close();
		entityManagerFactory.close();

	}


}
