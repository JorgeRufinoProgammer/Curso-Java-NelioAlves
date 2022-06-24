package secao_14_heranca.application;

import secao_14_heranca.entities.Account;
import secao_14_heranca.entities.BusinessAccount;
import secao_14_heranca.entities.SavingsAccount;

public class TestaAccount {			//Classe Exemplo de Upcasting e Downcasting

	public static void main(String[] args) {
		Account acc = new Account(1001,"Alex", 0.0);
		BusinessAccount bAcc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//UPCASTING (Converter um objeto da subclasse para a super classe)
		
		Account acc1 = bAcc;					//Uma BusinessAccount é uma Account, logo é possivel
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);	//SavingsAccount tb é uma Account, logo isto tb é possível
		
		//DOWNCASTING (Converter um objeto da superclasse para a subclasse)
		
		//BusinessAccount bAcc1 = acc2; 	Isto não é possível pois não se pode converter naturalmente um objeto da Superclasse p/ Subclasse
		//E por mais que o objeto "acc2" tenha sido criado como BusinessAccount, ele é um objeto Account 
		//Mas podemos forçar essa converção usando (Nome_Subclasse) antes do objeto
		BusinessAccount bAcc1 = (BusinessAccount)acc2;			
		bAcc1.loan(100.0);
		//acc2.loan(100.0);			Isto não é possivel pois acc2 não é do tipo BusinessAccount	
		
		//BusinessAccount bAcc2 = (BusinessAccount)acc3;	Não é possivel pois acc3 é um SavingsAccount
		
		if (acc3 instanceof BusinessAccount) {			//Se o acc3 for uma instancia de BusinessAccount
			BusinessAccount bAcc2 = (BusinessAccount)acc3;
			bAcc2.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingsAccount) {			//Se o acc3 for uma instancia de SavingAccount
			SavingsAccount sAcc = (SavingsAccount)acc3;
			sAcc.updateBalance();
			System.out.println("Update!");
		}
	}

}
