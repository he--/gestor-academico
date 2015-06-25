package br.com.gestorAcademico.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import br.com.gestorAcademico.dao.DisciplinaDao;
import br.com.gestorAcademico.entity.Disciplina;

@ManagedBean
@ViewScoped
public class DisciplinaMB {

	private List disciplinas = new ArrayList<Disciplina>();
	private Disciplina disciplina;
	private DisciplinaDao disciplinaDao;

	public DisciplinaMB() {
		disciplinaDao = new DisciplinaDao();
		disciplina = new Disciplina();
		
		disciplinas = disciplinaDao.listarDisciplinas();
		
	}
	
	public List getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void salvar(ActionEvent actionEvent) {
		
		disciplinaDao.salvar(disciplina);
		
		disciplinas = disciplinaDao.listarDisciplinas();
		disciplina = new Disciplina();
		
		addMessage("Disciplina salva com sucesso!!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
}
