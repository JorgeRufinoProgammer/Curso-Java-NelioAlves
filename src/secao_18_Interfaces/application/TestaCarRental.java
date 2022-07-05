package secao_18_Interfaces.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import application.Util;
import secao_18_Interfaces.entities.CarRental;
import secao_18_Interfaces.entities.Vehicle;
import secao_18_Interfaces.services.BrazilTaxService;
import secao_18_Interfaces.services.RentalService;

public class TestaCarRental {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data:");
		String carModel = Util.inputString("Car model:");
		Date start = sdf.parse(Util.inputString("Pickup (dd/MM/yyyy HH:ss): "));
		Date finish = sdf.parse(Util.inputString("Return (dd/MM/yyyy HH:ss): "));
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		double pricePerHour = Util.inputDouble("Enter price to hour:");
		double pricePerDay = Util.inputDouble("Enter price to day:");
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
		
		sc.close();

	}

}
