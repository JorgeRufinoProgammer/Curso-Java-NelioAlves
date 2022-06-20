package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class TestaTriangle {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangle obj1 = new Triangle();
		Triangle obj2 = new Triangle();
		
		System.out.println("Quais os valores do primeiro triangulo?");
		obj1.a = sc.nextDouble();
		obj1.b = sc.nextDouble();
		obj1.c = sc.nextDouble();
		
		System.out.println("Quais os valores do segundo triangulo?");
		obj2.a = sc.nextDouble();
		obj2.b = sc.nextDouble();
		obj2.c = sc.nextDouble();
		
		System.out.println("Area Triangulo 1: " + obj1.calculaArea());
		System.out.println("Area Triangulo 2: " + obj2.calculaArea());
		
		if (obj1.calculaArea() > obj2.calculaArea()) {
			System.out.println("Maior é o triangulo 1");
		}
		else {
			System.out.println("Maior é o triangulo 2");
		}
		
		sc.close();
	}

}
