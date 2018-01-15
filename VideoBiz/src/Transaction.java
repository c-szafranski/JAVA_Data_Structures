/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - Transaction
 */

import java.util.Date;

/** Abstract class representing a transaction (either new movie request, rental or return) */
public abstract class Transaction {
	protected Customer customer;
	protected Movie movie;
	protected Date date;

	/** Constructor */
	public Transaction(Customer customer, Movie movie, Date date) {
		this.customer = customer;
		this.movie = movie;
		this.date = date;
	}

	/** Getters */
	public Customer getCustomer() {
		return customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public Date getDate() {
		return date;
	}

	/** Abstract method that returns a summary of the transaction suitable for display when grouped by movie */
	public abstract String getMovieEventString();

}
