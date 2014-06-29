package br.com.dandaowebproject.model.bean;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Oferta {

@Id
@GeneratedValue
private Long idoferta;
@Temporal(TemporalType.DATE)
private Calendar dataCadastro;
private String nomeOferta;
private double preco; 
private String produto;

public Long getIdoferta() {
	return idoferta;
}
public void setIdoferta(Long idoferta) {
	this.idoferta = idoferta;
}
public Calendar getDataCadastro() {
	return dataCadastro;
}
public void setDataCadastro(Calendar dataCadastro) {
	this.dataCadastro = dataCadastro;
}
public String getNomeOferta() {
	return nomeOferta;
}
public void setNomeOferta(String nomeOferta) {
	this.nomeOferta = nomeOferta;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
public String getProduto() {
	return produto;
}
public void setProduto(String produto) {
	this.produto = produto;
}



}
