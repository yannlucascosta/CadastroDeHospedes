package applications;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int roomNumber = in.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = Reservation.sdf.parse(in.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = Reservation.sdf.parse(in.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation  r = new Reservation(roomNumber , checkin , checkout);
			System.out.println("Reservation: "+r);
			
			System.out.println();
			
			System.out.println("Enter data to update  the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = Reservation.sdf.parse(in.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = Reservation.sdf.parse(in.next());
			String error = r.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println("Erro in reservation: "+error);
			}
			else {
				System.out.println("Reservation: "+r);
			}
		}
		
		
		 in.close();
	}

}
