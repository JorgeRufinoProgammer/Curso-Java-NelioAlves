package secao_15_Exceptions.application;

import java.util.Locale;
import java.util.Scanner;

import secao_15_Exceptions.entities.Account;
import secao_15_Exceptions.exception.DomainException;

public class TestaAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		
		try {				
			System.out.println("Enter account data:");
			System.out.print("Number:");
			Integer number = sc.nextInt();
			System.out.print("Holder:");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance:");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit:");
			Double withdraw = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdraw);
			
			System.out.println();
			System.out.print("Enter amount for withdraw:");
			Double amout = sc.nextDouble();
			
			account.withdraw(amout);
			System.out.println("New balance: "+String.format("%.2f", account.getBalance()));
			
			System.out.println();
			System.out.print("Enter amount for withdraw:");
			amout = sc.nextDouble();
			
			account.withdraw(amout);
			System.out.println("New balance: "+String.format("%.2f", account.getBalance()));
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
