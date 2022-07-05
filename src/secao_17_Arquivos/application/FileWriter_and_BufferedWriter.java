package secao_17_Arquivos.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_and_BufferedWriter {

	public static void main(String[] args) {
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		String path = "c:\\temp\\out.txt";	//Caminho e o nome do arquivo que será criado ou alterado dependendo da regra

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){  	//Cria o arquivo e caso ele exista, recria ele
			for (String line : lines) {
				bw.write(line);			//Ele escreve na primeira linha porem ele nao pula para a proxima linha
				bw.newLine();			//Faz pular uma linha no arquivo para poder escrever a proxima senao ele vai escrever numa linha só
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){	//Se ja existir o arquivo, ele escreve no final
			bw.write("-----------------------");
			bw.newLine();
			for (String line : lines) {
				bw.write(line);			//Ele escreve na primeira linha porem ele nao pula para a proxima linha
				bw.newLine();			//Faz pular uma linha no arquivo para poder escrever a proxima senao ele vai escrever numa linha só
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
