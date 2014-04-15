package br.com.dandaowebproject.model.bean;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@XmlRootElement
public class Pedido {

	@Id
	private Long idpedido;
	private String nomeproduto;
	private int quantidade;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPedido;
	private double preco;
	
	
	public Long getIdPedido() {
		return idpedido;
	}
	public void setIdPedido(Long id) {
		this.idpedido = id;
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
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}	
	
	
	
	@Override
	public String toString() {
		return "Frase [idpedido=" + idpedido+ ", nomeproduto=" + nomeproduto + ", quantidade=" + quantidade +  ", preco=" + preco + ", datapedido=" +dataPedido+ "]";
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
		
		Pedido other = (Pedido) obj;
		
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
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
		
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!(dataPedido == other.dataPedido))
			return false;
		
		if (preco == 0) {
			if (other.preco != 0)
				return false;
		} else if (!(preco == other.preco))
			return false;
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}

