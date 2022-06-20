package entities;

public class Estudante {
	public String nome;
	public double nota1, nota2, nota3;
	
	public double notaFinal() {
		return nota1+nota2+nota3;
	}
	public String situacao() {
		if (notaFinal() >= 60) {
			return "PASSED";
		}
		else {			
			return "FAILED";
		}
	}
}
