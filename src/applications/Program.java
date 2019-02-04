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
		Date date = Reservation.sdf.parse(in.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date date2 = Reservation.sdf.parse(in.next());
		
		if(!date2.after(date)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation  r = new Reservation(roomNumber , date , date2);
			System.out.println("Reservation: "+r);
			System.out.println();
			System.out.println("Enter data to update  the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			date = Reservation.sdf.parse(in.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			date2 = Reservation.sdf.parse(in.next());
			
			Date now = new Date();
			if(date.before(now) || date2.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!date2.after(date)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			
			
		}
		
		
		 in.close();
		
		
		
		
		
	}

}
