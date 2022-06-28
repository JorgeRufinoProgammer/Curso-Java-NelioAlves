package secao_15_Exceptions.entities;

import secao_15_Exceptions.exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withdrawLimit;
	
	public Account() {}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit (Double amount) {
		this.balance += amount;
	}
	
	public void withdraw (Double amount) throws DomainException{
		if (amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (getBalance() == 0 || amount > getBalance()) {
			throw new DomainException("Not enough balance");
		}
		this.balance -= amount;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
}
