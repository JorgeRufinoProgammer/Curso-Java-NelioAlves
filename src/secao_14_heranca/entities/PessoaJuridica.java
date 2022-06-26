package secao_14_heranca.entities;

public class PessoaJuridica extends Contribuinte{

	private int quantFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, int quantFuncionarios) {
		super(nome, rendaAnual);
		this.quantFuncionarios = quantFuncionarios;
	}

	@Override
	public double impostoPagar() {
		double imposto = 0.0;
		
		if(quantFuncionarios <= 10) {
			imposto += getRendaAnual() * 0.16;
		}
		else {
			imposto += getRendaAnual() * 0.14; 
		}
		
		return imposto;
	}

	public int getQuantFuncionarios() {
		return quantFuncionarios;
	}

	public void setQuantFuncionarios(int quantFuncionarios) {
		this.quantFuncionarios = quantFuncionarios;
	}
	
}
