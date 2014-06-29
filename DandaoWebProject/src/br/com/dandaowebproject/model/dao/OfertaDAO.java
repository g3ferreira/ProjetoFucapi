package br.com.dandaowebproject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dandaowebproject.model.bean.Oferta;
import br.com.dandaowebproject.utils.ConnectionFactory;

@SuppressWarnings("unchecked")
public class OfertaDAO {


private EntityManager entityManager;
	
	public OfertaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//---------------------CADASTRAR-----------------------------//
	public void cadastrar(Oferta Oferta){
		entityManager.persist(Oferta);
	}
	//---------------------ALTERAR-----------------------------//
	public void alterar(Oferta Oferta){
		entityManager.merge(Oferta);
	}
	//---------------------EXCLUIR-----------------------------//
	public void excluir(Oferta Oferta){
		entityManager.remove(entityManager.merge(Oferta));
	}
	//---------------------ConsultarId-----------------------------//
	public Oferta consultar(Long idOferta){
		return entityManager.getReference(Oferta.class, idOferta);
	}
	//---------------------ORDENALISTA-----------------------------//
	public List<Oferta> listar(){
		String jpql = "Select t from Oferta t order by idoferta";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
		}

	
	
	
}
