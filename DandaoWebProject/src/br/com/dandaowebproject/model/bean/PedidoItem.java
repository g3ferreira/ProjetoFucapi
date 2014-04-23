package br.com.dandaowebproject.model.bean;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PedidoItem {


	 private static PedidoItem instance;
	 
	  @Id
	  @GeneratedValue
	  private int idpedidoitem;
	  @ManyToOne
	  @JoinColumn(name = "idpedido_fk")
	  private Pedido pedido;

	  @ManyToOne
	  @JoinColumn(name = "iditem_fk")
	  private Item item;
	  
   	public Calendar getDataCadastro() {
		return dataCadastro;
	   }

		
	  	public static void setInstance(PedidoItem instance) {
	  		PedidoItem.instance = instance;
		}

		public static PedidoItem getInstance(){
	  		if(instance == null)
	  			instance = new PedidoItem();
	  		return instance;
	  	}
	
	
	  
	  
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Temporal(TemporalType.DATE)
		private Calendar dataCadastro;
	  

	  public int getIdpedidoitem() {
		return idpedidoitem;
	}

	public void setIdpedidoitem(int idpedidoitem) {
		this.idpedidoitem = idpedidoitem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


	
	
	
}
