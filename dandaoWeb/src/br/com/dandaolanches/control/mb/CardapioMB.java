 package br.com.dandaolanches.control.mb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.dandaolanches.model.bean.Cardapio;
import br.com.dandaolanches.model.dao.CardapioDAO;
import br.com.dandaolanches.model.dao.JPAUtil;

@ViewScoped
@ManagedBean
public class CardapioMB {
	//Atributos devem ser iniciados
	private Cardapio cardapio = new Cardapio();
		
	
	public Cardapio getCardapio() {
		return cardapio;
	}
	
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	
	//Atributo que guarda a colecao produtos armazenados em BD
	public List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
	
	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarCardapio(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		listaCardapio = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		em.getTransaction().begin();
		dao.excluir(cardapio);
		em.getTransaction().commit();
		em.close();
		carregarCardapio();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		em.getTransaction().begin();
		cardapio.setDataCadastro(Calendar.getInstance());
		if(cardapio.getId()!=null){
			dao.alterar(cardapio);
		}else{
			dao.cadastrar(cardapio);
		}
		em.getTransaction().commit();
		em.close();
		cardapio  = new Cardapio();
		carregarCardapio();
	}
}
