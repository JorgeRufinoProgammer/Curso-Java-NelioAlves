package application;

import java.util.Scanner;

import entities.Rent;

public class VetorRent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Rent[] quartos = new Rent[10];	
		System.out.println("Quantos quartos serão alugados?");
		int rent = sc.nextInt();
		
		for (int i = 1; i <= rent; i++) {
			sc.nextLine();
			System.out.println("Rent #"+ i+":");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			//sc.nextLine();
			String email = sc.next();
			System.out.print("Room: ");
			int room = sc.nextInt();
			System.out.println();
			
			quartos[room] = new Rent(name, email);
		}
		
		System.out.println("Busy rooms:");
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] != null) {
			System.out.println(i+": "+quartos[i]);
			}
		}
		
		sc.close();
	}

}
