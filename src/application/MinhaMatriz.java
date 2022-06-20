package application;

import java.util.Scanner;

public class MinhaMatriz {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantidade de linhas:");
		int l = sc.nextInt();
		System.out.println("Quantidade de colunas:");
		int c = sc.nextInt();
		
		int[][] matriz = new int[l][c];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		System.out.println("Qual o numero da matriz:");
		int numero = sc.nextInt();
		
		int linha = 0, coluna = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (numero == matriz[i][j]) {
					linha = i;
					coluna = j;
					System.out.println("Position: ("+i+","+j+")");
					
					if(j > 0) {
						System.out.println("Left: "+matriz[i][j-1]); //mostra somente o numero a esquerda
						
						System.out.print("Numeros a esquerda, a cima e abaixo:"); //mostra a sequencia
						for (int m = 0; m < matriz.length; m++) {
							for (int n = 0; n < coluna; n++) {				
								System.out.print(matriz[m][n] + " ");
							}
						}	
						System.out.println();
					}
					if(i > 0) {
						System.out.print("Up: "+matriz[i-1][j]);
						
						System.out.print("\nNumeros acima, esquerda e a direita:");
						for (int m = 0; m < linha; m++) {
							for (int n = 0; n < matriz[m].length; n++) {				
								System.out.print(matriz[m][n] + " ");
							}
						}
						System.out.println();
					}
					
					if(j < matriz[i].length -1) {
						System.out.print("Right: "+matriz[i][j+1]);
						
						System.out.print("\nNumeros a direita, acima e abaixo:");
						for (int m = 0; m < matriz.length; m++) {
							for (int n = 0; n < matriz[m].length; n++) {				
								if(n > coluna ) {
									System.out.print(matriz[m][n] + " ");
								}
							}
						}						
						System.out.println();
					}
					if(i < matriz.length -1) {
						System.out.print("Down: "+matriz[i+1][j]);
						
						System.out.print("\nNumeros a baixo, direita e esquerda:");
						for (int m = 0; m < matriz.length; m++) {
							for (int n = 0; n < matriz[m].length; n++) {				
								if(m > linha) {
									System.out.print(matriz[m][n] + " ");
								}
							}
						}						
						System.out.println();
					}
					System.out.println("-------------------");
				}
			}
		}
		
		sc.close();

	}

	public static int[] numAcima(int[][] matriz, int linha, int coluna) {
		int[] vect = new int[linha];
		int contador = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {				
				if(j == coluna && i < linha) {
					vect[contador] = matriz[i][j];
					contador++;
				}
			}
		}
		
		return vect;
	}
}
