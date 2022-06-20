package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class TestAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Account account = null;
		
		System.out.print("Enter account number:");
		int number = sc.nextInt();
		System.out.print("Enter account holder:");
		sc.nextLine();
		String holder = sc.nextLine();		
		System.out.println("Is there an initial deposit (y/n)?");
		char response = sc.next().charAt(0);
		boolean aux = true;
		
		while (aux) {
			if(response == 'y') {
				System.out.println("Enter initial deposit value:");
				double deposit = sc.nextDouble();
				account = new Account(holder, number, deposit);
				aux = false;
			}
			else if (response == 'n'){
				account = new Account(holder, number);
				aux = false;
			}		
			else {
				System.out.println("Code wrong! Try again.");
				System.out.println("Is there an initial deposit (y/n)?");
				response = sc.next().charAt(0);				
			}
		}
					
		System.out.println();
		System.out.println("Account data:");
		System.out.println(account);
		
		System.out.println();
		System.out.println("Enter a deposit value:");
		account.deposit(sc.nextDouble());
		System.out.println("Update account data:");
		System.out.println(account);
		
		System.out.println();
		System.out.println("Enter a withdraw value:");
		account.withdraw(sc.nextDouble());
		System.out.println("Update account data:");
		System.out.println(account);
		
		sc.close();

	}

}
