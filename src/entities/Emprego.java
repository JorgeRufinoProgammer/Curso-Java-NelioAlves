package entities;

public class Emprego {
	private int id;
	private String nome;
	private double salario;
	
	public Emprego(int id, String nome, double salario) {
		
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public void aumentaSalario(double valor) {
		salario += (salario * valor) / 100;
	}
	
	@Override
	public String toString() {
		return  id 
				+", "
				+nome
				+", R$ "
				+String.format("%.2f", salario)
				;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}
	
}
