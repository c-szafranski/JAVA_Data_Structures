/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - Customer
 */


/** A simple class representing a customer */
public class Customer {
	private String name;
	private int id;

	/** Constructor */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/** 2 Customer objects are == if they have the same id number */
	public boolean equals(Object o) {
		boolean result;
		if (this.id == ((Customer) o).getId()) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
}
