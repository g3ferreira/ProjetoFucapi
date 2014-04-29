package br.com.dandaowebproject.control.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.dandaowebproject.model.bean.Caixa;
import br.com.dandaowebproject.model.bean.Cardapio;
import br.com.dandaowebproject.model.bean.Pedido;
import br.com.dandaowebproject.model.dao.CaixaDAO;
import br.com.dandaowebproject.model.dao.CardapioDAO;
import br.com.dandaowebproject.model.dao.JPAUtil;

@ViewScoped
@ManagedBean
public class CaixaController {

public List<Caixa> listaCaixa = new ArrayList<Caixa>();
	
	
	public List<Caixa> getListaCaixa() {
	return listaCaixa;
}

public void setListaCaixa(List<Caixa> listaCaixa) {
	this.listaCaixa = listaCaixa;
}

	public List<Caixa> getListaCardapio() {
		return listaCaixa;
	}
	
	//------------------------------------------------------------------------//
	private Caixa caixa = new Caixa();


	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	//----------------------------------------------------------------------//
	
	public void carregarCaixa(){
		EntityManager em = JPAUtil.getEntityManagerCaixa();
		CaixaDAO dao = new CaixaDAO(em);
		listaCaixa = dao.listar();
		em.close();
		
	} 
	
	//-----------------------------------------------------------------------//
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManagerCaixa();
		CaixaDAO dao = new CaixaDAO(em);
		em.getTransaction().begin();
		dao.excluir(caixa);
		em.getTransaction().commit();
		em.close();
		carregarCaixa();
	}
	//----------------------------------------------------------------------//
		public void salvar(){
		System.out.println("ENTROUUUUUUUU");
		EntityManager em = JPAUtil.getEntityManagerCaixa();
		CaixaDAO dao = new CaixaDAO(em);
		em.getTransaction().begin();
		caixa.setDataAbertura(Calendar.getInstance());
		if(caixa.getIdCaixa()!=null){
			dao.alterar(caixa);
		}else{
			dao.cadastrar(caixa);
		}
		em.getTransaction().commit();
		em.close();
		caixa  = new Caixa();
		carregarCaixa();
	}
	//--------------------------------------------------------------------//
	
	
}
