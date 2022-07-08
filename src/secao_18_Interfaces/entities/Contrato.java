package secao_18_Interfaces.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private int numero;
	private Date data;
	private Double valor;
	
	private List<ParcelaContrato> parcelaContrato = new ArrayList<>();
	public Contrato() {}

	public Contrato(int numero, Date data, Double valor) {		
		this.numero = numero;
		this.data = data;
		this.valor = valor;		
	}

	public void addParcela(ParcelaContrato parcelaContrato) {
		this.parcelaContrato.add(parcelaContrato);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<ParcelaContrato> getParcelaContrato() {
		return parcelaContrato;
	}	
}
