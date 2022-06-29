package secao_15_Exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import secao_15_Exceptions.entities.Reservation;
import secao_15_Exceptions.exception.DomainException;

public class TestaReservation {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Room number:");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date:");
		Date check_in = sdf.parse(sc.next()); 
		System.out.print("Check-out date:");
		Date check_out = sdf.parse(sc.next());
		
		Reservation reserva = new Reservation(roomNumber, check_in, check_out);
		System.out.println(reserva);			
		System.out.println();
		
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date:");
		check_in = sdf.parse(sc.next()); 
		System.out.print("Check-out date:");
		check_out = sdf.parse(sc.next());
			
		reserva.updateDates(check_in, check_out);
		
		System.out.println(reserva);
		}
		catch (ParseException e) {	//Captura erros de conversão 
			System.out.println("Invalid date format!");
		}
		catch (DomainException e) {	//Captura as exceços que foram criadas pelo programador
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {	//Captura erros de entrada de dados diferente do esperado
			System.out.println("Erro de entrada de dados!");
		}
		catch (RuntimeException e) {		//Captura erros genericos
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
