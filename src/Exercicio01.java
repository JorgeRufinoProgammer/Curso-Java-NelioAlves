import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i =1 ; i <= n;i++) {
			int x = i % 2;
			
			/*if (x == 0) {
				System.out.println(i+" é par");
			}*/
			if (x != 0) {
				System.out.println(i+" é ímpar");
			}
		}
		
		sc.close();

	}

}
