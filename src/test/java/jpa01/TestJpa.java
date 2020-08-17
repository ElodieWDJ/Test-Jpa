package jpa01;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestJpa {
	private EntityManagerFactory factory = null;
	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}

}
