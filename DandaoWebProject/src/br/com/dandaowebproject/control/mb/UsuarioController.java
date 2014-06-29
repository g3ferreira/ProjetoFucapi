/**
 * 
 */
package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.dandaowebproject.model.bean.Usuario;
import br.com.dandaowebproject.model.dao.JPAUtil;
import br.com.dandaowebproject.model.dao.UsuarioDAO;

/**
 * <Put here the description of the class>
 * @project DandaoWebProject
 * @version 1.0
 * @author Genilson Ferreira
 * @email genilson.ferreira@iatecam.org.br
 * @since May 14, 2014 

 */


@ViewScoped
@ManagedBean
public class UsuarioController {
	
	Usuario Usuario = new Usuario();
	public List<Usuario> listaUsuario = new ArrayList<Usuario>();
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}
	
	@PostConstruct
	public void carregarUsuario(){
		EntityManager em = JPAUtil.getEntityManagerUsuario();
		UsuarioDAO dao = new UsuarioDAO(em);
		listaUsuario = dao.listar();
		em.close();
	}
	
	public String validaUsuario(String login, String email){
		EntityManager em = JPAUtil.getEntityManagerUsuario();
		UsuarioDAO dao = new UsuarioDAO(em);
		String resultado = dao.validaUsuario(login, email);
		em.close();
		return resultado;
	}
	
	
	public void salvar(){
		EntityManager em = JPAUtil.getEntityManagerUsuario();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		Usuario.setDataCadastro(Calendar.getInstance());
		if(Usuario.getId()!=null){
			dao.alterar(Usuario);
		}else{
			dao.cadastrar(Usuario);
		}
		em.getTransaction().commit();
		em.close();
	//	Usuario = new Usuario();
		carregarUsuario();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManagerUsuario();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		dao.excluir(Usuario);
		em.getTransaction().commit();
		em.close();
		carregarUsuario();
	}	

	

	public void cadastrarUsuario(String nome,String login,String senha,String email){
		EntityManager em = JPAUtil.getEntityManagerUsuario();
		UsuarioDAO dao = new UsuarioDAO(em);
		Usuario usuario = new Usuario();
		em.getTransaction().begin();
		usuario.setDataCadastro(Calendar.getInstance());
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		dao.cadastrar(usuario);
		em.getTransaction().commit();
		em.close();
		
		
	}	
	
	
	
}
