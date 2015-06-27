package br.com.gestorAcademico.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import br.com.gestorAcademico.dao.AlunoDao;
import br.com.gestorAcademico.entity.Aluno;

@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List alunos = new ArrayList<Aluno>();
	private Aluno aluno;
	private AlunoDao alunoDao;

	public AlunoMB() {
		alunoDao = new AlunoDao();
		aluno = new Aluno();
		
		alunos = alunoDao.listarAlunos();
		
	}
	
	public List getAlunos() {
		return alunos;
	}

	public void setAlunos(List alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void salvar(ActionEvent actionEvent) {
		
		alunoDao.salvar(aluno);
		
		alunos = alunoDao.listarAlunos();
		aluno = new Aluno();
		
		addMessage("Aluno salvo com sucesso!!");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
}
