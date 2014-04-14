package br.com.dandaowebproject.model.bean;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
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
}

