package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Estudante;

public class TestaEstudante {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Estudante obj = new Estudante();
		
		System.out.println("Nome do Estudante:");
		obj.nome = sc.next();
		System.out.println("Nota da primeira prova:");
		obj.nota1 = sc.nextDouble();		
		System.out.println("Nota da segunda prova:");
		obj.nota2 = sc.nextDouble();
		System.out.println("Nota da terceira prova:");
		obj.nota3 = sc.nextDouble();
		
		System.out.println("NOME: "+obj.nome);
		System.out.printf("FINAL GRADE= %.2f\n", obj.notaFinal());
		
		if (obj.situacao().equals("PASSED")) {			
			System.out.println(obj.situacao());
		}else {			
			System.out.println(obj.situacao());
			System.out.printf("MISSING POINTS: %.2f", (60-obj.notaFinal()));
		}
				
		sc.close();
	}

}
