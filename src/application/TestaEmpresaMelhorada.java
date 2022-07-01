package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import entities.Departamentos;
import entities.Empresa;
import entities.Funcionario;
import secao_15_Exceptions.exception.DomainException;

public class TestaEmpresaMelhorada {	
	public static void main(String[] args) throws ParseException {		
		Locale.setDefault(Locale.US);		
		Empresa empresa = new Empresa();
		int opcao = 0;
		boolean condicaoPainel = true;
														//Lista de Opções do Painel
			String painel = "1 - Nome da Empresa\n2 - Cnpj da Empresa\n3 - Adicionar Departamento\n4 - Adicionar Funcionario"
					+ "\n5 - Mostrar lista de Departamentos\n6 - Mostrar lista de Funcionarios\n7 - Mostrar dados da Empresa"
					+ "\n0 - Sair";

			do{							//Utilizei o DO-WHILE pois o painel precisa ser executado pelo menos uma vez								
				try {					//Utilizei o try-catch dentro do laço para que o programa nao fosse parado nas exceçoes
					String strOpcao = JOptionPane.showInputDialog(painel);					
					if (strOpcao == null ) {	//Se clicar no botao Cancelar, retorna "null" então fecha o programa para nao cair na excecao
						System.exit(0);
					}
					
					opcao = Integer.parseInt(strOpcao);
					
					switch (opcao) {
					case 0: {					
						condicaoPainel = false;
					}break;
					case 1: {					
						nomeEmpresa(empresa);
					}break;
					case 2:{
						cnpjEmpresa(empresa);
					}break;
					case 3:{
						addDepartamento(empresa);		
					}break;
					case 4:{
						addFuncionario(empresa);
					}break;
					case 5:{
						listadeDepartamentos(empresa);
					}break;
					case 6:{
						listadeFuncionarios(empresa);
					}break;
					case 7:{
						dadosEmpresa(empresa);
					}break;					
					default:
						throw new IllegalArgumentException("Opçao inválida! Tente novamente!");
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
				catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,"Opção de departamento inválida! \nVoltando ao menu principal.");
				}
			}while(condicaoPainel);						
			System.exit(0);		
	}
	
	private static boolean existeFuncionario(List<Departamentos> lista) {
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
	
	private static void nomeEmpresa(Empresa empresa) throws DomainException{		
		if (empresa.getNome() != null) {
			throw new DomainException("Nome já existe!");						
		}
		String nome = Util.inputString("Qual o nome da empresa");
		if (nome == null) {
			throw new DomainException("Cadastro cancelado");
		}
		empresa.setNome(nome);			
	}
	
	private static void cnpjEmpresa(Empresa empresa) throws DomainException{
		if (empresa.getCnpj() != 0) {
			throw new DomainException("CNPJ já existe!");			
		}
		empresa.setCnpj(Util.inputInt("Qual o cnpj da empresa?"));
	}
	
	private static void addDepartamento(Empresa empresa) throws DomainException {
		String depart = Util.inputString("Qual o nome do novo departamento?");
		if(depart == null) {
			throw new DomainException("Cadastro cancelado!");
		}
		Departamentos departamento = new Departamentos(depart);		
		empresa.addDepartamentos(departamento);	
	}
	
	private static void addFuncionario(Empresa empresa) throws DomainException, ParseException{	
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
		
		Departamentos departamento = empresa.getDepartamentos().stream().filter(x -> x.getNome().equals(nomesDepartamentos[posicao])).findFirst().orElse(null);
		
		String nome = Util.inputString("Nome do Funcionario:");				
		Double salario = Util.inputDouble("Qual o salário?");				
		Date dataAdmissao = sdf.parse(Util.inputString("Qual a data de admissão(dd/MM/yyyy)?"));				
		departamento.addFuncionarios(new Funcionario(nome, salario, dataAdmissao, departamento));
	}
	
	private static void listadeDepartamentos(Empresa empresa) throws DomainException{
		if (empresa.getDepartamentos().size() == 0) {
			throw new DomainException("Sem departamentos cadastrados.");
		}		
		String listaDepartamentos = "";		
		for (int i = 0; i <empresa.getDepartamentos().size(); i++) {
			listaDepartamentos+= (i+1) + "-"+ empresa.getDepartamentos().get(i).getNome()+"\n";
		}
		JOptionPane.showMessageDialog(null, "Lista de Departamentos:\n"+listaDepartamentos);
	}
	
	private static void listadeFuncionarios(Empresa empresa) throws DomainException{		
		if(empresa.getDepartamentos().size() == 0 || !existeFuncionario(empresa.getDepartamentos())) {
			throw new DomainException("Sem funcionarios cadastrados.");
		}					
		
		String listaFuncionarios ="";
		for (Departamentos departamentos : empresa.getDepartamentos()) {	
			for (int i = 0; i < departamentos.getFuncionarios().size(); i++) {
				listaFuncionarios += (i+1)+ " - "+ departamentos.getFuncionarios().get(i) +"\n";
			}			
		}
		JOptionPane.showMessageDialog(null, "Lista de Funcionários:\n"+listaFuncionarios);
	}
	
	private static void dadosEmpresa(Empresa empresa) throws DomainException{		
		String dados = "Dados da empresa: \nNome: " + empresa.getNome() + " - Cnpj: "+ empresa.getCnpj();							
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			dados += "\nDepartamento de "+departamentos.getNome() +"\nLista de funcionarios:\n";		
			for (int i = 0; i < departamentos.getFuncionarios().size(); i++) {
				dados += (i+1)+ " - "+ departamentos.getFuncionarios().get(i) +"\n";
			}					
		}
		JOptionPane.showMessageDialog(null, dados);
	}
}
