package br.com.dandaowebproject.utils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue 
	private Integer id;
	private String login;
	private String senha;
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinTable(name="usuario_perfil",
	 joinColumns={@JoinColumn(name="usuario_id", referencedColumnName="id")},
	 inverseJoinColumns={@JoinColumn(name="perfil_id", referencedColumnName="id")})
	private Perfil perfil; 

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	
}
