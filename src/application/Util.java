package application;

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
			outputString("Digite apenas números!");
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
			outputString("Digite apenas números!");
			somenteNumero = JOptionPane.showInputDialog(texto);
		}
		double i = Double.parseDouble(somenteNumero);
		System.out.print(texto + " "+ i);
		System.out.println();
		return i;
	}
	
	public static void outputString (String texto) {
		System.out.println(texto);
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public static boolean OnlyText(String text) {
	    return ! text.matches("[^\\d]+"); //Passa para o método matches a regex
	    //Se tiver número na string irá retornar "falso", por isso o uso de "!" para retornar "true"
	    //Note o uso de duas \\, uma sendo obrigatória para servir de caractere de escape
	}
	
	public static boolean OnlyNumbers(String text) {
	    return ! text.matches("[^a-zA-Z]+"); //Passa para o método matches a regex
	    //Se tiver letras na string irá retornar "falso", por isso o uso de "!" para retornar "true"
	    //Note o uso de duas \\, uma sendo obrigatória para servir de caractere de escape
	}
}
