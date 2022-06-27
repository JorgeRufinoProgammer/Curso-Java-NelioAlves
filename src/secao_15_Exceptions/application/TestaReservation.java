package secao_15_Exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import secao_15_Exceptions.entities.Reservation;

public class TestaReservation {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date:");
		Date check_in = sdf.parse(sc.next()); 
		System.out.print("Check-out date:");
		Date check_out = sdf.parse(sc.next());
		
		if (check_in.after(check_out)) { //Objetos Date tem o metodo after que compara se uma data é depois da outra 
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reserva = new Reservation(roomNumber, check_in, check_out);
			System.out.println(reserva);			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date:");
			check_in = sdf.parse(sc.next()); 
			System.out.print("Check-out date:");
			check_out = sdf.parse(sc.next());
				
			String error = reserva.updateDates(check_in, check_out);
			if (error != null) {
				System.out.println(error);
			}
			else {
				System.out.println(reserva);
			}
		}
		
		sc.close();
	}

}
