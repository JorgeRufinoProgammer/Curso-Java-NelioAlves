package capitulo3;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual o numero?");
		int x = sc.nextInt();
		int numAtual=0,numAnterior=0, numProximo=0;
		for (int i = 0; i < x; i++) {
			if (i == 0) {
				System.out.println(i);
				numProximo = 1;
			}
			else {
				numAnterior = numAtual;
				numAtual = numProximo;
				numProximo = numAtual + numAnterior;
				System.out.println(numAtual);
			}
		}
		
		sc.close();
	}

}
