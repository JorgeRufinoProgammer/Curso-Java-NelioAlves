package secao_17_Arquivos.application;

import java.io.File;
import java.util.Scanner;

public class Informacoes_caminho_arquivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Usar esse caminho "C:\Users\Jorge Rufino\Documents\PROF_SAVE_profile"
		System.out.println("Enter a folder path:");
		String strPath = sc.nextLine();		
		
		File path = new File(strPath);
		
		System.out.println("getName(): " + path.getName());			//Pega somente o nome do arquivo
		System.out.println("getParent(): " + path.getParent());		//Pega somente o caminho do arquivo
		System.out.println("getPath(): " + path.getPath());			//Pega o caminho completo mais o nome
		
		sc.close();
	}

}
