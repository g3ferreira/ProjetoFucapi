package br.com.dandaolanches.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaolanches.model.bean.Cardapio;
@SuppressWarnings("unchecked")
public class CardapioDAO {

	private EntityManager entityManager;
	
	public CardapioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Cardapio cardapio){
		entityManager.persist(cardapio);
	}
	public void alterar(Cardapio cardapio){
		entityManager.merge(cardapio);
	}
	public void excluir(Cardapio cardapio){
		entityManager.remove(entityManager.merge(cardapio));
	}
	
	public Cardapio consultar(Long id){
		return entityManager.getReference(Cardapio.class, id);
	}
	
	public List<Cardapio> listar(){
		String jpql = "Select p from Cardapio p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
