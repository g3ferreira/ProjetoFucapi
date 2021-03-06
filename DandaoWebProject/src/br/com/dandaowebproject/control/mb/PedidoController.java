package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.apache.commons.collections.ListUtils;

import com.mchange.v2.util.CollectionUtils;

import br.com.dandaowebproject.model.dao.CardapioDAO;
import br.com.dandaowebproject.model.dao.JPAUtil;
import br.com.dandaowebproject.model.dao.PedidoDAO;
import br.com.dandaowebproject.model.bean.Cardapio;
import br.com.dandaowebproject.model.bean.Item;
import br.com.dandaowebproject.model.bean.Pedido;
import br.com.dandaowebproject.model.bean.PedidoItem;
import br.com.dandaowebproject.resource.PedidoResource;
import br.com.dandaowebproject.utils.log.SimpleLogger;

@ViewScoped
@ManagedBean
public class PedidoController {
	private SimpleLogger logger = new SimpleLogger(PedidoController.class.getName(), SimpleLogger.CATEGORY_DEBUG);
	
	public Item item ;
	public PedidoItem pedidoItem;
	private Pedido pedidoWeb = new Pedido();

	private Pedido pedido;


	public Pedido getPedidoWeb() {
		return pedidoWeb;
	}


	public void setPedidoWeb(Pedido pedidoWeb) {
		this.pedidoWeb = pedidoWeb;
	}

	

	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
	
/*---------------------------------- PEDIDOITEM CONTROLLER -----------------------------------------*/
	

	
//	public Item consultar(int id){
//		return entityManager.getReference(Item.class, idpedido);
//	}	
	
	public List<PedidoItem> listarPedidoItem(){
		
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		
		return  dao.listarPedidoItem();
	}
 
	
	public void cadastrarPedidoItem(Pedido pedido, Item item){
		System.out.println(">salvarPedidoItem()");

		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		pedidoItem = new PedidoItem();
		pedidoItem.setPedido(pedido);
		pedidoItem.setItem(item);
		pedidoItem.setDataCadastro(Calendar.getInstance());

		
		Pedido.listaPedidos.add(pedidoItem);

		System.out.println("Tamanho da lista de Pedido: "+Pedido.listaPedidos.size());
		pedido.getInstance().setPedidoItemList(Pedido.listaPedidos);
		System.out.println("<salvarPedidoItem()");
		
	}	
	


	

	
	
	

/*--------------------------------------------- PEDIDO  DAO -----------------------------------------*/
	

//	public Item consultar(int id){
//		return entityManager.getReference(Item.class, idpedido);
//	}	

	public void carregarPedido(){
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		listaPedidos = dao.listarPedido();
		em.close();
		
	} 
	
	public List<Pedido> listaPedidos= new ArrayList<Pedido>();

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}


	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}


	public void salvarPedido(){
		
		 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa meu deus do ceu");
			EntityManager em = JPAUtil.getEntityManagerPedido();
			PedidoDAO dao = new PedidoDAO(em);
			em.getTransaction().begin();
			pedidoWeb.setDataCadastro(Calendar.getInstance());
			if(pedidoWeb.getIdpedido()!=0){
				dao.alterarPedido(pedidoWeb);
			}else{
				dao.cadastrarPedido(pedidoWeb);
			}
			em.getTransaction().commit();
			em.close();
			carregarPedido();
		}
	


	public String abrirPedido(int idpedido, String status){
		 EntityManager manager = JPAUtil.getEntityManagerPedido();
		 manager.getTransaction().begin();
		 PedidoDAO dao = new PedidoDAO(manager);
		 setPedido(new Pedido());
		 getPedido().setIdpedido(idpedido);
		 getPedido().setDataCadastro(Calendar.getInstance());
		 getPedido().setStatus(status);
		 getPedido().setInstance(getPedido());
		/// dao.cadastrarPedido(pedido);
		 
	return "SUCESS";
	}
	
	
	public String finalizarPedido(){
		System.out.println(">finalizarPedido");
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		 getPedido().getInstance().setDataCadastro(Calendar.getInstance());
		 em.getTransaction().begin();

		 double totalPedido =0;
		
			for (PedidoItem pedidoItem3 :  getPedido().getInstance().getPedidoList()) {
			 totalPedido = totalPedido + +pedidoItem3.getItem().getTotal();
			}
						
			 getPedido().getInstance().setTotalPedido(totalPedido);
		     dao.alterarPedido(getPedido().getInstance());
		     Pedido.listaPedidos.clear();
			 em.getTransaction().commit();
			 em.close();
		 
	
	return "SUCESS";
	}
	

/*--------------------------------------------- ITEM  DAO -----------------------------------------*/
	
	public List<Item> listarItem(){
		
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		
		return  dao.listarItem();
	}

	
	
	public String cadastrarItem(int idItem, String nomeProduto, String observacao, double preco, int quantidade, double total ){
		logger.info("> cadastrarItem()");
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		item = new Item();		 
		item.setIdItem(idItem);
		item.setNomeProduto(nomeProduto);
		item.setObservacao(observacao);
		item.setPreco(preco);
		item.setQuantidade(quantidade);
		item.setTotal(total);
	
		
		System.out.println("ID Item: "+item.getIdItem()+
				"Item: "+	item.getNomeProduto()+
				"Quantidade: "+	item.getQuantidade()+
				"Preco: "+	item.getPreco()+
				"Total Item: "+	item.getTotal());
		
		if(item.getIdItem()!=0){
			dao.alterar(item);
		}else{
			dao.cadastrar(item);
		}
		em.getTransaction().commit();
		em.close();
     
		cadastrarPedidoItem(getPedido().getInstance(), item);
		logger.info("< cadastrarItem()");
	
	return "SUCESS";
	}
	
	
	
	public void excluirItem(int idItem, String nomeProduto, String observacao, double preco, int quantidade, double total ){
		logger.info(">excluirItem");
		
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		
		item.setIdItem(idItem);
		item.setNomeProduto(nomeProduto);
		item.setQuantidade(quantidade);
		item.setPreco(preco);
		item.setObservacao(observacao);
		item.setTotal(total);

		if(item.getIdItem()!=0){
			dao.excluir(item);
		}else{
			System.out.println("Item N."+ item.getIdItem()+ " N�o Existe: ");
		}
		em.getTransaction().commit();
		em.close();
		
		logger.info("<excluirItem()");
	}



	
	
	


	
	
	
}