import java.util.Scanner;
import java.util.Locale;

public class Exercicio03 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double teste = 1.12345678;
		/*
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();

			double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;

			System.out.printf("%.1f%n", media);
		}
		*/
		System.out.printf("Uma casa decimal: %.1f%n2 casas decimais: %.2f%n3 casas decimais: %.3f", teste, teste, teste);
		sc.close();

	}

}
