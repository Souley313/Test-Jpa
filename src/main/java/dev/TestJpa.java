package dev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		

		entityManager.close();

		entityManagerFactory.close();

	}

}
