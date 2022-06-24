package secao_14_heranca.entities;

public class SavingsAccount extends Account{	//CONTA POUPANÇA
	private Double interestRate;				//Taxa de juros
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public void updateBalance()	{				//Atualizar o saldo da Conta com base na taxa de Juros
		balance += balance * interestRate;		//Saldo recebe ele mesmo + saldo vezes a taxa de juros
	}
	
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
						
	@Override								//Quando sobrescrever um metodo da SuperClasse, usar o @Override (boa pratica)
	public void withdraw(double amount) {	//SavingsAccount nao devem ter a taxa de Saque, logo o metodo foi sobrescrito
		balance -= amount;
	}
	
}
