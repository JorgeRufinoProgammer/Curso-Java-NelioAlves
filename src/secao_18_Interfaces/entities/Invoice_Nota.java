package secao_18_Interfaces.entities;

public class Invoice_Nota {
	private Double basicPayment;
	private Double tax;
	
	public Invoice_Nota() {}

	public Invoice_Nota(Double basicPayment, Double tax) {		
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
}
