package br.com.gestorAcademico.test;
import javax.persistence.EntityManager;

import br.com.gestorAcademico.dao.ConectDao;
import br.com.gestorAcademico.entity.Aluno;
import br.com.gestorAcademico.entity.Professor;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("teste de java 2");
		
		ConectDao conect = new ConectDao();
		
		EntityManager em = conect.getEntityManager();
		
		System.out.println(em);
		
		try {
			
			Aluno aluno = new Aluno();
			Professor professor = new Professor();
			
			professor.setNome("Professor Edinaldo");
			professor.setCredencial("321");
			
			aluno.setNome("Edinldo");
			aluno.setCredencial("12321");
			
			// Inicia uma transação com o banco de dados.
			em.getTransaction().begin();
			System.out.println("Salvando..");
			
			// Verifica se a pessoa ainda não está salva no banco de dados.
			if(aluno.getId() == null) {
				System.out.println("vai salvar os dados...");
				//Salva os dados.
				em.persist(aluno);
				em.persist(professor);
			} else {
				System.out.println("vai Atualizar os dados..");
				//Atualiza os dados...
				aluno = em.merge(aluno);
			}
			System.out.println("vai finalizar");
//			// Finaliza a transação.
			em.getTransaction().commit();
			System.out.println("Fim");
		} catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
			System.out.println("fim salvar");
		}

	}

}
