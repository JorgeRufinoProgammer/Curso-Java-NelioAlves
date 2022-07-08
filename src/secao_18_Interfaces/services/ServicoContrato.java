package secao_18_Interfaces.services;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import secao_18_Interfaces.entities.Contrato;
import secao_18_Interfaces.entities.ParcelaContrato;
import secao_18_Interfaces.interfaces.ServicoPagamentosOnline;

public class ServicoContrato {		
	
	private ServicoPagamentosOnline servicoPagamentoOnline;
	
	public ServicoContrato(ServicoPagamentosOnline servicoPagamentoOnline) {		
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processarPagamento(Contrato contrato, int quantidadeDeParcelas) {
		Date dataParcela = contrato.getData();
		Calendar cal = Calendar.getInstance();
		
		for (int i = 1; i <= quantidadeDeParcelas; i++) {
			double valorBase = (double) contrato.getValor() / quantidadeDeParcelas;			
			double valorBaseJuros = valorBase + servicoPagamentoOnline.jurosPorParcela(valorBase, i);			
			double valorParcela = valorBaseJuros + servicoPagamentoOnline.taxaPagamento(valorBaseJuros);
			
			JOptionPane.showMessageDialog(null, valorBaseJuros);
			
			cal.add(Calendar.MONTH, 1); //adiciona 1 mes a data/hora
			dataParcela = cal.getTime();
			
			ParcelaContrato parcelaContrato = new ParcelaContrato(dataParcela, valorParcela);
			contrato.addParcela(parcelaContrato);
		}		
	}
}
