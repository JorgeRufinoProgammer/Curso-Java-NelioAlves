package secao_18_Interfaces.interfaces;

public interface ServicoPagamentosOnline {
	
	public double taxaPagamento(double valor);	
	public double jurosPorParcela(double valor, int numeroParcela);	
}
