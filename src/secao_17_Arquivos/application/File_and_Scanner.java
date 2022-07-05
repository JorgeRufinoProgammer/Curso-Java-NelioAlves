package secao_17_Arquivos.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class File_and_Scanner {

	public static void main(String[] args) {
		File file = new File("c:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);					//Instanciou  o Scanner com o File
			while(sc.hasNextLine()) {				//Enquanto tiver uma proxima linha para ser lida, ele continua no laço
				System.out.println(sc.nextLine());	//Imprime as linhas
			}
		} 
		catch (IOException e) {					//É obrigatorio usar try/catch pois ao tentar abrir um arquivo, pode gerar um exceçao EXCEPTION
			System.out.println("Error: " + e.getMessage());
		}				
		finally {				//Executa o "finally" independente de ter dado erro
			if (sc != null) {	//Testar para ver se o Scanner foi instaciado corretamente (se conseguiu abrir o arquivo), pois se acontecer 
								//um erro no momento de abrir/instanciar o Scanner, o "sc.close" irá dar um erro de "NullPointerException"
								//pois o Scanner estava com valor nulo
				sc.close();
			}
		}
	}

}
