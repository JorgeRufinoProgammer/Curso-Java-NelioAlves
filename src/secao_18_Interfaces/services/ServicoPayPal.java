package secao_18_Interfaces.services;

import secao_18_Interfaces.interfaces.ServicoPagamentosOnline;

public class ServicoPayPal implements ServicoPagamentosOnline{
	private static final double TAXA_PAGAMENTO = 0.02;
	private static final double JUROS= 0.01;
	
	@Override
	public double taxaPagamento(double valor) {
		return valor * TAXA_PAGAMENTO;
	}
	
	@Override
	public double jurosPorParcela(double valor, int numeroParcela) {		
		return valor * JUROS * numeroParcela; 
	}
}
