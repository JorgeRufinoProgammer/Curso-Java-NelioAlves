package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Student;

public class TestaStudent {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		System.out.println("Name: ");
		student.name = sc.next();
		//student.nota1 = sc.nextDouble();
		//student.nota2 = sc.nextDouble();
		//student.nota3 = sc.nextDouble();
		student.nota1 = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da nota 1?"));
		student.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da nota 2?"));
		student.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da nota 3?"));
		
		System.out.printf("FINAL GRADE = %.2f%n" , student.notaFinal());
		
		if (student.missingPoints() > 0) {
			System.out.println("FAILED");
			System.out.println("MISSING " + String.format("%.2f", student.missingPoints()) + " POINTS");
		}
		else {
			System.out.println("PASSED");
		}
		
		sc.close();
	}

}
