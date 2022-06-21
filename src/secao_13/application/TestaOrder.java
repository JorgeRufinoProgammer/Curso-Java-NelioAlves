package secao_13.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.OrderStatus;
import secao_13.entities.Client;
import secao_13.entities.Order;
import secao_13.entities.OrderItem;
import secao_13.entities.Product;

public class TestaOrder {

	public static void main(String[] args) throws ParseException {		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		System.out.println("Enter cliente data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();		
		System.out.print("Birth data (DD/MM/YYYY):");
		Date birthDay = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDay);
		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = sc.next();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.print("\nHow many items to this order?");
		int n = sc.nextInt();
		
		for (int i =0; i < n; i++) {
			System.out.println("Enter #"+ (i+1)+ " item data:");
			System.out.print("Product name:");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price:");
			double productPrice= sc.nextDouble();
			System.out.print("Product quantitiy:");
			int productQty= sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQty, productPrice, product);			
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("Order Summary:");
		System.out.println(order);
		
		sc.close();
	}

}
