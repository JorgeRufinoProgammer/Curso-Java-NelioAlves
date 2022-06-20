package application;

import java.util.Scanner;

import entities.ConversorUnidades;

public class TestaConversorUnidades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o valor:");
		double value = sc.nextDouble();
		
		double litros = ConversorUnidades.metro_cubico_para_litros(value);
		System.out.print("Valor em litros: " + String.format("%.2f", litros));
				
		double pesCubicos = ConversorUnidades.metro_cubico_para_pesCubicos(value);
		System.out.print("\nValor em pés cubicos: " + String.format("%.2f", pesCubicos));
		
		double centCubicos = ConversorUnidades.litro_para_cent_cubico(litros);
		System.out.print("\nValor em centimetros cubicos: " + String.format("%.2f", centCubicos));
		
		sc.close();
	}

}
