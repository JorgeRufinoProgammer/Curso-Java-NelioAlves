package secao_14_heranca.entities;

public class OutsourceEmployee extends Employee{
	private Double additionCharge;

	public OutsourceEmployee() {
		super();
	}
	
	public OutsourceEmployee(String name, Integer hours, Double valuePerHour, Double additionCharge) {
		super(name, hours, valuePerHour);
		this.additionCharge = additionCharge;
	}

	@Override
	public double payment() {
		return super.payment() + additionCharge * 1.1;	
	}
	
	public Double getAdditionCharge() {
		return additionCharge;
	}

	public void setAdditionCharge(Double additionCharge) {
		this.additionCharge = additionCharge;
	}
	
}
