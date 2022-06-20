package entities;

public class ConversorUnidades {
	public static double litro_para_cent_cubico(double valorLitros) {
		return  valorLitros * 1000.0;
	}
	
	public static double cent_cubico_para_litros(double valor) {
		return valor / 1000.0;
	}
	
	public static double metro_cubico_para_litros(double valor) {
		return valor * 1000;
	}
	
	public static double metro_cubico_para_pesCubicos(double valor) {
		return valor * 35.32;
	}
	
	public static double galao_americano_para_polegadasCubicas(double valor) {
		return valor * 231;
	}
	
	public static double galao_americano_para_litros(double valor) {
		return valor * 3785;
	}
}
