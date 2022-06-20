package entities;

public class Product {
	public String name;
	public int quantity;
	public double price;
	
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
