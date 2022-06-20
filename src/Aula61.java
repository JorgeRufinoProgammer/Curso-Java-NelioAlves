import java.util.Scanner;

public class Aula61 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos numeros serão inseridos?");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int higher = max(a,b,c);		
		showResult(higher);
				
		// Poderia ser usado assim tambem que teria o mesmo resultado: showResult(max(a,b,c)); 
		
		sc.close();
	}
	
	public static int max(int x, int y, int z) {
		int aux;
		if (x > y && x > z) {
			aux = x;
		}
		else if (y > z) {
			aux = y;
		}
		else {
			aux = z;
		}
			
		return aux; 
	}
	
	public static void showResult(int value) {
		System.out.println("Higher = " + value);
	}
}
