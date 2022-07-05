package secao_17_Arquivos.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_and_BufferedReader {

	public static void main(String[] args) {
		String path = "c:\\temp\\in.txt";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);	//Ele é instanciado a partir de um FileReader, para otimizar a leitura
			
			String line = bufferedReader.readLine();		//Lê uma linha do arquivo
			while (line != null) {							//Quando nao tiver mais linhas para ler, ele vai retornar "null"
				System.out.println(line);					
				line = bufferedReader.readLine();			//Lê a proxima linha do arquivo
			}
		} 
		catch (IOException e ) {
			System.out.println("Error:" + e.getMessage());
		}
		finally {							//É obrigatorio tratar os erros na hora de fechar os "Readers" 
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
