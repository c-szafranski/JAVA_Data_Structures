import java.util.ArrayList;

/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - Movie
 */

/** Representing a video title */
public class Movie {
	private int id;
	private String title;
	private int numCopies;
	private int numAvailable; // not rented out yet

	private MyQueue<Customer> waitlist; // first-come, first-serve

	private MyLinkedList<Rental> currentRentals; // outstanding rental transactions (i.e not yet returned)

	private ArrayList<Transaction> rentalHistory;

	/** Constructor */
	public Movie(int id, String title, int numCopies) {
		this.id = id;
		this.title = title;
		this.numCopies = numCopies;
		numAvailable = numCopies;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getNumCopies() {
		return numCopies;
	}

	public int getNumAvailable() {
		return numAvailable;
	}

	/** Add customer to end of movie wait list */
	public void addToWaitList(Customer customer) {
		waitlist.enqueue(customer);
	}

	/**
	 * Decrease number available copies by 1
	 * Record this number in the transaction
	 * Add the transaction to both list of current rentals and the rental history */
	public void processRental(Rental rentalTrans) {
		numAvailable--;
	}

	/** 
	 * Remove customer's rental transaction from current rentals
	 * increment numAvail by 1
	 * add the return transaction to the rental history */
	public void processReturn(Return returnTrans) {
	}

	/** Removes the next customer from the wait list and returns it. If wait list is empty, returns null */
	public Customer getNextCustomerFromWaitList() {
		if (waitlist == null) {
			return null;
		}
		else {
			waitlist.dequeue();
			return waitlist.peekIndex(0);
		}
	}

	/** 
	 * Summary Info: id, title, #copies owned
	 * 2 Lists: Rental History and Wait list
	 * Rental History: chronological list of rental/return transactions. Rentals no yet returned indicated with *
	 * New movie requests transactions not displayed
	 * Wait list: numbered list of customers waiting for the movie, in order they made the request
	 * if no rental transactions or no customers waiting for the movie, print n/a for that list */
	public void printMovieDetails() {
		System.out.println("Id: " + this.id + "/tMovie: " + this.title + " (" + this.numAvailable + " total copies)");
		System.out.println("Rental History");
		System.out.println("--------------");
		String rentHistory = new String((Rental)getMovieEventString());
		String returnHistory = new String((Return)getMovieEventString());
		System.out.println(rentHistory);
		System.out.println(returnHistory);
		System.out.println("Wait List");
		System.out.println("------------");
		
	}

	public boolean equals(Object o) {
		boolean result;
		if (this.id == (((Movie) o).getId())) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
}
