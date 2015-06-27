package br.com.gestorAcademico.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean(name="controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {
	private String usuario;
	private String senha;
	
}
