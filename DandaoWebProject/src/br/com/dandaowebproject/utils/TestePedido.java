package br.com.dandaowebproject.utils;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.EntityManager;

import sun.font.EAttribute;

import br.com.dandaowebproject.model.bean.Item;
import br.com.dandaowebproject.model.bean.Pedido;
import br.com.dandaowebproject.model.bean.PedidoItem;
import br.com.dandaowebproject.model.dao.JPAUtil;


public class TestePedido {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 EntityManager manager = JPAUtil.getEntityManagerPedido();

		 manager.getTransaction().begin();
		 Pedido pedido = new Pedido();
		 pedido.setDataCadastro(Calendar.getInstance());
		 pedido.setStatus("NP");
		 
		 // manager.merge(pedido);
		 
		Item item = new Item(); 	
		item.setIdItem(10);
		item.setNomeProduto("kikao");
		item.setObservacao(" sem catchup");
		item.setPreco(4.5);
		item.setQuantidade(2);
		item.setTotal(item.getPreco() * item.getQuantidade());
		manager.persist(item);
			
		   PedidoItem pedidoItem = new PedidoItem();
		   pedidoItem.setIdpedidoitem(30);	
		   pedidoItem.setPedido(pedido);
		   pedidoItem.setItem(item);
		   pedidoItem.setDataCadastro(Calendar.getInstance());
		
	
		
		/*Item item2 = new Item();
		item2.setNomeProduto("xbacon");
		item2.setObservacao("sem tomate");
		item2.setPreco(5.5);
		item2.setQuantidade(3);
		item2.setTotal(item2.getPreco() * item2.getQuantidade());
		manager.persist(item2);
*/

		Item item3 = new Item(); 	
		item3.setIdItem(11);
		item3.setNomeProduto("misto");
		item3.setObservacao("-");
		item3.setPreco(3.5);
		item3.setQuantidade(1);
		item3.setTotal(item3.getPreco() * item3.getQuantidade());
		manager.persist(item3);


	   PedidoItem pedidoItem2 = new PedidoItem();
	   pedidoItem2.setIdpedidoitem(40);	
	   pedidoItem2.setPedido(pedido);
	   pedidoItem2.setItem(item3);
	   pedidoItem2.setDataCadastro(Calendar.getInstance());
	
//	   PedidoItem pedidoItem4 = new PedidoItem();
//	   pedidoItem4.setPedido(pedido);
//	   pedidoItem4.setItem(item3);
//	   pedidoItem4.setDataCadastro(Calendar.getInstance());
	
	  Collection<PedidoItem> pedidos = Arrays.asList(pedidoItem,pedidoItem2);
		

		
		pedido.setPedidoItemList(pedidos);
		double totalPedido =0;
		
		
		for (PedidoItem pedidoItem3 : pedido.getPedidoList()) {
		 totalPedido = totalPedido + +pedidoItem3.getItem().getTotal();
		}
		
		
		pedido.setTotalPedido(totalPedido);
		
		manager.merge(pedido);
		
		manager.getTransaction().commit();
		
		manager.close();
		
	
	}
}
