package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class TestaProduct {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product obj = new Product();
		System.out.println("Enter product data: ");
		System.out.println("Name: ");
		obj.name = sc.next();
		System.out.println("Quantity: ");
		obj.quantity= sc.nextInt();
		System.out.println("Price: ");
		obj.price = sc.nextDouble();
		
		//		System.out.println(obj.toString());
		//Java automaticamente detecta que o objeto "obj" está num constexto de String e automaticamente chama o metodo "toString"
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
