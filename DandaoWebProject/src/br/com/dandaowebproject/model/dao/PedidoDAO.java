package br.com.dandaowebproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Cardapio;
import br.com.dandaowebproject.model.bean.Item;
import br.com.dandaowebproject.model.bean.Pedido;
import br.com.dandaowebproject.model.bean.PedidoItem;

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
	
	/*---------------------------- ITEM DAO ---------------------------------------*/
	
	public void cadastrar(Item item){
		entityManager.persist(item);
	}
	public void alterar(Item item){
		entityManager.merge(item);
	}
	public void excluir(Item item){
		entityManager.remove(entityManager.merge(item));
	}
	
//	public Item consultar(Long id){
//		return entityManager.getReference(Item.class, idpedido);
//	}	
		
	public ArrayList<Item> listarItem(){
		System.out.println(">listarItem DAO");
		String jpql = "Select p from Item p order by idpedidoitem";
		Query query = entityManager.createQuery(jpql);
		System.out.println("primeiro resultado: "+query.getFirstResult());
		return (ArrayList<Item>) query.getResultList();
	}
	
	
	
	/*-------------------------------- PEDIDOITEM DAO ----------------------------------------*/
	
	
	public void cadastrarPedidoItem(PedidoItem pedidoItem){
		entityManager.persist(pedidoItem);
	}
	public void alterarPedidoItem(PedidoItem pedidoItem){
		entityManager.merge(pedidoItem);
	}
	public void excluirPedidoItem(PedidoItem pedidoItem){
		entityManager.remove(entityManager.merge(pedidoItem));
	}

	public ArrayList<PedidoItem> listarPedidoItem(){
		
		System.out.println(">listarPedido DAO");
		String jpql = "Select p from PedidoItem p order by idpedidoitem";
		Query query = entityManager.createQuery(jpql);
		return (ArrayList<PedidoItem>) query.getResultList();
	}
	
	
	
	/*-------------------------------- PEDIDO DAO ----------------------------------------*/
	
	public void cadastrarPedido(Pedido pedido){
		entityManager.persist(pedido);
	}
	public void alterarPedido(Pedido pedido){
		entityManager.merge(pedido);
	}
	public void excluirPedido(Pedido pedido){
		entityManager.remove(entityManager.merge(pedido));
	}

	public ArrayList<Pedido> listarPedido(){
		System.out.println(">listarPedido");
		String jpql = "Select p from Pedido p order by idpedido";
		Query query = entityManager.createQuery(jpql);
		return (ArrayList<Pedido>) query.getResultList();
	}

	
	public  double somaTotalPedidos(){
		System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");

		String jpql = "Select sum(totalpedido) from Pedido where status = 'PG'";
		Query query = entityManager.createQuery(jpql);
		System.out.println("Soma total First Result"+query.getFirstResult());
		System.out.println("somaaTotalPedidos"+Double.valueOf(query.getFirstResult()));
		return Double.valueOf(query.getFirstResult());
		}

	
	
}


