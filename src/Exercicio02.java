import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int in = 0;
		int out = 0;
		
		for(int i =0 ; i < n;i++) {
			int number = sc.nextInt();
			
			if (number > 0) {
				if (number >= 10 && number <= 20) {
					in++;
				}
				else
					out++;
			}			
		}
		
		System.out.println(in + " in");
		System.out.println(out + " out");
		
		sc.close();

	}

}
