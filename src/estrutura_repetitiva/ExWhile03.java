package estrutura_repetitiva;

import java.util.Scanner;

public class ExWhile03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int alcool=0, gasolina=0, diesel=0;
		System.out.println("Qual o combustivel abastecido?");
		int x = sc.nextInt();
		
		while (x != 4 ) {
			if (x > 4 || x < 1) {
				System.out.println("Opção inválida! Escolha a opção de combustivel correta.");
			}
			else {
				if (x == 1) {
					alcool++;
				}
				if (x == 2) {
					gasolina++;
				}
				if (x == 3) {
					diesel++;
				}
			}
			System.out.println("Qual o combustivel abastecido?");
			x = sc.nextInt();			
		}
		System.out.println("MUITO OBRIGADO!");
		System.out.println("Alcool: " +alcool+"\nGasolina: "+gasolina+"\nDiesel: "+diesel );
		sc.close();
	}

}
