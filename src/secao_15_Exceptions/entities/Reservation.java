package secao_15_Exceptions.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Static para não seja instanciado um novo "sdf" para cada objeto que a aplicacao tiver
	private Integer roomNumber;
	private Date checkin, checkout;
	
	public Reservation() {}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public long duration() {		//retorna um long pois quando se trabalhar com Datas, o Java utiliza long devido pegar a quantidade de segundos de 1970 ate hoje
		long diferenca = checkout.getTime() - checkin.getTime(); //metodo getTime() retorna a quantidade em milisegundos
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //Converte a diferença que estava em miliseg. para Dias
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room nº "
				+ roomNumber
				+", check-in: "
				+sdf.format(checkin)
				+", check-out: "
				+sdf.format(checkout)
				+", "
				+duration()
				+" nights";
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
		
}
