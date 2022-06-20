import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i =1 ; i <= n;i++) {
			int resto = n % i;
			
			if (resto == 0) {
				System.out.println(i);
			}
				
		}
		
		sc.close();

	}

}
