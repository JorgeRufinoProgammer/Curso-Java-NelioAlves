package secao_18_Interfaces.services;

import secao_18_Interfaces.entities.CarRental;
import secao_18_Interfaces.entities.Invoice_Nota;
import secao_18_Interfaces.interfaces.TaxService;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {		
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();	//pega a data em milisegundos
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;	//1000 pra transoformar de milisegundos para segundos; 60 para minutos; 60 para horas
		
		double basicPayment;
		if (hours <= 12.0) {	//Math.ceil arredonda para cima
			basicPayment = Math.ceil(hours) * pricePerHour;	
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;	//Dia tem 24 horas 
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice_Nota(basicPayment, tax));
	}
	
	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
		
}
