package secao_14_heranca.application;

import java.util.ArrayList;
import java.util.List;

import secao_14_heranca.entities.Account;
import secao_14_heranca.entities.BusinessAccount;
import secao_14_heranca.entities.SavingsAccount;

public class TestaAccount2 {

	public static void main(String[] args) {
		Account account = new Account(1001, "Alex", 1000.0);
		account.withdraw(200.0);					//Aqui foi descontado a taxa de 5.0
		System.out.println(account.getBalance());		
				
		SavingsAccount savAccount = new SavingsAccount(1002,"Maria", 1000.0, 0.01);
		savAccount.withdraw(200.0);					//Aqui nao foi descontada a taxa de 5.0 pois o metodo foi sobrescrito sem ela	
		System.out.println(savAccount.getBalance());	
		
		BusinessAccount busAccount = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		busAccount.withdraw(200);					//Descontado taxa de 5.0 de Account e mais 2.0 da BusinessAccount
		System.out.println(busAccount.getBalance());
		
		List<Account> accList = new ArrayList<>();
		
		accList.add(account);
		accList.add(savAccount);
		accList.add(busAccount);
		
		double sum = 0.0;
		
		for (Account list : accList) {
			sum += list.getBalance();
		}
		System.out.println();
		System.out.println("Total balance: "+ String.format("%.2f", sum));
		
		//Adicionando 10.0 em todas as contas e mostrando a soma de todos os saldos
		sum = 0.0;
		for (Account list : accList) {
			list.deposit(10.0);
			sum += list.getBalance();
		}
		
		System.out.println();
		System.out.println("Update balance: "+ String.format("%.2f", sum));
	}

}
