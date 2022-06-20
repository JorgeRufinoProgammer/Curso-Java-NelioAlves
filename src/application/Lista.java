package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("Joao");
		lista.add("Maria");
		lista.add("Marcos");
		lista.add("Ana");
		lista.add("Caio");
		lista.add("Erika");
		lista.add("Aldo");
		
		for (String obj : lista) {					// Laço FOREACH para mostrar os valores da Lista
			System.out.println(obj);
		}
		System.out.println("-----------------");
		lista.remove(4);							//Removeu posição 4 (0,1,2,3,4)
		lista.remove("Joao");						//Removeu comparando a String
		lista.add(1, "Jorge");  					//Adicionou na posição 1 (0,1)

		for (int i = 0; i < lista.size(); i++) {	// Laço FOR para mostrar os valores da Lista
			System.out.println(lista.get(i));
		}
		
		System.out.println("-----------------");
		lista.removeIf(x -> x.charAt(0) == 'M');	//Removeu todos que começam com M (maiusculo)
		for (String obj : lista) {					// Laço FOREACH para mostrar os valores da Lista
			System.out.println(obj);
		}
		System.out.println("-----------------");
		System.out.println("Index of Ana: " + lista.indexOf("Ana"));
		System.out.println("Index of Erika: " + lista.indexOf("Erika"));
		System.out.println("-----------------");
		for (int i = 0; i < lista.size(); i++) {	// Laço FOR para mostrar os valores da Lista
			System.out.println(lista.get(i));
		}
		System.out.println("-----------------");
		List<String> result = lista.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); //Pega todos que começam com A e cria uma nova lista
		for (int i = 0; i < result.size(); i++) {	// Laço FOR para mostrar os valores da Lista
			System.out.println(result.get(i));
		}
		System.out.println("-----------------");
		String first = lista.stream().filter(x -> x.charAt(0) == 'E').findFirst().orElse(null); 	//Encontra o primeiro String que começa com E
		System.out.println(first);
	}

}

