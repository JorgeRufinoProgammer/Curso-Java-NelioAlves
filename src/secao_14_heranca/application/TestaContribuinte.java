package secao_14_heranca.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao_14_heranca.entities.Contribuinte;
import secao_14_heranca.entities.PessoaFisica;
import secao_14_heranca.entities.PessoaJuridica;

public class TestaContribuinte {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Numero de contribuintes:");
		int n = sc.nextInt();
		
		List<Contribuinte> listaContribuinte= new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Imposto Contribuinte #"+(i+1));
			System.out.print("Pessoa Fisica ou Juridica (f/j)?");
			char response = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (response =='f') {
				System.out.print("Gastos com sáude: ");
				double gastosSaude = sc.nextDouble();
				listaContribuinte.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			if (response =='j') {
				System.out.print("Quantidade de funcionarios: ");
				int quantFuncionarios = sc.nextInt();
				listaContribuinte.add(new PessoaJuridica(nome, rendaAnual, quantFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("Impostos a Pagar por Contribuinte:");
		double soma = 0.0;
		for (Contribuinte contribuinte : listaContribuinte) {	//Verifica se o objeto da lista é um objeto/instancia da subclasse PessoaFisica
			if (contribuinte instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica)contribuinte;
				System.out.println(contribuinte +", gastos com saúde: " + String.format("%.2f", pf.getGastosSaude()));
			}
			
			if (contribuinte instanceof PessoaJuridica) {		//Verifica se o objeto da lista é um objeto/instancia da subclasse PessoaJuridica
				PessoaJuridica pj = (PessoaJuridica)contribuinte;
				System.out.println(contribuinte +", quantidade de funcionarios: " + pj.getQuantFuncionarios());
			}
			
		//System.out.println(contribuinte.getNome()+": $"	+String.format("%.2f", contribuinte.impostoPagar())); Esta linha está no toString()
			
			soma += contribuinte.impostoPagar();
		}
		System.out.println("Total de Impostos a Pagar: $" + String.format("%.2f", soma));
		sc.close();
	}

}
