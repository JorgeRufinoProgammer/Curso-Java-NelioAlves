package entities;

public class Account {
	private final double TAX = 0.005; //taxa de 0,5% por valor de saque
	private String holder;
	private int number;
	private double balance;
	
	public Account () {					
	}
	
	public Account(String holder, int number, double balance) {
		
		this.holder = holder;
		this.number = number;
		this.balance = balance;
	}
	
	public Account(String holder, int number) {
		
		this.holder = holder;
		this.number = number;		
	}
	
	public void deposit (double value) {
		balance += value;
	}
	public void withdraw (double value) {
		balance -= value + (value * TAX);
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String toString() {
		return "Account "
				+number
				+", Holder: "
				+holder
				+", Balance: $"
				+String.format("%.2f", balance);
	}
}
