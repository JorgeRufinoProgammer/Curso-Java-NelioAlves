package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee1;


public class TestaEmployee {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee1 employee1 = new Employee1();
		
		System.out.print("Name: ");
		employee1.name = sc.next();
		System.out.print("Gross Salary: ");
		employee1.grossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		employee1.tax = sc.nextDouble();
		
		System.out.println("\nEmployee: " + employee1);
		
		System.out.print("\nWich percentage to increase the salary? ");
		employee1.increaseSalary(sc.nextDouble());
		
		System.out.println("\nUpdate data: " + employee1);
		
		sc.close();
	}

}
