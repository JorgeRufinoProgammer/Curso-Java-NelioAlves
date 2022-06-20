package application;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o tamanho da matriz?");
		int n = sc.nextInt();
		
		int[][] matriz = new int[n][n];
		int[] vectDiagonal = new int[n];	//criei um vetor para receber os numeros da diagonal
		int contador =0;					//vai incrementar para colocar os numeros da diagonal na posiçao correta
		
		System.out.println("Comece a inserir os numeros:");
		//caso a matriz nao tenha a quantidade de linhas igual a quantidade de colunas, leia abaixo
		//para saber a quantidade de linhas da matriz : nome_matriz.length
		//para saber a quantidade de colunas da matriz : nome_matriz[i].length
		
		for (int i =0; i < matriz.length;i++) {
			for (int j =0; j < matriz[i].length;j++) {
				matriz[i][j] = sc.nextInt(); 
				if(i == j) {
					vectDiagonal[contador] = matriz[i][j];
					contador++; 		//sempre que adicionar um numero, aumenta +1 para pular posiçao no vetor
				}
			}
		}
		
		System.out.print("Diagonal principal: ");
		for (int obj : vectDiagonal) {
			System.out.print(obj + " ");
		}
		
		System.out.println();
		//Utilizado pelo professor
		System.out.print("Diagonal principal: ");
		for (int i =0; i < n;i++) {
			System.out.print(matriz[i][i] + " ");
		}
		
		System.out.println();
		
		int negatives = 0;
		for (int i =0; i < n;i++) {
			for (int j =0; j < n;j++) {				 
				if(matriz[i][j] < 0) {
					negatives++;					
				}
			}
		}
		
		System.out.println("Negative numbers: "+negatives);
		sc.close();

	}

}
