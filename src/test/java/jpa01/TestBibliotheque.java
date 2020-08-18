/**
 * 
 */
package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import entity.Emprunt;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

/**
 * @author perse
 *
 */
public class TestBibliotheque {
	private EntityManager em;
	private EntityManagerFactory factory;
	
@Before
public void init() {
}

@Test
public void listEmprunt() {
	factory = Persistence.createEntityManagerFactory("pu_essai");
	em = factory.createEntityManager();
	if(em != null) {
		String query = "SELECT e FROM Emprunt e";
		TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
		for (Emprunt e : q.getResultList()) {
			System.out.println("Emprunt : " +e);
		}
	}
	
em.close();
factory.close();
}

}
