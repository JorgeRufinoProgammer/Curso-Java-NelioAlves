package entities;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nome;
	private int cnpj;
	
	List<Departamentos> departamentos = new ArrayList<>();
	
	public Empresa() {}

	public Empresa(String nome, int cnpj) {		
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public void addDepartamentos(Departamentos departamento) {
		departamentos.add(departamento);
	}
	
	public void removeDepartamento (Departamentos departamento) {
		departamentos.remove(departamento);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public List<Departamentos> getDepartamentos() {
		return departamentos;
	}	
}
