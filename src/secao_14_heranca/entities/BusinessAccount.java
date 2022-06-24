package secao_14_heranca.entities;

public class BusinessAccount extends Account{
	private Double loanLimit;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public void loan (double amount) {
		if (amount <= loanLimit) {
			balance -= amount - 10.0;
		}
	}
	
	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	@Override								//Quando sobrescrever um metodo da SuperClasse, usar o @Override (boa pratica)
	public void withdraw(double amount) {	//Esse metodo deve descontar a taxa de 5.0 mais outra taxa de 2 por ser conta Business
		//balance -= amount + 2.0;			Assim nao funcionaria pois não teria a taxa de 5 de classe Account
		super.withdraw(amount);				//Chama o metodo da superclasse para aproveitar a taxa pois assim será descontado a taxa de 5.0
		balance -=  2.0;					//Desconta mais 2.0
	}
}
