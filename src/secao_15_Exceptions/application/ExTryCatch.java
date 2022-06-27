package secao_15_Exceptions.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExTryCatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {		//Erro de tentar acessar uma posição fora do limite do Array
			System.out.println("Invalid position!");
		}
		catch (InputMismatchException e) {				//Erro de Entrada quando se digita um String no campo int
			System.out.println("Input error");
		}
		
		System.out.println("End of program");
		sc.close();
	}

}
