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
import entities.enums.OpcaoPainel;
import secao_15_Exceptions.exception.DomainException;

public class TestaEmpresaMelhorada {	
	public static void main(String[] args) throws ParseException {		
		Locale.setDefault(Locale.US);		
		Empresa empresa = new Empresa();
	
		iniciarAplicacao(empresa);
	}
	
	public static void iniciarAplicacao(Empresa empresa) {	//Método principal
		OpcaoPainel opcao;
		do{		
			opcao = painel();		//Utilizei o DO-WHILE pois o painel precisa ser executado pelo menos uma vez								
									//Utilizei o try-catch dentro do laço para que o programa nao fosse parado nas exceçoes
				switch (opcao) {
				case SAIR: {					
					sair();
				}break;
				case NOME_DA_EMPRESA: {					
					nomeEmpresa(empresa);
				}break;
				case CNPJ_DA_EMPRESA:{
					cnpjEmpresa(empresa);
				}break;
				case EXIBIR_DADOS_DA_EMPRESA:{
					dadosEmpresa(empresa);
				}break;
				case ADICIONAR_DEPARTAMENTO:{
					addDepartamento(empresa);		
				}break;
				case ADICIONAR_FUNCIONARIO:{
					addFuncionario(empresa);
				}break;
				case LISTAR_DEPARTAMENTOS:{
					listadeDepartamentos(empresa);
				}break;
				case LISTAR_FUNCIONARIOS:{
					listadeFuncionarios(empresa);
				}break;								
				default:
					JOptionPane.showMessageDialog(null, "Opçao inválida! Tente novamente!");
				}
			
			
		}while(opcao != OpcaoPainel.SAIR);						
		System.exit(0);		
	}
	
	private static OpcaoPainel painel() {	//Painel das Opções
		String listaOpcoes = "";	
		int codigo = 0;
		try {
			for (OpcaoPainel option : OpcaoPainel.values()) {
				if (option.getCode() == codigo) {
					listaOpcoes += option.getCode()+" - " + OpcaoPainel.getOption(codigo) + "\n";	//Por ser static, tem que chamar o nome da classe
					codigo++;
				}
			}		
			String opcaoUsuario = JOptionPane.showInputDialog(listaOpcoes);
			if (opcaoUsuario == null) {		//Quando clicar no botao Cancelar
				return OpcaoPainel.SAIR;
			}
			return OpcaoPainel.getOption(Integer.parseInt(opcaoUsuario));
		}
		catch (NumberFormatException e) {	//Não tratei o erro pois como vai retornar o valor ERRO, ele vai mostrar 2 erros			
		}									//1 do catch local e outro do catch do metodo "iniciarAplicacao"
		return OpcaoPainel.ERRO;
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
	
	private static void nomeEmpresa(Empresa empresa) {		
		try {
			if (empresa.getNome() != null) {
				throw new DomainException("Nome já existe!");						
			}
			String nome = Util.inputString("Qual o nome da empresa");
			if (nome == null) {
				throw new DomainException("Cadastro cancelado");
			}
			empresa.setNome(nome);			
		}
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
	}
	
	private static void cnpjEmpresa(Empresa empresa) {
		try {
			if (empresa.getCnpj() != 0) {
				throw new DomainException("CNPJ já existe!");			
			}
			empresa.setCnpj(Util.inputInt("Qual o cnpj da empresa?"));	
		}		
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Apenas números!"+e.getMessage());
		}
	}
	
	private static void addDepartamento(Empresa empresa) {
		try {
			String depart = Util.inputString("Qual o nome do novo departamento?");
			if(depart == null) {
				throw new DomainException("Cadastro cancelado!");
			}
			Departamentos departamento = new Departamentos(depart);		
			empresa.addDepartamentos(departamento);	
		}
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
	}
	
	private static void addFuncionario(Empresa empresa) {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (empresa.getDepartamentos().size() == 0) {
				throw new DomainException("Cadastre primeiro um Departamento.");
			}
		
			List<Departamentos> listaDepartamentos = empresa.getDepartamentos();
			String lista = "";
			for (int i = 0 ; i < listaDepartamentos.size(); i++) {				//Lista os departamentos			
				lista += (i+1) + " - "+listaDepartamentos.get(i).getNome() + "\n";	//Devido começar na pos. 0, adiciona +1
			}
						
			int posicao = Util.inputInt("Escolha qual o departamento:\n"+lista);
			Departamentos dept = listaDepartamentos.get(posicao-1); 			//Como foi adicionado +1 acima, temos que remover ele agora
			
			String nome = Util.inputString("Nome do Funcionario:");				
			Double salario = Util.inputDouble("Qual o salário?");				
			Date dataAdmissao = sdf.parse(Util.inputString("Qual a data de admissão(dd/MM/yyyy)?"));				
			dept.addFuncionarios(new Funcionario(nome, salario, dataAdmissao, dept));
		}
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
		catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo! Data Invalida!");
		}
		catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,"Opção de departamento inválida! \nVoltando ao menu principal.");
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Dados invalidos!");
		}
	}
	
	private static void listadeDepartamentos(Empresa empresa) {
		try {
			if (empresa.getDepartamentos().size() == 0) {
				throw new DomainException("Sem departamentos cadastrados.");
			}		
			String listaDepartamentos = "";		
			for (int i = 0; i <empresa.getDepartamentos().size(); i++) {
				listaDepartamentos+= (i+1) + "-"+ empresa.getDepartamentos().get(i).getNome()+"\n";
			}
			JOptionPane.showMessageDialog(null, "Lista de Departamentos:\n"+listaDepartamentos);
		}
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
	}
	
	private static void listadeFuncionarios(Empresa empresa) {	
		try {
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
		catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Catch do proprio metodo!"+e.getMessage());
		}
	}
	
	private static void dadosEmpresa(Empresa empresa) {		
		String dados = "Dados da empresa: \nNome: " + empresa.getNome() + " - Cnpj: "+ empresa.getCnpj();							
		for (Departamentos departamentos : empresa.getDepartamentos()) {
			dados += "\nDepartamento de "+departamentos.getNome() +"\nLista de funcionarios:\n";		
			for (int i = 0; i < departamentos.getFuncionarios().size(); i++) {
				dados += (i+1)+ " - "+ departamentos.getFuncionarios().get(i) +"\n";
			}					
		}
		JOptionPane.showMessageDialog(null, dados);
	}
	
	private static void sair() {
		System.exit(0);
	}
}
