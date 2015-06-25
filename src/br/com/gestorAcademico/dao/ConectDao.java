package br.com.gestorAcademico.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectDao {

	public EntityManager getEntityManager() {
		
		EntityManager em = null;
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
			
			em = factory.createEntityManager();
		} catch(Exception e) {
			System.out.println("inicio getEntityManager");
			System.out.println(e);
			System.out.println("fim getEntityManager");
		}
		return em;
	}
}
