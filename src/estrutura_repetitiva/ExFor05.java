package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int fatorial = 1;
		for(int i =x; i > 0; i--) {
			fatorial = fatorial * i;
		}
		System.out.println("Fatorial: "+fatorial);
		sc.close();
	}

}
