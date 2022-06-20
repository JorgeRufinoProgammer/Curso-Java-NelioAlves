package application;

import javax.swing.JOptionPane;

public class Util {
	public static String inputString(String texto) {		
		return JOptionPane.showInputDialog(texto);
	}
	public static int inputInt(String texto) {
		int i = Integer.parseInt(JOptionPane.showInputDialog(texto));
		return i;
	}
	public static double inputDouble(String texto) {
		double i = Double.parseDouble(JOptionPane.showInputDialog(texto));
		return i;
	}
}
