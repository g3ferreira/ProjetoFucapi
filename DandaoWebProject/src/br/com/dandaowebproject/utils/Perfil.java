package br.com.dandaowebproject.utils;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Perfil {

	@Id 
	@GeneratedValue 
	private Integer id;
	private String nomePerfil;
	@OneToMany(cascade=CascadeType.ALL) 
	@JoinTable(name="usuario_perfil", 
	joinColumns={@JoinColumn(name="perfil_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="usuario_id", referencedColumnName="id")}) 
	private List<Usuario> usuarioList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}
	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	
}
