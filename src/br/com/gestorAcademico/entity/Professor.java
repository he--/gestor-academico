package br.com.gestorAcademico.entity;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="credencial")
	private String credencial;
	
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}   
	    
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
   
}
