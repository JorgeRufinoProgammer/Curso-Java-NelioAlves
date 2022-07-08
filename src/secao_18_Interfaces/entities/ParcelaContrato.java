package secao_18_Interfaces.entities;

public class ParcelaContrato {
	private int quantidadeParcelas;
	private double valorParcela;
	
	public ParcelaContrato(int quantidadeParcelas) {		
		this.quantidadeParcelas = quantidadeParcelas;		
	}

	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public double getValorParcela() {				
		return valorParcela;
	}

	public void setValorParcela(double valorContrato, int numeroParcela) {
		double valorBase = valorContrato / quantidadeParcelas;
		valorParcela = valorBase +  valorBase * 0.01 * numeroParcela;	
	}
		
}
