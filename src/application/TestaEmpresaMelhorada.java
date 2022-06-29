package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Departamentos;
import entities.Empresa;
import entities.Funcionario;

public class TestaEmpresaMelhorada {	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
		try {
			String painel = "1 - Nome da Empresa\n2 - Cnpj da Empresa\n3 - Adicionar Departamento\n4 - Adicionar Funcionario"
					+ "\n5 - Motras dados da Empresa\n6 - Mostrar lista de Departamentos\n7 - Mostrar lista de Funcionarios"
					+ "\n8 Sair do sistema";
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(painel));
			while(opcao != 0) {
				if (opcao == 1) {
					if (empresa.getNome() == null) {	
						System.out.println("Qual o nome da Empresa?");
						String nomeEmpresa = sc.nextLine();
						empresa.setNome(nomeEmpresa);
					}
					else {
						JOptionPane.showMessageDialog(null, "Nome da empresa já existe");
					}				
				}
				if (opcao == 2) {
					if (empresa.getCnpj() == 0) {
						System.out.println("Qual o cpnj da Empresa?");
						int cnpj = sc.nextInt();
						empresa.setCnpj(cnpj);
					}
					else {
						JOptionPane.showMessageDialog(null, "CNPJ já existe");
					}
					
				}
				if (opcao == 3) {
					System.out.println("Nome do departamento: ");					
					String nomeDepartamento = sc.next();
					Departamentos departamento = new Departamentos(nomeDepartamento);
					empresa.addDepartamentos(departamento);					
				}
				if (opcao == 4) {		
					if (empresa.getDepartamentos().size() == 0) {
						JOptionPane.showMessageDialog(null, "Cadastre primeiro um Departamento.");
					}else {
						String[] nomesDepartamentos = new String[empresa.getDepartamentos().size()+1];
						int contador = 1;
						for (Departamentos departamento : empresa.getDepartamentos()) {
							nomesDepartamentos[contador] = departamento.getNome();
							contador++;
						}					
						
						System.out.println("Escolha qual o departamento:");
						for (int i = 1 ; i < nomesDepartamentos.length; i++) {
							System.out.println(i + " - " + nomesDepartamentos[i]);
						}
						int posicao = sc.nextInt();
						
						for (Departamentos departamento : empresa.getDepartamentos()) {
							if(departamento.getNome().equals(nomesDepartamentos[posicao])) {							
								System.out.println("Qual o nome do funcionário?");
								sc.nextLine();
								String nome = sc.nextLine();
								System.out.println("Qual o salario?");
								Double salario = sc.nextDouble();
								System.out.println("Qual a data de admissão?");
								Date dataAdmissao = sdf.parse(sc.next());
								
								departamento.addFuncionarios(new Funcionario(nome, salario, dataAdmissao, departamento));
							}
						}
					}
				}
				if (opcao == 5) {
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
				}
				if(opcao == 6) {
					if (empresa.getDepartamentos().size() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados departamentos!");
					}
					else {
						System.out.println();
						System.out.println("Lista de Departamentos:");
						for (Departamentos departamentos : empresa.getDepartamentos()) {
							System.out.println(departamentos.getNome());
						}
					}
					
				}
				if(opcao == 7) {					
					if(empresa.getDepartamentos().size() == 0) {
						JOptionPane.showMessageDialog(null, "1-Ainda não foram cadastrados funcionarios!");
					}
					else if (existeFuncionario(empresa.getDepartamentos())){			
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
					}
					else {
						JOptionPane.showMessageDialog(null, "2-Ainda não foram cadastrados funcionarios!");
					}
				}
				if (opcao == 8) {
					JOptionPane.showMessageDialog(null, "Fechando sistema");
					System.exit(0);					
				}
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog(painel));
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro inesperado");
		}
		sc.close();
	}
	
	public static boolean existeFuncionario(List<Departamentos> lista) {
		boolean resposta = false;
		int contador = 0;
		for (Departamentos departamentos : lista) {
			if(departamentos.getFuncionarios().size() != 0) {
				contador++;
			}
		}
		
		if (contador > 0) {
			resposta = true;
		}
		return resposta;
	}
}
