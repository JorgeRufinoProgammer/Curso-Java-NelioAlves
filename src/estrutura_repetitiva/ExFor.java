package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int x = sc.nextInt();
		
		int soma = 0;
		
		for(int i =0; i < x; i++) {			
			int y = sc.nextInt();
			soma = soma + y;
		}
		System.out.println("Soma: "+soma);
		sc.close();
	}

}
