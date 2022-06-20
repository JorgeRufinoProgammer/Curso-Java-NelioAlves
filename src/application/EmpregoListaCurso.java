package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Emprego;

public class EmpregoListaCurso {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Emprego> list = new ArrayList<>();
		
		// PART 1 - READING DATA:
		
		System.out.print("How many Empregos will be registered? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Emprego #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {				
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Emprego(id, name, salary));
		}

		// PART 2 - UPDATING SALARY OF GIVEN Employee:
		
		System.out.println();
		System.out.print("Enter the Emprego id that will have salary increase: ");
		int id = sc.nextInt();
		Emprego emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);//verifica se ja existi o ID na lista, se nao tiver retorna "null"	
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {											//Se o ID existir, aumenta o salario
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.aumentaSalario(percentage);
		}
		
		// PART 3 - LISTING Employees:
		
		System.out.println();
		System.out.println("List of Employees:");
		for (Emprego obj : list) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	public static boolean hasId(List<Emprego> list, int id) {
		Emprego emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;	//se o objeto "emp" não for "null" ele retorna "true, ou seja, caso encontre o ID retorna verdadeiro
	}
}