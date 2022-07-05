package secao_17_Arquivos.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_and_BufferedReader_Melhorado {

	public static void main(String[] args) {
		String path = "c:\\temp\\in.txt";
											//Declarando as variaveis na chamada do "try", ele se encarrega de fechar as conexoes deixando o codigo mais enxuto
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){			
			String line = bufferedReader.readLine();		//Lê uma linha do arquivo
			while (line != null) {							//Quando nao tiver mais linhas para ler, ele vai retornar "null"
				System.out.println(line);					
				line = bufferedReader.readLine();			//Lê a proxima linha do arquivo
			}
		} 
		catch (IOException e ) {
			System.out.println("Error:" + e.getMessage());
		}
	}

}
