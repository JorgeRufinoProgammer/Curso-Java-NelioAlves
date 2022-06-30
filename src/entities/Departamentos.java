package entities;

import java.util.ArrayList;
import java.util.List;

public class Departamentos {
	private String nome;
	
	List<Funcionario> funcionarios = new ArrayList<>();
	
	public Departamentos () {}
	
	public void addFuncionarios(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void removeFuncionario (Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}
	
	public Departamentos(String nome) {		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
