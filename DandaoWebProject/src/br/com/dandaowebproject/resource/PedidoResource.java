package br.com.dandaowebproject.resource;

import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.dandaowebproject.control.mb.PedidoController;
import br.com.dandaowebproject.model.bean.Item;
import br.com.dandaowebproject.model.bean.Pedido;
import br.com.dandaowebproject.utils.log.SimpleLogger;

@Path("/pedido")
public class PedidoResource {

	
/*------------------------------------------- RESOURCE DO ITEM -----------------------------------------*/	
	private SimpleLogger logger = new SimpleLogger(PedidoResource.class.getName(), SimpleLogger.CATEGORY_DEBUG);

	
	/**
	 * 
	 * Método responsável por cadastrar Item no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */

	@GET
	//(Long idItem, String nomeProduto, String observacao, double preco, int quantidade, double total ){
	@Path("/cadastraritem/{iditem}/{nomeproduto}/{observacao}/{preco}/{quantidade}/{total}")
	@Produces("application/json")
	public void cadastrarItem(
	
			@PathParam("idpedidoitem") int idpedidoitem,
			@PathParam("iditem") int iditem,
			@PathParam("nomeproduto") String nomeproduto,
			@PathParam("observacao") String observacao,
			@PathParam("preco") double preco,
			@PathParam("quantidade") int quantidade,
			@PathParam("total") double total){
	System.out.println("AAAAAAAAAAAAAAAAAAAAA");	
	   	logger.info("> casdastrarItem() RESOURCE");
		
			System.out.println("idpedido: "+iditem);
			System.out.println("nomeproduto: "+nomeproduto);	
			System.out.println("observacao: "+observacao);
			System.out.println("preco: "+preco);
			System.out.println("quantidade: "+quantidade);
			System.out.println("total: "+total);
			
		 new  PedidoController().cadastrarItem(iditem, nomeproduto, observacao, preco, quantidade, total);
			logger.info("< casdastrarItem() RESOURCE");
			
			
	}
	
	/**
	 * 
	 * Método responsável por deletar Item no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */
	
	@GET
	//excluirItem(Long idItem, String nomeProduto, String observacao, double preco, int quantidade, double total ){
	@Path("/excluiritem/{iditem}/{nomeproduto}/{observacao}/{preco}/{quantidade}/{total}")
	@Produces("application/json")
	public void excluirItem(
				
			@PathParam("iditem") int iditem,
			@PathParam("nomeproduto") String nomeproduto,
			@PathParam("observacao") String observacao,
			@PathParam("preco") double preco,
			@PathParam("quantidade") int quantidade,
			@PathParam("total") double total){
		
		System.out.println(">casdastrarItem()");
		
			System.out.println("idpedido: "+iditem);
			System.out.println("nomeproduto: "+nomeproduto);	
			System.out.println("observacao: "+observacao);
			System.out.println("preco: "+preco);
			System.out.println("quantidade: "+quantidade);
			System.out.println("total: "+total);
			
		 new  PedidoController().excluirItem(iditem, nomeproduto, observacao, preco, quantidade, total);
			System.out.println("<inserirPedido()");
	}
	
	
	
	/**
	 * 
	 * Método responsável por listar todos os items do pedidos no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */
	
	@GET
	@Path("/listarpedidos")
	@Produces("application/json")
	public ArrayList<Item>  listarItems(){
		return (ArrayList<Item>) new PedidoController().listarItem();
	}
	

	
	
/*------------------------------------------- RESOURCE DO PEDIDO -----------------------------------------*/	
	
	
	/**
	 * 
	 * Método responsável por cadastrar Item no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */

	@GET
	
	//public String inserirPedido(Long idpedido, String nomeProduto, int quantidade, double preco){
		
	@Path("/abrirpedido/{idpedido}/{status}")
	@Produces("application/json")
	public void abrirPedido(
			@PathParam("idpedido") int idpedido,
			@PathParam("status") String status){

		System.out.println(">abrirPedido()");
		
			System.out.println("idpedido: "+idpedido);
			System.out.println("status: "+status);	
	
			
		 new  PedidoController().abrirPedido(idpedido, status);
			System.out.println("<abrirPedido()");
			
	}
	
	
	/**
	 * 
	 * Método responsável por cadastrar Item no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */

	@GET	
	@Path("/finalizarpedido")
	@Produces("application/json")
	public void finalizarPedido(){				
		System.out.println(">finalizarPedido()");
		 new  PedidoController().finalizarPedido();
			System.out.println("<finalizarPedido()");
			
	}
	
	

	
	
	
	
	
	
}
