package br.com.dandaowebproject.model.bean;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@XmlRootElement
public class Item{

	@Id
	private int idtem;	
	private String nomeproduto; 
	private int quantidade;
	private double preco;
	private String observacao;
	private double total;

	   private static Item instance;
		
	  	public static void setInstance(Item instance) {
			Item.instance = instance;
		}

		public static Item getInstance(){
	  		if(instance == null)
	  			instance = new Item();
	  		return instance;
	  	}
	      

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	  private Collection<PedidoItem> pedidoItemList;


	public Collection<PedidoItem> getPedidoItemList() {
		return pedidoItemList;
	}
	public void setPedidoItemList(Collection<PedidoItem> pedidoItemList) {
		this.pedidoItemList = pedidoItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getIdItem() {
		return idtem;
	}
	public void setIdItem(int id) {
		this.idtem = id;
	}
	public String getNomeProduto() {
		return nomeproduto;
	}
	public void setNomeProduto(String nome) {
		this.nomeproduto = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	
	
	
	@Override
	public String toString() {
		return "Frase [idtem=" + idtem+ ", nomeproduto=" + nomeproduto + ", quantidade=" + quantidade +  ", preco=" + preco + ", observacao=" +observacao+", total=" +total+"]";
	}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		
//		result = prime * result + ((quantidade == 0) ? 0 : quantidade. hashCode());
//		result = prime * result	+ ((frase == null) ? 0 : frase.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result	+ ((frase == null) ? 0 : frase.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		
//		
//		
//		return result;
//	}
//	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Item other = (Item) obj;
		
		if (idtem == 0) {
			if (other.idtem != 0)
				return false;
		} else if (!(idtem == other.idtem))
			return false;
		
		
		if (nomeproduto == null) {
			if (other.nomeproduto != null)
				return false;
		} else if (!nomeproduto.equals(other.nomeproduto))
			return false;
		
		if (quantidade == 0) {
			if (other.quantidade != 0)
				return false;
		} else if (!(quantidade == other.quantidade))
			return false;
	
		
		if (preco == 0) {
			if (other.preco != 0)
				return false;
		} else if (!(preco == other.preco))
			return false;
		
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		
		if (total == 0) {
			if (other.total != 0)
				return false;
		} else if (!(total == other.total))
			return false;
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}

