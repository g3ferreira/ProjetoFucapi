package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.dandaowebproject.model.dao.CardapioDAO;
import br.com.dandaowebproject.model.dao.JPAUtil;
import br.com.dandaowebproject.model.bean.Cardapio;


@ViewScoped
@ManagedBean
public class CardapioController {

	
	public List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
	
	
	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}


	private Cardapio cardapio = new Cardapio();

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	


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
		System.out.println("ENTROUUUUUUUU");
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

