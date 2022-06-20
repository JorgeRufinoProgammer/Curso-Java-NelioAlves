package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Emprego;

public class TestaEmpregoLista {
	//Fiz exemplo de uso da Lista e do Vector(Array)
						//Utilizei a minha lógica para percorrer a lista neste exemplo. 
						//Na classe EmpregoListaCurso está mais otimizado e de outra forma
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos empregados serão registrados?");
		int n = sc.nextInt();
		
		List<Emprego> lista = new ArrayList<>();	//Lista
		Emprego[] vect = new Emprego[n];			//Vetor
		
		for (int i = 0 ; i < n ; i++) {
			System.out.println("Empregado #"+(i+1)+":");
			System.out.print("Id:");
			int id = sc.nextInt();
			
			while (buscaID(lista, id) != null) {
				System.out.print("ID já existe! Tente novamente:");
				id = sc.nextInt();
			}
			
			System.out.print("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salario:");
			double salario = sc.nextDouble();
			
			lista.add(new Emprego(id, nome, salario));	//Cria um obj Emprego dentro da lista
			vect[i] = new Emprego(id, nome, salario);	//Cria um obj Emprego dentro do vetor (Array)
		}
		
		System.out.println();
		System.out.println("Entre com o ID do empregado para receber aumento: ");
		int id = sc.nextInt();
		
		if(buscaIDVector(vect, id) != null) {		//Metodo que busca o ID e retorna o Ojb correspondente a este ID
			System.out.println("Qual a porcentagem de aumento do salario? ");
			double porcentagem = sc.nextDouble();
			buscaIDVector(vect, id).aumentaSalario(porcentagem);//esta linha faz o mesmo que as duas abaixo, assim nao precisa criar mais um objeto
			//Emprego emp = buscaID(lista, id);
			//emp.aumentaSalario(porcentagem);
			  
		}
		else {
			System.out.println("Id não existe!");
		}
		
		System.out.println("Lista de Empregados: ");
		for (Emprego obj : lista) {
			System.out.println(obj);
		}
		System.out.println("-----------------");
		for (Emprego obj : vect) {
			System.out.println(obj);
		}
		sc.close();

	}
	
	public static Emprego buscaID(List<Emprego> lista, int id) {//recebe uma Lista e um ID e procura esse ID dentro da Lista, depois retorna o objeto do ID
		Emprego emp = null;
		for(Emprego obj : lista) {
			if (id == obj.getId()) {
				emp = obj;
			}
		}
		return emp;
	}
	
	public static Emprego buscaIDVector(Emprego[] vect, int id) {//Faz o mesmo que o metodo acima porem recebendo um Vetor como parametro
		Emprego emp = null;
		for (int i =0; i < vect.length; i++) {
			if (id == vect[i].getId()) {
				emp = vect[i];
			}
		}
		return emp;
	}
}
