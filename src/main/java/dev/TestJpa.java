package dev;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Exemple 1 : find
		// Livre livre = entityManager.find(Livre.class, 3);
		// System.out.println("l'auteur du livre "+3+" est: " +livre.getAuteur()+ " et
		// son titre est: "+livre.getTitre());

		// Insérez un nouveau Livre de votre choix en base de données
		// Livre nLivre = new Livre();
		// nLivre.setId(6);
		// nLivre.setAuteur("Souleymane");
		// nLivre.setTitre("Le Revenant");

		// Constrainte JPA => la modification doit se faire dans le cadre d'une
		// transaction.
		// EntityTransaction tx = entityManager.getTransaction();
		// tx.begin();
		// entityManager.persist(nLivre); // insérer une nouvelle ligne
		// tx.commit(); // flush automatique

		// Modifiez le titre du livre d’identifiant 5
		// EntityTransaction tx = entityManager.getTransaction();
		// tx.begin();
		// Livre l = entityManager.find(Livre.class, 5);
		// if (l != null) {
		// l.setTitre("Du plaisir dans la cuisine");
		// }
		// tx.commit();

		// Requête JPQL pour extraire de la base un livre en fonction de son titre.
		Livre lt = new Livre();
		TypedQuery<Livre> query1 = entityManager
				.createQuery("select l from Livre l where l.titre='Du plaisir dans la cuisine'", Livre.class);
		Livre lt1 = query1.getResultList().get(0);
		System.out.println(lt1);

		// Requête JPQL pour extraire de la base un livre en fonction de son auteur.
		Livre la = new Livre();
		TypedQuery<Livre> query2 = entityManager.createQuery("select la from Livre la where la.auteur='Gaston Pouet'",
				Livre.class);
		Livre la1 = query2.getResultList().get(0);
		System.out.println(la1);

		// Supprimez un livre de votre choix en base de données.
		Livre ls = entityManager.find(Livre.class, 6);
		if (ls != null) {
			entityManager.remove(ls);
		}

		// Affichez la liste de tous les livres présents en base de données (titre et
		// auteur).

		Livre laf = new Livre();
		TypedQuery<Livre> query = entityManager.createQuery("select laf from Livre laf", Livre.class);
		List livres = query.getResultList();
		for (Object livre : livres) {
			System.out.println(livre);
		}

		entityManager.close();

		entityManagerFactory.close();

	}

}
