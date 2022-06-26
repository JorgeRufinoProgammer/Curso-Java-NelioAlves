package secao_14_heranca.entities;

public class PessoaFisica extends Contribuinte{

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double impostoPagar() {
		double imposto = 0.0;	
		if (getRendaAnual() < 20000) {
			imposto += getRendaAnual() * 0.15; 
		}
		else {
			imposto += getRendaAnual() * 0.25;
		}
		if(getGastosSaude() > 0) {
			imposto -= getGastosSaude() * 0.5; 
		}
		return imposto;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
}
