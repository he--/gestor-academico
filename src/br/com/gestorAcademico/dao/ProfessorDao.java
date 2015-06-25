package br.com.gestorAcademico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestorAcademico.entity.Professor;

public class ProfessorDao {
		
	public List<Professor> listarProfessores() {
		try {
			ConectDao conect = new ConectDao();
			EntityManager em = conect.getEntityManager();
			
			return em.createQuery("SELECT p FROM Professor p").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Professor salvar(Professor professor) {
		
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(professor.getId() == null) {
				em.persist(professor);
			} else {
				professor = em.merge(professor);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			professor = null;
			em.getTransaction().rollback();
		}
		
		return professor;
	}
	
	public void deletar(Professor professor) {
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(professor);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
	}
	
}
