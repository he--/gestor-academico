package br.com.gestorAcademico.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import br.com.gestorAcademico.dao.CursoDao;
import br.com.gestorAcademico.entity.Curso;

@ManagedBean
@ViewScoped
public class CursoMB {

	private List cusos = new ArrayList<Curso>();
	private Curso cuso;
	private CursoDao cusoDao;

	public CursoMB() {
		cusoDao = new CursoDao();
		cuso = new Curso();
		
		cusos = cusoDao.listarCursos();
		
	}
	
	public List getCursos() {
		return cusos;
	}

	public void setCursos(List cusos) {
		this.cusos = cusos;
	}

	public Curso getCurso() {
		return cuso;
	}

	public void setCurso(Curso cuso) {
		this.cuso = cuso;
	}

	public void salvar(ActionEvent actionEvent) {
		
		cusoDao.salvar(cuso);
		
		cusos = cusoDao.listarCursos();
		cuso = new Curso();
		
		addMessage("Curso salvo com sucesso!!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
}
