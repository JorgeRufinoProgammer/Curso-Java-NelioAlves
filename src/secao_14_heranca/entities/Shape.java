package secao_14_heranca.entities;

import entities.enums.Color;

public abstract class Shape {		//se a Classe tiver um metodo abstrato, ela tem que ser ABSTRATA TB
	private Color color;

	public Shape() {}
	
	public Shape(Color color) {
		this.color = color;
	}

	public abstract double area();
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
