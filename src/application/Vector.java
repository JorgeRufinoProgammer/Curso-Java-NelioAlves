package application;

import java.util.Locale;
import java.util.Scanner;

import entities.ProductV2;

public class Vector {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos produtos?");
		int n = sc.nextInt();
		sc.nextLine();
		
		ProductV2[] vect = new ProductV2[n];	//cria um vector de objeto/referencia da classe ProductV2 com o tamanho de N
		
		for (int i = 0; i < vect.length; i++) {
			System.out.println("\nQual o nome do produto?");
			String name = sc.next();
			System.out.println("Qual o preço do "+name+"?");
			double price = sc.nextDouble();
			vect[i] = new ProductV2(name, price, 0);
		}
		
		double soma = 0.0;
		
		for (int i = 0; i < vect.length; i++) {
			soma += vect[i].getPrice();
			System.out.println("Produto: "+vect[i].getName() + ", Preço: "+ String.format("%.2f", vect[i].getPrice()));
		}
		
		double media = soma / vect.length;
		System.out.println("Media dos preços: " + String.format("%.2f", media));
		sc.close();

	}

}
