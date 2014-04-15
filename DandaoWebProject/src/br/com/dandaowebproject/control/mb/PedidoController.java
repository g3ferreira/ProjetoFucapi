package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.dao.JPAUtil;
import br.com.dandaowebproject.model.dao.PedidoDAO;
import br.com.dandaowebproject.model.bean.Pedido;;

@ViewScoped
@ManagedBean
public class PedidoController {
	
	
	private Pedido pedido = new Pedido();

	
	public ArrayList<Pedido> listarTodos(){
		return PedidoDAO.getInstance().listarPedido();
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	
//	public ArrayList<Pedido> listarTodos(){
//		return PedidoDAO.getInstance().listarTodos();
//	}
//	
	
	public void salvar(Long idpedido, String nomeProduto,int quantidade, double preco){
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();

		pedido.setIdPedido(idpedido);
		pedido.setNomeProduto(nomeProduto);
		pedido.setQuantidade(quantidade);
		pedido.setPreco(preco);
		
		System.out.println("SALVAR");
		pedido.setDataPedido(Calendar.getInstance());
		if(pedido.getIdPedido()!=null){
			System.out.println("UMMM");
			dao.alterar(pedido);
		}else{

			System.out.println("DOIS");
			dao.cadastrar(pedido);
		}
		em.getTransaction().commit();
		em.close();
//		pedido  = new Pedido();
	}

	
	
	public void excluir(Long idpedido, String nomeProduto,int quantidade, double preco){
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();

		pedido.setIdPedido(idpedido);
		pedido.setNomeProduto(nomeProduto);
		pedido.setQuantidade(quantidade);
		pedido.setPreco(preco);
		
		System.out.println(">deletar");
		pedido.setDataPedido(Calendar.getInstance());
		if(pedido.getIdPedido()!=null){
		
			dao.excluir(pedido);
		}else{

			System.out.println("Pedido N."+ pedido.getIdPedido()+ " Não Existe: ");
		}
		em.getTransaction().commit();
		em.close();
//		pedido  = new Pedido();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Pedido> listarPedido(){
		
		EntityManager em = JPAUtil.getEntityManagerPedido();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		
		return  dao.listarPedido();
	}

	
	
	
	
//	public String inserirPedidos(Long idpedido, String nomeProduto, int quantidade, double preco){
//		return PedidoDAO.getInstance().inserirPedido(idpedido,nomeProduto, quantidade,preco);
//}
}