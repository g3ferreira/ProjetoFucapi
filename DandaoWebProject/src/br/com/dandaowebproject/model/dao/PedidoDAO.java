package br.com.dandaowebproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Cardapio;
import br.com.dandaowebproject.model.bean.Pedido;

@SuppressWarnings("unchecked")
public class PedidoDAO {

	public static EntityManager entityManager;
	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private static PedidoDAO instance;
	
	public static PedidoDAO getInstance(){
		if(instance == null)
			instance = new PedidoDAO(entityManager);
		return instance;
	}

	
	public void cadastrar(Pedido pedido){
		entityManager.persist(pedido);
	}
	public void alterar(Pedido pedido){
		entityManager.merge(pedido);
	}
	public void excluir(Pedido pedido){
		entityManager.remove(entityManager.merge(pedido));
	}
	
//	public Pedido consultar(Long id){
//		return entityManager.getReference(Pedido.class, idpedido);
//	}	
	
	
	public ArrayList<Pedido> listarPedido(){
		System.out.println(">listarPedido DAO");
		String jpql = "Select p from Pedido p order by idpedido";
		Query query = entityManager.createQuery(jpql);
		System.out.println("primeiro resultado: "+query.getFirstResult());
		return (ArrayList<Pedido>) query.getResultList();
	}

	public String inserirPedido(Long idpedido, String nomeProduto, int quantidade, double preco){
		Pedido pedido = new Pedido();
		
		pedido.setIdPedido(idpedido);
		pedido.setNomeProduto(nomeProduto);
		pedido.setQuantidade(quantidade);
		pedido.setPreco(preco);
		System.out.println(
				"ID: "+pedido.getIdPedido()+
				"nome Podruto: "+	pedido.getNomeProduto()+
				"nome Quantidade: "+	pedido.getQuantidade()+
				"nome Preco: "+	pedido.getPreco()
				);
		
		cadastrar(pedido);
	
	
	return "SUCESS";
	}
	
	
	
}


