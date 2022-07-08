package secao_18_Interfaces.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Util;
import secao_18_Interfaces.entities.Contrato;
import secao_18_Interfaces.entities.ParcelaContrato;

public class TetaContrato {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int numero = Util.inputInt("Numero do contrato:");
		Date data = sdf.parse(Util.inputString("Data do contrato:"));
		double valor = Util.inputDouble("Valor do contrato:");
		int quantidadeParcelas = Util.inputInt("Quantas parcelas?");
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		for (int i = 1 ; i <= quantidadeParcelas; i++) {
			ParcelaContrato parcelaContrato = new ParcelaContrato(quantidadeParcelas);
			parcelaContrato.setValorParcela(valor, i);
			contrato.addParcela(parcelaContrato);
		}
		
		for (ParcelaContrato parcela : contrato.getParcelaContrato()) {
			System.out.println(parcela.getValorParcela());
		}
		
		System.out.println("Valor das Parcelas:");
	}

}
