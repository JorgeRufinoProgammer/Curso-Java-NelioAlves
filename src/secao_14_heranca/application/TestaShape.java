package secao_14_heranca.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.Color;
import secao_14_heranca.entities.Circle;
import secao_14_heranca.entities.Rectangle;
import secao_14_heranca.entities.Shape;

public class TestaShape {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of shapes:");
		int n = sc.nextInt();
		
		List<Shape> shapeList = new ArrayList<Shape>();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Shaper #"+(i+1)+" data:");
			System.out.println("Rectangle or Circle (r/c)?");
			char response = sc.next().charAt(0);
			System.out.println("Color (BLACK/BLUE/RED):");
			Color color = Color.valueOf(sc.next());
			
			if (response == 'r') {
				System.out.print("Width:");
				double width = sc.nextDouble();
				System.out.print("Height:");
				double height = sc.nextDouble();
				shapeList.add(new Rectangle(color, width, height));
			}
			if(response == 'c') {
				System.out.print("Radius:");
				double radius = sc.nextDouble();
				shapeList.add(new Circle(color, radius));
			}
		}
		
		System.out.println();
		System.out.println("SHAPES AREAS:");
		for (Shape shape : shapeList) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		sc.close();
	}

}

