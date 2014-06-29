/**
 * 
 */
package br.com.dandaowebproject.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Usuario;

/**
 * <Put here the description of the class>
 * @project DandaoWebProject
 * @version 1.0
 * @author Genilson Ferreira
 * @email genilson.ferreira@iatecam.org.br
 * @since May 14, 2014 
 * 
 */

@SuppressWarnings("unchecked")
public class UsuarioDAO {
	private EntityManager entityManager;
	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Usuario Usuario){
		entityManager.persist(Usuario);
	}
	
	public void alterar(Usuario Usuario){
		entityManager.merge(Usuario);
	}
	
	public void excluir(Usuario Usuario){
		entityManager.remove(entityManager.merge(Usuario));
	}
	
	public List<Usuario> listar(){
		String jpql = "Select p from Usuario p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	public String validaUsuario(String login, String email){
		String jpql = "select COUNT(*) from Usuario where login ='"+login+ "' or email = '"+email+"'";
		Query query = entityManager.createQuery(jpql);
		String resultado = (String) query.getParameterValue("count");
		if(resultado.equals("0"))
		{
			return "disponível";
		}
		else
		{
			return "login ou email indisponível!";
		}
		
	}
	
	
}
