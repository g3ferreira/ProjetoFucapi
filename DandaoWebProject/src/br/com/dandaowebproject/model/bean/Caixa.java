package br.com.dandaowebproject.model.bean;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Caixa {
	@Id
	@GeneratedValue
	private Long idCaixa;

	@Temporal(TemporalType.DATE)
	private Calendar dataAbertura;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFechamento;
	
	private double valorAbertura;
	private double valorAtual;
	
	private double valorFinalCaixa;
	
	private static Caixa instance;
	private String status;
		


		public static void setInstance(Caixa instance) {
			Caixa.instance = instance;
		}

		public static Caixa getInstance(){
	  		if(instance == null)
	  			instance = new Caixa();
	  		return instance;
	  	}

	
	
	
	public Long getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Calendar getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public double getValorAbertura() {
		return valorAbertura;
	}
	public void setValorAbertura(double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}
	public double getValorFinalCaixa() {
		return valorFinalCaixa;
	}
	public void setValorFinalCaixa(double valorFinalCaixa) {
		this.valorFinalCaixa = valorFinalCaixa;
	}
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
  	public String getStatus() {
	return status;
  	}

  	public void setStatus(String status) {
	this.status = status;
  	}
	
}
