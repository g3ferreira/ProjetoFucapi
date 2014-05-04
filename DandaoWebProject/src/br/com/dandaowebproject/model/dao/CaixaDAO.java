package br.com.dandaowebproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Caixa;
import br.com.dandaowebproject.model.bean.Cardapio;
import br.com.dandaowebproject.utils.ConnectionFactory;

@SuppressWarnings("unchecked")
public class CaixaDAO {
	
private EntityManager entityManager;
	
	public CaixaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//---------------------CADASTRAR-----------------------------//
	public void cadastrar(Caixa caixa){
		entityManager.persist(caixa);
	}
	//---------------------ALTERAR-----------------------------//
	public void alterar(Caixa caixa){
		entityManager.merge(caixa);
	}
	//---------------------EXCLUIR-----------------------------//
	public void excluir(Caixa caixa){
		entityManager.remove(entityManager.merge(caixa));
	}
	//---------------------ConsultarId-----------------------------//
	public Caixa consultar(Long idCaixa){
		return entityManager.getReference(Caixa.class, idCaixa);
	}
	//---------------------ORDENALISTA-----------------------------//
	public List<Caixa> listar(){
		String jpql = "Select t from Caixa t order by idCaixa";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
		}
	//----------------------OrdenanValorAtual---------------------//

	public double valorTotalCaixa(){
		
		ConnectionFactory conn = new ConnectionFactory();
		
			Connection conexao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String result = null;
			conexao = conn.criarConexao();
			try {
				pstmt = conexao.prepareStatement("Select sum(totalpedido) as resultado from Pedido where status = 'PG'");
				rs = pstmt.executeQuery();
				
				while(rs.next()){
						result = rs.getString("resultado");
				}
				
			} catch (Exception e) {
				System.out.println("Erro : " + e);
				e.printStackTrace();
			} finally {
				conn.fecharConexao(conexao, pstmt, rs);
			}
			System.out.println("resultado: DAOOO "+Double.valueOf(result));
				return Double.valueOf(result);
		
		}

	 
	
}
