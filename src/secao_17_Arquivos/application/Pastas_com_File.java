package secao_17_Arquivos.application;

import java.io.File;
import java.util.Scanner;

public class Pastas_com_File {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Usar esse caminho "C:\Users\Jorge Rufino\Documents"
		System.out.println("Enter a folder path:");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//Cria um vetor de "Files" pegando a lista de pastas/diretorios do caminho especificado
		File[] folders =  path.listFiles(File::isDirectory);	
		System.out.println("FOLDERS:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		System.out.println();
		
		File[] files =  path.listFiles(File::isFile);	//Cria um vetor de "Files" pegando a lista de arquivos do caminho especificado
		System.out.println("FILES:");
		for (File file : files) {
			System.out.println(file);
		}
		
		//Criando uma pasta/subpasta
		boolean success = new File(strPath + "\\subpasta").mkdir();	//Ele cria pasta e retorna "true" ou "false" caso dê algum erro ou caso a pasta ja exista
		System.out.println("Directory created successfully: " + success);
		
		sc.close();
	}

}
