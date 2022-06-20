import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos numeros serão digitados?");
		
		int N = sc.nextInt();		
		int soma = 0;
		
		for (int i = 0; i < N; i++) {
			System.out.println("Digite o numero:");
			int num = sc.nextInt();
			soma = soma + num;
		}
		
		System.out.println("Soma dos números:" + soma);
		
		sc.close();
	}

}
