package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgressaoAritmetica {
						//Na progressão aritmetica, a diferença entre os numeros é sempre igual, ou seja, a razão é sempre a mesma
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean condicao = true;
		List<Integer> lista = new ArrayList<>();
		
		while(condicao) {
			System.out.println("Insira um número:");
			int numero = sc.nextInt();			
			if (numero == 0) {
				condicao = false;
			}
			else {	
				lista.add(numero);
			}		
		}
		
		int contador = 0;
		
		int[] razao = new int[lista.size() - 1];	
		
		for (int i = 0; i < lista.size() - 1; i++) {		//diminui o proximo item do atual para montar o vetor "razao"		
				razao[i] = lista.get(i+1) - lista.get(i);
		}
		
		for (int i = 0; i < razao.length - 1; i++) {		//se todos o itens do vetor forem iguais, então é um P.A.
			if (razao[i] == razao[i+1]) {
				contador++;
			}
		}
		
		for (int i = 0; i < razao.length; i++) {			
			System.out.println("itens razao: "+razao[i]);
		}
		
		System.out.println("contador:"+contador);
		System.out.println("tamanho vetor:"+razao.length);
		
		if (contador == razao.length - 1) {					//se o contador for igual o tamanho do vetor menos 1
			System.out.println("É uma Progressao Aritmetica");
		}
		else {
			System.out.println("Não é uma Progressao Aritmetica");
		}
		
		sc.close();
	}

}

