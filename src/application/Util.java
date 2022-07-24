package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Util {
	public static String inputString(String texto) {
		String respostaUsuario = JOptionPane.showInputDialog(texto);
		System.out.print(texto + " "+ respostaUsuario);
		System.out.println();
		return respostaUsuario;
	}
	public static int inputInt(String texto) {
		String somenteNumero = JOptionPane.showInputDialog(texto);
		while(OnlyNumbers(somenteNumero)) {
			output("Digite apenas n�meros!");
			somenteNumero = JOptionPane.showInputDialog(texto);
		}
		int i = Integer.parseInt(somenteNumero);
		System.out.print(texto + " "+ i);
		System.out.println();
		return i;
	}
	public static double inputDouble(String texto) {
		String somenteNumero = JOptionPane.showInputDialog(texto);
		while(OnlyNumbers(somenteNumero)) {
			output("Digite apenas n�meros!");
			somenteNumero = JOptionPane.showInputDialog(texto);
		}
		double i = Double.parseDouble(somenteNumero);
		System.out.print(texto + " "+ i);
		System.out.println();
		return i;
	}
	
	public static void output (Object object) {
		System.out.println(object);
		JOptionPane.showMessageDialog(null, object);
	}
	public static void output (Object object, int mostrarConsole) {
		if (mostrarConsole == 1) {
			System.out.println(object);
		}
		
		JOptionPane.showMessageDialog(null, object);
	}
	
	public static void outputAlerta (Object object, int mostrarConsole) {
		if (mostrarConsole == 1) {
			System.out.println(object);
		}
		
		JOptionPane.showMessageDialog(null, object, "Atenção", 2);
	}
	
	public static String dataHoraAtual() {
		String data = ""+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		return data.substring(0,10) + " - " + data.substring(11, 19);
	}
	
	public static boolean OnlyText(String text) {
	    return ! text.matches("[^\\d]+"); //Passa para o m�todo matches a regex
	    //Se tiver n�mero na string ir� retornar "falso", por isso o uso de "!" para retornar "true"
	    //Note o uso de duas \\, uma sendo obrigat�ria para servir de caractere de escape
	}
	
	public static boolean OnlyNumbers(String text) {
	    return ! text.matches("[^a-zA-Z]+"); //Passa para o m�todo matches a regex
	    //Se tiver letras na string ir� retornar "falso", por isso o uso de "!" para retornar "true"
	    //Note o uso de duas \\, uma sendo obrigat�ria para servir de caractere de escape
	}
}
