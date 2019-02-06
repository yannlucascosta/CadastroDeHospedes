/*O código foi modificado utilizando o tratamento das exceções com 
 * a Classe <IllegalArgumentException>
 * Os tratamentos foram feitos logo no início dos metodos,
 * caracteristicos de boas práticas de programação*/
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.exceptions.ReservationExcecoes;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner in = new Scanner(System.in);
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws ReservationExcecoes {
		if(checkout.before(checkin)) {
			throw new ReservationExcecoes("Check-out must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public String toString() {
		return "Reservation: Room "+getRoomNumber()+","+
				"Check-in: "+sdf.format(getCheckin())+","+
				"Check-out: "+sdf.format(getCheckout())+", "+
				duration()+" nights";
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
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
		
		
		
		
	}
	public void updateDates(Date checkin, Date checkout) throws ReservationExcecoes{
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			 throw new ReservationExcecoes("Reservation dates for update must be future dates");
		}
		if(!checkout.after(checkin)){
			 throw new ReservationExcecoes("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
}
	
