package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationExcecoes;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Room number: ");
			int roomNumber = in.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(in.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(in.next());
			
			Reservation  r = new Reservation(roomNumber , checkin , checkout);
			System.out.println("Reservation: "+r);
			
			System.out.println();
			
			System.out.println("Enter data to update  the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(in.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(in.next());
			
			r.updateDates(checkin, checkout);
			System.out.println("Reservation: "+r);
			}
		
		catch(ParseException e) {
			System.out.println("Inválid date format");
		}
		catch(ReservationExcecoes e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid");
		}
		 in.close();
	}

}
