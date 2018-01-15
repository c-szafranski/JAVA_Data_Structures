
/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - Rental
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents a rental of an available movie to a customer */
public class Rental extends Transaction {
	private int copiesRemaining;

	/** Constructor */
	public Rental(Customer customer, Movie movie, Date date) {
		super(customer, movie, date);
	}

	/** Setter for copies remaining */
	public void setCopiesRemaining(int copiesRemaining) {
		this.copiesRemaining = copiesRemaining;
	}

	/** Provides a message in the form “'dd-MMM-yyyy' Rented by 'customer-name' ('x' copies remaining)” */
	public String getMovieEventString() {
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dateFormat = df.format(date);
		String message = new String(
				dateFormat + " Rented by " + customer + " (" + copiesRemaining + " copies remaining)");
		return message;
	}

	/** 2 Rental objects are = if they have equivalent customers, movies, and dates */
	public boolean equals(Object o) {
		boolean result;
		if ((this.customer == (((Transaction) o).getCustomer()) 
				&& this.movie == (((Transaction) o).getMovie())
				&& this.date == (((Transaction) o).getDate()))) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
