package br.com.dandaowebproject.resource;

import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.dandaowebproject.control.mb.PedidoController;
import br.com.dandaowebproject.model.bean.Pedido;

@Path("/pedido")
public class PedidoResource {

	/**
	 * 
	 * Método responsável por inserir pedido no DB
	 *
	 * @return ArrayList<Cliente> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 19/01/2014 
	 * @version 1.0
	 */

	@GET
	@Path("/inserirPedido/{idpedido}/{nomeproduto}/{quantidade}/{preco}")
	@Produces("application/json")
	public void inserirPedido(
			@PathParam("idpedido") Long idpedido,
			@PathParam("nomeproduto") String nomeproduto,
			@PathParam("quantidade") int quantidade,
			@PathParam("preco") double preco){
			System.out.println("idpedido: "+idpedido);
			System.out.println("nomeproduto: "+nomeproduto);	
			System.out.println("quantidade: "+quantidade);
			System.out.println("preco: "+preco);
		 //return new PedidoController().inserirPedidos(idpedido, nomeproduto,quantidade,preco);
		 new  PedidoController().salvar(idpedido, nomeproduto,quantidade,preco);
			  
	}
	
	/**
	 * 
	 * Método responsável por deletar pedido no DB
	 *
	 * @return ArrayList<Cliente> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 19/01/2014 
	 * @version 1.0
	 */
	
	@GET
	@Path("/excluirpedido/{idpedido}/{nomeproduto}/{quantidade}/{preco}")
	@Produces("application/json")
	public void excluirPedido(
				
			@PathParam("idpedido") Long idpedido,
			@PathParam("nomeproduto") String nomeproduto,
			@PathParam("quantidade") int quantidade,
			@PathParam("preco") double preco){
		
		System.out.println(">excluirPedido()");
			System.out.println("idpedido: "+idpedido);
			System.out.println("nomeproduto: "+nomeproduto);	
			System.out.println("quantidade: "+quantidade);
			System.out.println("preco: "+preco);
		 //return new PedidoController().inserirPedidos(idpedido, nomeproduto,quantidade,preco);

			System.out.println("< excluirPedido()");
		 new  PedidoController().excluir(idpedido, nomeproduto,quantidade,preco);
	}
	
	
	
	/**
	 * 
	 * Método responsável por listar todos os pedidos no DB
	 *
	 * @return ArrayList<Cliente> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 19/01/2014 
	 * @version 1.0
	 */
	
	@GET
	@Path("/listarpedidos")
	@Produces("application/json")
	public ArrayList<Pedido>  listarPedido(){
		return (ArrayList<Pedido>) new PedidoController().listarPedido();
	}
	

}
