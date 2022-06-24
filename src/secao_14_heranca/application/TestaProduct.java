package secao_14_heranca.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao_14_heranca.entities.ImportedProduct;
import secao_14_heranca.entities.Product;
import secao_14_heranca.entities.UsedProduct;

public class TestaProduct {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products:");
		int n = sc.nextInt();
		
		List<Product> prodList = new ArrayList<>();
		
		for (int i = 0; i <n ; i++) {
			System.out.println("Product #"+(i +1)+ " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char response = sc.next().charAt(0);
			
			while(response != 'i' && response != 'u' && response != 'c')	{	//Caso a opção nao seja a esperada, pergunta novamente
				System.out.println("Type of product wrong! Try again!");
				System.out.print("Common, used or imported (c/u/i)?");
				response = sc.next().charAt(0);
			}
			
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price:");
			double price = sc.nextDouble();
			
			if (response == 'i') {
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				prodList.add(new ImportedProduct(name, price, customsFee));
			}
			else if (response =='u') {
				System.out.print("Manufacture date (DD/MM/YYYY):");
				Date data = sdf.parse(sc.next());
				prodList.add(new UsedProduct(name, price, data));
			}
			else if (response =='c') {
				prodList.add(new Product(name, price));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product product : prodList) {
			System.out.println(product.priceTag());			
		}
		
		sc.close();
	}

}
