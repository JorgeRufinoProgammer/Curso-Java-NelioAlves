package estrutura_repetitiva;

import java.util.Scanner;

public class ExFor03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int x = sc.nextInt();
		double p1=2,p2=3,p3=5;
		
		for (int i = 0 ; i < x ; i++) {
			double x1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			
			double mediaPonderada = (x1*p1 + x2*p2 + x3*p3) / (p1+p2+p3);
			System.out.printf("Media Ponderada: %.1f%n", mediaPonderada);
		}
		
		sc.close();
	}

}
