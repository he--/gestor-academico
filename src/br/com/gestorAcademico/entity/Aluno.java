package br.com.gestorAcademico.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="credencial")
	private String credencial;

	/*
	@ManyToMany
    @JoinTable(name="aluno_has_turmas", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="id")})
	private List<Turma> turmas;*/
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getCredencial() {
		return this.credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}
/*
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}*/
   
}
