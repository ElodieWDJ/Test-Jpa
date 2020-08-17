package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import entity.Livre;

public class TestJpa {
	private EntityManagerFactory factory = null;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");

	}

	@Test
	public void findLivre() {
		EntityManager em = factory.createEntityManager();

		if (em != null) {
			Livre livre1 = em.find(Livre.class, 1);
			System.out.println(livre1);
		}
		em.close();
		factory.close();
	}

	@Test
	public void listeLivre() {
		EntityManager em = factory.createEntityManager();

		if (em != null) {
			String query = "SELECT l FROM Livre l";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}

	@Test
	public void insertLivre() {
		EntityManager em = factory.createEntityManager();
		Livre l = new Livre();
		l.setId(7);
		l.setAuteur("Timothy Ferris");
		l.setTitre("La semaine de 4 heures");
		// J'ouvre une transaction
		em.getTransaction().begin();
		// J'ajoute dans la bdd mon nouveau livre
		em.persist(l);
		// Je commit et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	@Test
	public void updateLivre() {
		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction
		em.getTransaction().begin();

		// Find transcient : transactionnel
		Livre l = em.find(Livre.class, 5);
		l.setTitre("Du plaisir dans la cuisine");

		// J'ajoute dans la bdd mon nouveau livre
		em.merge(l);

		// Je commit et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	@Test
	public void delateLivre() {
		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction
		em.getTransaction().begin();

		// Find transcient : transactionnel
		Livre l = em.find(Livre.class, 6);

		// J'ajoute dans la bdd mon nouveau livre
		em.remove(l);

		// Je commit et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();

	}
	@Test
	public void extractByTitre() {
		String titreLivre = "'Germinal'";

		EntityManager em = factory.createEntityManager();
		if (em != null) {
			String query = "SELECT l FROM Livre l where titre =" + titreLivre;
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}

		em.close();
		factory.close();
	}
	
	@Test
	public void extractByAuteur() {
		String auteurLivre = "'Timothy Ferris'";

		EntityManager em = factory.createEntityManager();
		if (em != null) {
			String query = "SELECT l FROM Livre l where auteur =" + auteurLivre;
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}

		em.close();
		factory.close();
	}

}
