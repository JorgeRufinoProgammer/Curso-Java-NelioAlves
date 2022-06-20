package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int l2 = 1, l3 = 1;
		
		for (int i = 1; i <= x; i++) {
			l2 = i * i;
			l3 = i * i * i;
			
			System.out.println(i + " "+l2+" "+l3);
		}
		
		sc.close();
	}

}
