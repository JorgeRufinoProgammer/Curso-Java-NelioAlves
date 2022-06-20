package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.ProductV2;

public class TestaProductV2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter product data: ");
		System.out.println("Name: ");
		String name = sc.next();		
		System.out.println("Price: ");
		double price = sc.nextDouble();
		
		ProductV2 obj = new ProductV2(name, price);
		
		//		System.out.println(obj.toString());
		//Java automaticamente detecta que o objeto "obj" está num contexto de String e automaticamente chama o metodo "toString"
		System.out.println("Product data:" + obj);
		
		System.out.print("\nEnter the number of products to be added in stock:");
		obj.addProducts(sc.nextInt());		
		
		System.out.println("Update data:" + obj);
		
		System.out.print("\nEnter the number of products to be removed from stock:");
		obj.removeProducts(sc.nextInt());		
		
		System.out.println("Update data:" + obj);		
			
		sc.close();

	}

}
