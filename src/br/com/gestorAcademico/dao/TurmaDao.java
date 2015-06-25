package br.com.gestorAcademico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestorAcademico.entity.Turma;

public class TurmaDao {
		
	public List<Turma> listarTurmas() {
		try {
			ConectDao conect = new ConectDao();
			EntityManager em = conect.getEntityManager();
			
			return em.createQuery("SELECT t FROM Turma t").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Turma salvar(Turma turma) {
		
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(turma.getId() == null) {
				em.persist(turma);
			} else {
				turma = em.merge(turma);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			turma = null;
			em.getTransaction().rollback();
		}
		
		return turma;
	}
	
	public void deletar(Turma turma) {
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(turma);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
	}
	
}
