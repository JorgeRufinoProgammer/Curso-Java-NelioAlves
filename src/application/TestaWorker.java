package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class TestaWorker {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//este objeto serve tanto para passar a Data(parse()) e quanto para recupera-la (format())
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		System.out.print("Enter department's name:");
		//String departmentName = sc.next();					
		Departament departament = new Departament(sc.next());
		
		System.out.println("Enter worker data:");
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("Level:");
		WorkerLevel wl = WorkerLevel.valueOf(sc.next());		
		System.out.print("Base Salary:");
		double baseSalary = sc.nextDouble();
				
		Worker worker = new Worker(name, wl, baseSalary, departament);
		//Worker worker = new Worker(name, wl, baseSalary, new Departament(departmentName));	poderia passa o departamento desta forma tb
		
		System.out.print("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #"+(i+1)+" data:");
			System.out.print("Enter date (DD/MM/YYYY):");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours):");
			int hours = sc.nextInt();
			
			HourContract hourContract = new HourContract(date, valuePerHour, hours);
			
			worker.addContract(hourContract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String monthYear= sc.next();
		int month = Integer.parseInt(monthYear.substring(0, 2)); //pega da posicao 0 até antes da posiçao 2 => [0,2[
		int year = Integer.parseInt(monthYear.substring(3));	//pega a partir da posiçao 3 em diante		=> 3]
		System.out.print("Worker name: "+ worker.getName());
		System.out.print("\nDepartment: "+ worker.getDepartment().getName());//Como "getDepartment" retorna um objeto, chamamos o metodo atraves dele
		
		double income = worker.income(month, year);
		if (income == worker.getBaseSalary()) {
			System.out.println("\nWorker not contracts, receveid just base salary: " + String.format("%.2f",worker.getBaseSalary()));
		}
		else {
			System.out.print("\nIncome for "+ monthYear +": "+ String.format("%.2f", worker.income(month, year)));
		}
		
		System.out.println();
		System.out.println();	//INSERI O CODIGO ABAIXO PARA MOSTRAR OS CONTRATOS DO TRABALHADOR
		System.out.println("Contracts data: ");
		int contador = 1;
		for (HourContract obj: worker.getContracts()) {			
			System.out.println("Contract #"+contador);
			System.out.print("Data:"+sdf.format(obj.getDate()));
			System.out.print("\nValue per Hour:"+obj.getValuePerHour());
			System.out.print("\nHours:"+obj.getHours());
			
			contador++;
		}
		
		
		sc.close();

	}

}
