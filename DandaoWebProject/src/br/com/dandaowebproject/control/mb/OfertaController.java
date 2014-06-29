package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import br.com.dandaowebproject.model.bean.Oferta;
import br.com.dandaowebproject.model.dao.JPAUtil;
import br.com.dandaowebproject.model.dao.OfertaDAO;

@ViewScoped
@ManagedBean
public class OfertaController {

	private Oferta oferta = new Oferta();
	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public List<Oferta> listaOferta = new ArrayList<Oferta>();

	public List<Oferta> getListaOferta() {
		return listaOferta;
	}

	public void setListaOferta(List<Oferta> listaOferta) {
		this.listaOferta = listaOferta;
	}
	

	@PostConstruct
	public void carregarOfertas(){
		EntityManager em = JPAUtil.getEntityManagerOferta();
		OfertaDAO dao = new OfertaDAO(em);
		listaOferta = dao.listar();
		em.close();
		
	} 
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManagerOferta();
		OfertaDAO dao = new OfertaDAO(em);
		em.getTransaction().begin();
		dao.excluir(oferta);
		em.getTransaction().commit();
		em.close();
		carregarOfertas();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManagerOferta();
		OfertaDAO dao = new OfertaDAO(em);
		em.getTransaction().begin();
		oferta.setDataCadastro(Calendar.getInstance());
		if(oferta.getIdoferta()!=null){
			dao.alterar(oferta);
		}else{
			dao.cadastrar(oferta);
		}
		em.getTransaction().commit();
		em.close();
		oferta  = new Oferta();
		carregarOfertas();
	}
	
	
}
