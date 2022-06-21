package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinhaLista {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean condicao = true;
		List<Integer> lista = new ArrayList<>();
				
		while(condicao) {			
			//System.out.println("Insira um número:");
			//int numero = sc.nextInt();
			int numero = Util.inputInt("Insira um numero");	//Abre um Input e converte para Int
			if (numero == 0) {
				condicao = false;
			}
			else {	
				lista.add(numero);
			}		
		}
		//Ordena a Lista
		int aux = 0;
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size()-1; j++) {
				if (lista.get(j) > lista.get(j + 1)) {
					aux = lista.get(j);					// guarda temporariamente o numero caso seja maior que o proximo					
					lista.remove(j);					//remove ele da posiçao e os numeros vão se mover para a esquerda
					lista.add(j+1, aux);				//adiciona o numero uma posição a mais (fez a troca de posição com o numero depois)											
				}
			}
		}
		
		int maior =0, menor =0;
		for (int i = 0; i < lista.size(); i++) {
			if (i == 0 )	// o primeiro numero sempre será o maior e o menor
			{
				maior = lista.get(i);
				menor = lista.get(i);
			}
			
			if (lista.get(i) > maior) {
				maior = lista.get(i);
			}
			if (lista.get(i) < menor) {
				menor = lista.get(i);
			}
		}
				
		System.out.println("Lista ordenada:" + lista);
		System.err.println("Maior:"+maior+"\nMenor: "+menor);
		sc.close();
	}
	
}
