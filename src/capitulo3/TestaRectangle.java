package capitulo3;

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class TestaRectangle {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Rectangle rectangle = new Rectangle();
		
		System.out.print("Enter width of rectangle: ");
		rectangle.width = sc.nextDouble();
		
		System.out.print("\nEnter height of rectangle: ");
		rectangle.height = sc.nextDouble();
		
		System.out.println(rectangle);
		
		sc.close();

	}

}
