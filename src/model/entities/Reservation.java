package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner in = new Scanner(System.in);
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
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
	public void updateDates(Date checkin, Date checkout){
		this.checkin = checkin;
		this.checkout = checkout;
	}
}
