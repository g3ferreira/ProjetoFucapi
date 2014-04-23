package br.com.dandaowebproject.utils;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.dandaowebproject.model.dao.JPAUtil;

public class TesteUsuarioPerfil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
//		SessionFactory sessionFactory = (SessionFactory) JPAUtil.getEntityManager();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		//Perfil perfil = (Perfil) session.get(Perfil.class, 2); 
		
		Perfil perfil = new Perfil();
		perfil.setNomePerfil("Admin");
		em.persist(perfil);
	
		Usuario usuario = new Usuario();
		usuario.setLogin("testeuser");
		usuario.setSenha("senhaqualquer");
		usuario.setPerfil(perfil);
		em.persist(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("testeuser");
		usuario2.setSenha("senhaqualquer");
		usuario2.setPerfil(perfil);
		em.persist(usuario2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("testeuser");
		usuario3.setSenha("senhaqualquer");
		usuario3.setPerfil(perfil);
	
		
		em.persist(usuario3);
		em.getTransaction().commit();
		em.close();
		
//		session.save(usuario); 
//		session.getTransaction().commit();
//		session.close(); 

		

	}

}
