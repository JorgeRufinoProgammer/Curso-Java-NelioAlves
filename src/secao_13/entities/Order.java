package secao_13.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");	
	private Date moment;
	private OrderStatus status;
	
	private	Client client;
	
	List<OrderItem> orderItem = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {	
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for (OrderItem obj : orderItem) {
			sum += obj.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		String text = "";
		double sum = 0.0;
		text += "Order moment: "
				+ sdf.format(moment)
				+ "\nOrder Status:"
				+status
				+"\nClient:"
				+client.getName() + " (" + sdf2.format(client.getBirthday())+")"
				+" - "+client.getEmail()
				+"\nOrder Items:\n";
		
		for (OrderItem orderItem2 : orderItem) {
			text += orderItem2.getProduct().getName()
					+", $"
					+String.format("%.2f", orderItem2.getPrice())
					+", Quantity: " + orderItem2.getQuantity()
					+", Subtotal: $"+String.format("%.2f", orderItem2.subTotal())
					+"\n";
			sum += orderItem2.subTotal();
		}
		
		text += "\nTotal Price: $" + String.format("%.2f", sum);
		
		return text;
	}
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
