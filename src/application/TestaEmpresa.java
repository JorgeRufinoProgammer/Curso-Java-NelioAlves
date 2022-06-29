package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamentos;
import entities.Empresa;
import entities.Funcionario;

public class TestaEmpresa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual o nome da Empresa?");
		String nomeEmpresa = sc.nextLine();
		System.out.println("Qual o cpnj da Empresa?");
		int cnpj = sc.nextInt();
		
		Empresa empresa = new Empresa(nomeEmpresa, cnpj);
		
		System.out.println("Quantos departamentos tem a empresa?");
		int nDepart = sc.nextInt();
		
		for (int i = 0; i < nDepart ; i++) {
			System.out.println("Dados Departamento #"+ (i+1));
			System.out.println("Nome do departamento: ");
			sc.nextLine();
			String nomeDepartamento = sc.nextLine();
			
			Departamentos departamento = new Departamentos(nomeDepartamento);
			
			System.out.println("Quantos funcionarios para este departamento?");
			int nFuncionarios = sc.nextInt();
			
			for (int j = 0; j < nFuncionarios ; j++) {
				System.out.println("Dados do funcionario #"+(j+1)+" do Departamento de "+ departamento.getNome()+":");
				System.out.println("Qual o nome do funcionário?");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.println("Qual o salario?");
				Double salario = sc.nextDouble();
				System.out.println("Qual a data de admissão?");
				Date dataAdmissao = sdf.parse(sc.next());
				
				departamento.addFuncionarios(new Funcionario(nome, salario, dataAdmissao,departamento));
			}
			empresa.addDepartamentos(departamento);
		}
		
		System.out.println();
		
		System.out.println("Dados da empresa:");
		System.out.println("Nome: " + empresa.getNome() + " - Cnpj: "+ empresa.getCnpj());
		//System.out.println("Departamentos:");
		System.out.println();
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			System.out.println("Departamento de "+departamentos.getNome());
			System.out.println("Lista de funcionarios:");			
			for (Funcionario funcionarios : departamentos.getFuncionarios()) {
				if (funcionarios.getDepartamento().getNome().equals("Informatica")) {	//Aumenta salario em 10% para o departamento de Informatica
					funcionarios.aumentaSalario(10.0);
				}
				
				System.out.println("Nome do Funcionario: "+ funcionarios.getNome()
				+"\nSalario: "+funcionarios.getSalario() + "\nData de admissão: " + sdf.format(funcionarios.getDataAdmissao()));
			}
			System.out.println();
		}
		
		System.out.println("--------------------");
		System.out.println("Dados da empresa:");
		System.out.println("Nome: " + empresa.getNome() + " - Cnpj: "+ empresa.getCnpj());
		//System.out.println("Departamentos:");
		System.out.println();
		System.out.println("Lista de Departamentos:");
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			System.out.println(departamentos.getNome());
		}
		System.out.println();
		System.out.println("Lista de Funcionarios:");
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			for (Funcionario funcionarios : departamentos.getFuncionarios()) {
				System.out.println("Nome do Funcionario: "+ funcionarios.getNome() + 
				"\nDepartamento: "+funcionarios.getDepartamento().getNome()
				+"\nSalario: "+funcionarios.getSalario() + "\nData de admissão: " + sdf.format(funcionarios.getDataAdmissao()));
				System.out.println();
			}
		}
		sc.close();
	}

}
