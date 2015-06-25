package br.com.gestorAcademico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestorAcademico.entity.Curso;

public class CursoDao {
		
	public List<Curso> listarCursos() {
		try {
			ConectDao conect = new ConectDao();
			EntityManager em = conect.getEntityManager();
			
			return em.createQuery("SELECT c FROM Curso c").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Curso salvar(Curso curso) {
		
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(curso.getId() == null) {
				em.persist(curso);
			} else {
				curso = em.merge(curso);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			curso = null;
			em.getTransaction().rollback();
		}
		
		return curso;
	}
	
	public void deletar(Curso curso) {
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(curso);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
	}
	
}
