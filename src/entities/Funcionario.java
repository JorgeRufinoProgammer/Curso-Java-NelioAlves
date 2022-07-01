package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String nome;
	private Double salario;
	private Date dataAdmissao;
	
	private Departamentos departamento;
	
	public Funcionario() {}

	public Funcionario(String nome, Double salario, Date dataAdmissao, Departamentos departamento) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Nome: "+ nome + ", Departamento: " + departamento.getNome()+ ", Salario: R$" + String.format("%.2f", salario)
		+ ", Data de admissão: " + sdf.format(dataAdmissao);
	}
	public void aumentaSalario(double valor) {	//recebe a porcentagem de aumento
		salario += salario * valor / 100;
	}
	
	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
