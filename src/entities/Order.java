package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {
	private Integer id;
	private Date moment;
	private OrderStatus status;
	
	public Order () {}

	public Order(Integer id, Date moment, OrderStatus order) {		
		this.id = id;
		this.moment = moment;
		this.status = order;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return status;
	}

	public void setOrder(OrderStatus order) {
		this.status = order;
	}
	
	
}
