package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int x = sc.nextInt();
		int in = 0, out =0;
		
		for (int i = 0 ; i < x ; i++) {
			int numero = sc.nextInt();
			
			if(numero >= 10 && numero <= 20){
				in++;
			}
			else {
				out++;
			}
		}
		System.out.println("In: " + in + "\nOut: "+out);
		sc.close();

	}

}
