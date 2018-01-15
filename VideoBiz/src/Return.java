/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - Return
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents a customer returning a copy of a movie */
public class Return extends Transaction {

	/** Constructor */
	public Return(Customer customer, Movie movie, Date date) {
		super(customer, movie, date);
	}

	/** Provides a message in the form “'dd-MMM-yyyy' Returned by 'customer-name'” */
	public String getMovieEventString() {
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dateFormat = df.format(date);
		String message = new String(dateFormat + " Returned by " + customer);
		return message;
	}

	/** 2 Return objects are = if they have equivalent customers, movies, and dates */
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
