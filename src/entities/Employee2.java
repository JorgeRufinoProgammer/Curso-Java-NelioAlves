package entities;

public class Employee2 {
	public String name;
	public double grossSalary, tax;
	
	public double netSalary() {
		return grossSalary - tax;
	}
	public void increaseSalary(double value) {
		grossSalary += grossSalary * value / 100.0;
	}
	public String toString() {
		return name+"\nSalary: $" +String.format("%.2f",netSalary())+"\nTax: " + tax;
	}

}
