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
import secao_15_Exceptions.exception.DomainException;

public class TestaEmpresaMelhorada {	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Empresa empresa = new Empresa();
		int opcao = 0;
		boolean condicaoPainel = true;
														//Lista de Opções do Painel
			String painel = "1 - Nome da Empresa\n2 - Cnpj da Empresa\n3 - Adicionar Departamento\n4 - Adicionar Funcionario"
					+ "\n5 - Mostrar lista de Departamentos\n6 - Mostrar lista de Funcionarios\n7 - Mostrar dados da Empresa"
					+ "\n0 - Sair";

			do{							//Utilizei o DO-WHILE pois o painel precisa ser executado pelo menos uma vez								
				try {					//Utilizei o try-catch dentro do laço para que o programa nao fosse parado nas exceçoes
					String teste = JOptionPane.showInputDialog(painel);					
					if (teste == null ) {	//Se clicar no botao Cancelar, retorna "null" então fecha o programa para nao cair na excecao
						System.exit(0);
					}
					
					opcao = Integer.parseInt(teste);
					if (opcao == 1) {									//Nome da Empresa						
						nomeEmpresa(empresa);
					}
					else if (opcao == 2) {									//CNPJ
						cnpjEmpresa(empresa);
					}	
					else if (opcao == 3) {									//Add Departamento
						addDepartamento(empresa);				
					}
					else if (opcao == 4) {									//Add Funcionario
						addFuncionario(empresa);
					}				
					else if(opcao == 5) {								//Lista de Departamentos
						listadeDepartamentos(empresa);
					}
					else if(opcao == 6) {								//Lista de Funcionarios	
						listadeFuncionarios(empresa);		
					}
					else if (opcao == 7) {									//Mostra os dados da Empresa
						dadosEmpresa(empresa);
					}
					
					else if (opcao > 9 || opcao < 0)	{
						JOptionPane.showMessageDialog(null, "Opçao inválida! Tente novamente!");
					}
					else if (opcao == 0) {
						condicaoPainel = false;
					}
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Opçao inválida! Tente novamente!");
				}
				catch (DomainException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				catch (ParseException e) {
					JOptionPane.showMessageDialog(null,"Data Inválida!");
				}
			}while(condicaoPainel);						
			
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
	
	public static void nomeEmpresa(Empresa empresa) throws DomainException{		
		if (empresa.getNome() != null) {
			throw new DomainException("Nome já existe!");						
		}
		String nome = Util.inputString("Qual o nome da empresa");
		if (nome == null) {
			throw new DomainException("Cadastro cancelado");
		}
		empresa.setNome(nome);			
	}
	public static void cnpjEmpresa(Empresa empresa) throws DomainException{
		if (empresa.getCnpj() != 0) {
			throw new DomainException("CNPJ já existe!");			
		}
		empresa.setCnpj(Util.inputInt("Qual o cnpj da empresa?"));
	}
	public static void addDepartamento(Empresa empresa) throws DomainException {
		String depart = Util.inputString("Qual o nome do novo departamento?");
		if(depart == null) {
			throw new DomainException("Cadastro cancelado!");
		}
		Departamentos departamento = new Departamentos(depart);		
		empresa.addDepartamentos(departamento);	
	}
	public static void addFuncionario(Empresa empresa) throws DomainException, ParseException{	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (empresa.getDepartamentos().size() == 0) {
			throw new DomainException("Cadastre primeiro um Departamento.");
		}
		
		String[] nomesDepartamentos = new String[empresa.getDepartamentos().size()+1];
		int contador = 1;
		for (Departamentos departamento : empresa.getDepartamentos()) {
			nomesDepartamentos[contador] = departamento.getNome();
			contador++;
		}					
		
		String listaDepartamentos = "";		
		for (int i = 1 ; i < nomesDepartamentos.length; i++) {
			listaDepartamentos += i + " - " + nomesDepartamentos[i]+"\n";
		}
		int posicao = Util.inputInt("Escolha qual o departamento:\n"+listaDepartamentos);
		
		for (Departamentos departamento : empresa.getDepartamentos()) {
			if(departamento.getNome().equals(nomesDepartamentos[posicao])) {
				String nome = Util.inputString("Nome do Funcionario:");				
				Double salario = Util.inputDouble("Qual o salário?");				
				Date dataAdmissao = sdf.parse(Util.inputString("Qual a data de admissão(dd/MM/yyyy)?"));				
				departamento.addFuncionarios(new Funcionario(nome, salario, dataAdmissao, departamento));
			}
		}
	}
	public static void listadeDepartamentos(Empresa empresa) throws DomainException{
		if (empresa.getDepartamentos().size() == 0) {
			throw new DomainException("Sem departamentos cadastrados.");
		}		
		String listaDepartamentos = "";		
		for (int i = 0; i <empresa.getDepartamentos().size(); i++) {
			listaDepartamentos+= (i+1) + "-"+ empresa.getDepartamentos().get(i).getNome()+"\n";
		}
		JOptionPane.showMessageDialog(null, "Lista de Departamentos:\n"+listaDepartamentos);
	}
	public static void listadeFuncionarios(Empresa empresa) throws DomainException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(empresa.getDepartamentos().size() == 0 || !existeFuncionario(empresa.getDepartamentos())) {
			throw new DomainException("Sem funcionarios cadastrados.");
		}					
		
		String listaFuncionarios ="";
		for (Departamentos departamentos : empresa.getDepartamentos()) {							
			for (Funcionario funcionarios : departamentos.getFuncionarios()) {
				listaFuncionarios += "Nome: "+ funcionarios.getNome() + 
				", Departamento: "+funcionarios.getDepartamento().getNome()
				+", Salario: R$ "+ String.format("%.2f", funcionarios.getSalario()) 
				+ ", Data de admissão: " + sdf.format(funcionarios.getDataAdmissao())+"\n\n";				
			}
		}
		JOptionPane.showMessageDialog(null, "Lista de Funcionários:\n"+listaFuncionarios);
	}
	public static void dadosEmpresa(Empresa empresa) throws DomainException{						
		String dados = "Dados da empresa: \nNome: " + empresa.getNome() + " - Cnpj: "+ empresa.getCnpj();							
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			dados += "\nDepartamento de "+departamentos.getNome() +"\nLista de funcionarios:";						
			for (Funcionario funcionarios : departamentos.getFuncionarios()) {
				if (funcionarios.getDepartamento().getNome().equals("Informatica")) {	//Aumenta salario em 10% para o departamento de Informatica
					funcionarios.aumentaSalario(10.0);
				}
				dados += "Nome: "+ funcionarios.getNome()
				+"\nSalario: "+funcionarios.getSalario() + "\nData de admissão: " + sdf.format(funcionarios.getDataAdmissao()));
			}
			System.out.println();
		}
	}
}
