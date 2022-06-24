package secao_14_heranca.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao_14_heranca.entities.Employee;
import secao_14_heranca.entities.OutsourceEmployee;

public class TestaEmployee {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees:");
		int n = sc.nextInt();
		
		List<Employee> empList = new ArrayList<Employee>();
		
		for (int i =0 ; i < n; i++) {
			System.out.println("Employee #"+(i+1)+" data:");
			System.out.print("Outsourced (y/n)?");
			char response = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name:");
			String name = sc.nextLine();
			System.out.print("Hours:");
			int hours = sc.nextInt();
			System.out.print("Value per Hour:");
			double valuePerHour= sc.nextDouble();
			
			if (response == 'y') {
				System.out.print("Additional Charge:");
				double additionalCharge = sc.nextDouble();				
				empList.add(new OutsourceEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				empList.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println("PAYMENTS:");
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		sc.close();
	}

}
