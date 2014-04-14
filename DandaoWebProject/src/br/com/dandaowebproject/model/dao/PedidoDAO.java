package br.com.dandaowebproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import br.com.dandaowebproject.model.bean.Pedido;

@SuppressWarnings("unchecked")
public class PedidoDAO {

	private EntityManager entityManager;
	private static PedidoDAO instance;
	
	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
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
	
	
//	public ArrayList<Pedido> listarTodos(){
//		Connection conexao = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<Pedido> pedidos = null;
//		
//		conexao = criarConexao();
//		pedidos = new ArrayList<Pedido>();
//		try {
//			pstmt = conexao.prepareStatement("select * from frases order by id desc");
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				Pedido pedido = new Pedido();
//				
//				pedido.setIdPedido(rs.getLong("idpedido"));
//				pedido.setNomeProduto(rs.getString("nomeproduto"));
//				pedido.setQuantidade(rs.getInt("quantidade"));
//				pedido.setQuantidade(rs.getInt("preco"));
//				pedido.setQuantidade(rs.getInt("total"));
//				
//				
//				pedidos.add(pedido);
//			}
//			
//		} catch (Exception e) {
//			System.out.println("Erro ao listar todas frases: " + e);
//			e.printStackTrace();
//		} finally {
//			fecharConexao(conexao, pstmt, rs);
//		}
//		return pedidos;
//	}
//	

	public String inserirPedido(Long idpedido, String nomeProduto, int quantidade, double preco){
	Pedido pedido = new Pedido();
		
	pedido.setIdPedido(idpedido);
	pedido.setNomeProduto(nomeProduto);
	pedido.setQuantidade(quantidade);
	pedido.setPreco(preco);
System.out.println(	"ID: "+pedido.getIdPedido()+
"nome Podruto: "+	pedido.getNomeProduto()+
"nome Quantidade: "+	pedido.getQuantidade()+
"nome Preco: "+	pedido.getPreco()
);
	cadastrar(pedido);
	
		
//		Connection conexao = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		conexao = criarConexao();
//		try {
//            String InsertComand = "insert into pedido (idpedido , nomeproduto, quantidade, preço) values (nextval('id'),'" +
//            		idpedido + "','" + nomeProduto+ "','" + quantidade+"','" + preco+"');";
//
//			pstmt = conexao.prepareStatement(InsertComand);
//			rs = pstmt.executeQuery();
//			System.out.println("RESULTADO DO INSERT: "+rs);
////			while(rs.next()){
////				Pedido pedido = new Pedido();
////				
////				pedido.setIdPedido(rs.getLong("idpedido"));
////				pedido.setNomeProduto(rs.getString("nomeproduto"));
////				pedido.setQuantidade(rs.getInt("quantidade"));
////				pedido.setQuantidade(rs.getInt("preco"));
////				pedido.setQuantidade(rs.getInt("total"));
////				
////			}
//			
//		} catch (Exception e) {
//			System.out.println("Erro ao listar todas frases: " + e);
//			e.printStackTrace();
//		} finally {
//			fecharConexao(conexao, pstmt, rs);
//		}

	
	
	
	return "SUCESS";
	}
	
	
	
}


