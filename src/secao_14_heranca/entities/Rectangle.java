package secao_14_heranca.entities;

import entities.enums.Color;

public class Rectangle extends Shape{

	private Double with, height;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(Color color, Double with, Double height) {
		super(color);
		this.with = with;
		this.height = height;
	}

	@Override					//Como a superclasse Shape é abstrata e tem um metodo abstrato, É OBRIGATORIO implementar o metodo abstrato aqui
	public double area() {
		return with * height;
	}

	public Double getWith() {
		return with;
	}

	public void setWith(Double with) {
		this.with = with;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
}
