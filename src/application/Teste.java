package application;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Linha:");
		int l = sc.nextInt();
		System.out.println("Coluna:");
		int c = sc.nextInt();
		
		int[][] matriz = new int[l][c];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Qual o numero buscado?");
		int numero = sc.nextInt();
		int linha = 0 ; 
		int coluna = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(numero == matriz[i][j]) {
					linha = i;
					coluna = j;
					
					if(j > 0) {
						System.out.println("Left: "+ matriz[i][j-1]);
						System.out.print("Line left: ");
						for (int m = 0; m < matriz.length; m++) {
							for (int n = 0; n < matriz[m].length; n++) {
								if(m == linha && n < coluna) {
									System.out.print(matriz[m][n]+ " ");
								}
							}
						}
						System.out.println();
					}
					if(i > 0) {
						System.out.println("Up: "+ matriz[i-1][j]);
					}
					if(j < matriz[i].length - 1) {
						System.out.println("Right: "+ matriz[i][j+1]);
					}
					if(i < matriz.length - 1) {
						System.out.println("Down: "+ matriz[i+1][j]);
					}
				}
			}
		}
		
		sc.close();
	}

}
