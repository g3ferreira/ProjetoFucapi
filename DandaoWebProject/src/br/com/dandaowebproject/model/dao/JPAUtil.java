package br.com.dandaowebproject.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	
	
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("cardapio");

	private static EntityManagerFactory emfPedido = Persistence
			.createEntityManagerFactory("pedido");

	
	private static EntityManagerFactory emfCaixa = Persistence
			.createEntityManagerFactory("caixa");
	
	private static EntityManagerFactory emfOferta = Persistence
			.createEntityManagerFactory("oferta");
	
	private static EntityManagerFactory emfUsuario = Persistence
			.createEntityManagerFactory("usuario");



	/**
	 * Metodo responsavel pela criacao de conexoes
	 * @return conexao para acesso ao SGBD
	 */
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	/**
	 * Metodo responsavel pela criacao de conexoes
	 * @return conexao para acesso ao SGBD
	 */
	public static EntityManager getEntityManagerPedido() {
		return emfPedido.createEntityManager();
	}
	public static EntityManager getEntityManagerCaixa() {
		return emfCaixa.createEntityManager();
	}

	public static EntityManager getEntityManagerOferta() {
		return emfOferta.createEntityManager();
	}

	public static EntityManager getEntityManagerUsuario() {
		return emfUsuario.createEntityManager();
	}



}