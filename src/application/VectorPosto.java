package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Posto;

public class VectorPosto {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos carros serão abastecidos?");
		int n = sc.nextInt();
		Posto[] vect = new Posto[n];
		
		for (int i = 0; i < vect.length; i++) {
			System.out.println("Dinheiro ou Quantidade(1/2)? ");
			char resposta = sc.next().charAt(0);
			
			if (resposta == '1') {
				System.out.println("Qual o valor a ser abastecido?");
				double dinheiro = sc.nextDouble();
				
				vect[i] = new Posto();
				vect[i].abastecerDinheiro(dinheiro);
			}
			else {
				System.out.println("Quantos litros a serem abastecidos?");
				double quantidade = sc.nextDouble();
				
				vect[i] = new Posto();
				vect[i].abastecerLitros(quantidade);
			}
		}
		
		for (int i = 0; i < vect.length; i++) {
			System.out.println("Carro "+ (i+1) + ": "+vect[i]);
		}
		
		sc.close();
	}

}
