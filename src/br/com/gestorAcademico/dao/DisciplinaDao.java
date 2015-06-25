package br.com.gestorAcademico.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestorAcademico.entity.Disciplina;

public class DisciplinaDao {
		
	public List<Disciplina> listarDisciplinas() {
		try {
			ConectDao conect = new ConectDao();
			EntityManager em = conect.getEntityManager();
			
			return em.createQuery("SELECT d FROM Disciplina d").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Disciplina salvar(Disciplina dsciplina) {
		
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(dsciplina.getId() == null) {
				em.persist(dsciplina);
			} else {
				dsciplina = em.merge(dsciplina);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			dsciplina = null;
			em.getTransaction().rollback();
		}
		
		return dsciplina;
	}
	
	public void deletar(Disciplina dsciplina) {
		ConectDao conect = new ConectDao();
		EntityManager em = conect.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(dsciplina);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
	}
	
}
