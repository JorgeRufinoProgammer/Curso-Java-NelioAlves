package entities;

public class ProductV2 {
	private String name;
	private int quantity;
	private double price;
	
	public ProductV2(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public ProductV2(String name, double price) {
		this.name = name;
		this.price = price;		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double totalValueEstock() {
		return quantity * price;
	}
	//Como o atributo Quantidade tem o mesmo nome/referencia do parametro do metodo, usa-se o "this"
	public void addProducts(int quantity) {	 
		this.quantity += quantity;			//O "this.quantity" referencia o atributo da classe, e o quantity é o parametro do metodo
	}
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	public String toString() {
		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $" + String.format("%.2f", totalValueEstock());
	}
}
