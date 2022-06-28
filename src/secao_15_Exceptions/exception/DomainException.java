package secao_15_Exceptions.exception;

//Estendendo Exception, é OBRIGATORIO tratar as exceçoes e usar a clausula "throws Nome_da_Classe" nos nomes dos metodos
//Estendendo RuntimeException NÃO É OBRIGATORIO tratar as exceçoes, nem usar a clausula "throws" nos nomes dos metodos

public class DomainException extends Exception{		//Classe Exception é "seriable" e precisa declarar a versão.
	private static final long serialVersionUID = 1L;	//Versão default sugerida pelo proprio Eclipse quando se extend Exception
	
	public DomainException(String msg) {	//Construtor para receber a mensagem que iremos criar e passa-la para a superclasse
		super(msg);
	}
}
