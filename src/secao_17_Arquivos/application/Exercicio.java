package secao_17_Arquivos.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao_17_Arquivos.entities.Produto;

public class Exercicio {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Usar esse caminho "C:\Users\Jorge Rufino\Documents\produtos.csv"
		System.out.println("Enter a file path:");
		File pathFile = new File (sc.nextLine()); 
		
		new File(pathFile.getParent()+ "\\out").mkdir(); //Cria a pasta "out" no mesmo local do arquivo lido
		
		File pathFileDestiny = new File(pathFile.getParent() + "\\out\\summary.csv");	//Caminho, nome e tipo do arquivo que será criado
		
		List<Produto> listaProdutos = lerArquivo(pathFile);	//Ler o arquivo e devolve uma lista dos produtos 
		
		criaArquivo(pathFileDestiny, listaProdutos);		//Pega a lista de produtos e cria uma subpasta e um novo arquivo com os dados
		
		sc.close();
	}
	
	public static List<Produto> lerArquivo(File pathFile) {
		List<Produto> listaProdutos = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))){			
			String line = bufferedReader.readLine();		//Lê uma linha do arquivo						
					
			while (line != null) {							//Quando nao tiver mais linhas para ler, ele vai retornar "null"									
				String[] dadosProduto = line.split(",");
				listaProdutos.add(new Produto(dadosProduto[0], Double.parseDouble(dadosProduto[1]), Integer.parseInt(dadosProduto[2])));				
				line = bufferedReader.readLine();			//Lê a proxima linha do arquivo				
			}
		} 
		catch (IOException e ) {
			System.out.println("Error:" + e.getMessage());
		}
		return listaProdutos;
	}
	
	public static void criaArquivo(File pathFileDestiny, List<Produto> listaProdutos) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathFileDestiny))){  	//Cria o arquivo e caso ele exista, recria ele
			for (Produto produto : listaProdutos) {
				bw.write(produto.getNome()+","+String.format("%.2f", produto.valorTotal()));	//Ele escreve na primeira linha porem ele nao pula para a proxima linha
				bw.newLine();			//Faz pular uma linha no arquivo para poder escrever a proxima senao ele vai escrever numa linha só
			}
			
			System.out.println(pathFileDestiny + " Created!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
