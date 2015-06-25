package br.com.gestorAcademico.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import br.com.gestorAcademico.dao.ProfessorDao;
import br.com.gestorAcademico.entity.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB {

	private List professores = new ArrayList<Professor>();
	private Professor professor;
	private ProfessorDao professorDao;

	public ProfessorMB() {
		professorDao = new ProfessorDao();
		professor = new Professor();
		
		professores = professorDao.listarProfessores();
		
	}

	public List getProfessores() {
		return professores;
	}

	public void setProfessores(List professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void salvar(ActionEvent actionEvent) {
		
		professorDao.salvar(professor);
		
		professores = professorDao.listarProfessores();
		professor = new Professor();
		
		addMessage("Professor salvo com sucesso!!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
}
