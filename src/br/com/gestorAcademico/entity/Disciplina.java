package br.com.gestorAcademico.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public Disciplina() {
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
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
   
}
