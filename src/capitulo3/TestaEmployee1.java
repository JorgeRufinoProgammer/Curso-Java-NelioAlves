package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee2;

public class TestaEmployee1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee2 obj = new Employee2();
		System.out.print("Nome do funcionario:");
		obj.name = sc.next();
		System.out.print("Salary:");
		obj.grossSalary= sc.nextDouble();
		System.out.print("Tax:");
		obj.tax = sc.nextDouble();
		obj.increaseSalary(10.0);
		
		System.out.println("Informações do funcionario: " + obj.toString());
		
		sc.close();
	}

}
