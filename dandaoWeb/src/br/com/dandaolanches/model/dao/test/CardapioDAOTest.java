package br.com.dandaolanches.model.dao.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dandaolanches.model.bean.Cardapio;
import br.com.dandaolanches.model.dao.CardapioDAO;
import br.com.dandaolanches.model.dao.JPAUtil;

public class CardapioDAOTest {

	@Test
	public void testCadastrar() {
		// Solicitacao de conexao ao SGBD
		EntityManager entityManager = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(entityManager);
		// Inicio da transacao
		entityManager.getTransaction().begin();
		// Criacao de um novo produto
		Cardapio produto = new Cardapio();
		produto.setNome("bola");
		produto.setDescricao("futebol de campo");
		produto.setDataCadastro(Calendar.getInstance());
		produto.setTipo("Sanduiches");
		produto.setPreco(45.5);
		//Execucao do cadastro
		dao.cadastrar(produto);
		//Fechamento da conexao
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//Realização do teste de cadastro
		Assert.assertNotNull(produto.getId());
	}

	// Continuacao...
	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}
