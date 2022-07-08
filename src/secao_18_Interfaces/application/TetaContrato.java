package secao_18_Interfaces.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Util;
import secao_18_Interfaces.entities.Contrato;
import secao_18_Interfaces.entities.ParcelaContrato;
import secao_18_Interfaces.services.ServicoContrato;
import secao_18_Interfaces.services.ServicoPayPal;

public class TetaContrato {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int numero = Util.inputInt("Numero do contrato:");
		Date data = sdf.parse(Util.inputString("Data do contrato:"));
		double valor = Util.inputDouble("Valor do contrato:");
		int quantidadeParcelas = Util.inputInt("Quantas parcelas?");
		
		Contrato contrato = new Contrato(numero, data, valor);
		ServicoContrato servicoPagamento = new ServicoContrato(new ServicoPayPal());
		servicoPagamento.processarPagamento(contrato, quantidadeParcelas);
		
		System.out.println("Parcelas do contrato nº " + contrato.getNumero());
		for (ParcelaContrato parcela : contrato.getParcelaContrato()) {
			System.out.println(parcela);
		}
	}

}
