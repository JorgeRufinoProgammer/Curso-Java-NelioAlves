package estrutura_repetitiva;

import java.util.Scanner;

public class ExWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Valor de X: ");
		int x = sc.nextInt();
		
		System.out.println("Valor de Y: ");
		int y = sc.nextInt();
		
		while (x != 0 && y != 0) {
			if (x > 0 && y > 0) {
				System.out.println("Primeiro quadrante");
			}
			else if (x > 0 && y < 0) {
				System.out.println("Quarto quadrante");
			}
			else if (x < 0 && y < 0) {
				System.out.println("Terceiro quadrante");
			}
			else if (x < 0 && y > 0) {
				System.out.println("Segundo quadrante");
			}
			
			System.out.println("Valor de X: ");
			x = sc.nextInt();
			
			System.out.println("Valor de Y: ");
			y = sc.nextInt();
		}
		sc.close();
	}

}
