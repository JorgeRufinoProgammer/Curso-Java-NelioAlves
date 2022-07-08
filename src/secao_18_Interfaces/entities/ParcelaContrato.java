package secao_18_Interfaces.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParcelaContrato {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dataParcela;
	private double valorParcela;
	
	public ParcelaContrato() {}

	public ParcelaContrato(Date dataParcela, double valorParcela) {		
		this.dataParcela = dataParcela;
		this.valorParcela = valorParcela;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}	
	
	@Override
	public String toString() {
		return sdf.format(dataParcela) + " - R$" + String.format("%.2f", valorParcela)  ;
	}
}
