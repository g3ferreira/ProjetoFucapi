package br.com.dandaowebproject.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Caixa;
import br.com.dandaowebproject.model.bean.Cardapio;

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
	

}
