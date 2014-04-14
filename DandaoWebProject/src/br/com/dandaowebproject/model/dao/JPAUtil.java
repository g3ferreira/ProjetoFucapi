package br.com.dandaowebproject.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	
	
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("cardapio");

	/**
	 * Metodo responsavel pela criacao de conexoes
	 * @return conexao para acesso ao SGBD
	 */
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	private static EntityManagerFactory emfPedido = Persistence
			.createEntityManagerFactory("pedido");

	/**
	 * Metodo responsavel pela criacao de conexoes
	 * @return conexao para acesso ao SGBD
	 */
	public static EntityManager getEntityManagerPedido() {
		return emfPedido.createEntityManager();
	}



}