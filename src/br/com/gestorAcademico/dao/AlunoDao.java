package br.com.gestorAcademico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestorAcademico.entity.Aluno;

public class AlunoDao {
		
	public List<Aluno> listarAlunos() {
		try {
			ConectDao conect = new ConectDao();
			EntityManager em = conect.getEntityManager();
			
			return em.createQuery("SELECT a FROM Aluno a").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Aluno salvar(Aluno aluno) {
		
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(aluno.getId() == null) {
				em.persist(aluno);
			} else {
				aluno = em.merge(aluno);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			aluno = null;
			em.getTransaction().rollback();
		}
		
		return aluno;
	}
	
	public void deletar(Aluno aluno) {
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
	}
	
}
