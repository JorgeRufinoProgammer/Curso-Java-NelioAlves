package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int x = sc.nextInt();
		
		if (x >= 1 && x <= 1000) {
			for(int i =1; i <= x; i++) {
				if (i % 2 == 0) {
					System.out.println("Par: "+i);
				}
				else {
				//	System.out.println("Ímpar: "+i);
				}
			}
		}
		else {
			System.out.println("numero fora do padrão!");
		}
		
		sc.close();

	}

}
