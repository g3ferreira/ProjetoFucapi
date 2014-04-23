package br.com.dandaowebproject.model.bean;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Pedido {

	  @Id
	  @GeneratedValue
	  private int idpedido;
	  private Calendar dataCadastro;
      @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	  private Collection<PedidoItem> pedidoItemList;
      private double totalPedido;
	      private String status;
	      
     public static  ArrayList<PedidoItem> listaPedidos = new ArrayList<PedidoItem>();

      private static Pedido instance;
		
  	public static void setInstance(Pedido instance) {
		Pedido.instance = instance;
	}

	public static Pedido getInstance(){
  		if(instance == null)
  			instance = new Pedido();
  		return instance;
  	}
      

  	
      
    public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public double getTotalPedido() {
		return totalPedido;
	}


	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}


	public int getIdPedido() {
		return idpedido;
	}


	public void setIdPedido(int id) {
		this.idpedido = id;
	}


	public Calendar getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Collection<PedidoItem> getPedidoList() {
		return pedidoItemList;
	}


	public void setPedidoItemList(Collection<PedidoItem> pedidoItemList) {
		this.pedidoItemList = pedidoItemList;
	}
	
	
	
}
