package br.com.gestorAcademico.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import br.com.gestorAcademico.dao.TurmaDao;
import br.com.gestorAcademico.entity.Turma;

@ManagedBean
@ViewScoped
public class TurmaMB {

	private List turmas = new ArrayList<Turma>();
	private Turma turma;
	private TurmaDao turmaDao;

	public TurmaMB() {
		turmaDao = new TurmaDao();
		turma = new Turma();
		
		turmas = turmaDao.listarTurmas();
		
	}
	
	public List getTurmas() {
		return turmas;
	}

	public void setTurmas(List turmas) {
		this.turmas = turmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void salvar(ActionEvent actionEvent) {
		
		turmaDao.salvar(turma);
		
		turmas = turmaDao.listarTurmas();
		turma = new Turma();
		
		addMessage("Turma salva com sucesso!!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
}
