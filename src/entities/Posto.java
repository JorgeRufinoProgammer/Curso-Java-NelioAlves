package entities;

public class Posto {	
	private double preco = 6.85;
	private double quantLitros, quantReais;
		
	public void abastecerDinheiro(double value) {
		quantLitros = value / preco;
	}
	
	public void abastecerLitros(double value) {
		quantReais = value * preco;
	}
	
	public double getquantiLitros() {
		return quantLitros;
	}
	
	public double getquantiDinheiro() {
		return quantReais;
	}
	
	public String toString() {
		String retorno = "";
		if (quantLitros > 0) {
			retorno = "Foi abastecido com " + String.format("%.2f", quantLitros) + "L"; 
		}
		else {
			retorno = "Foi abastecido com R$" + String.format("%.2f", quantReais) + " reais";
		}
		return retorno;
	}
}
