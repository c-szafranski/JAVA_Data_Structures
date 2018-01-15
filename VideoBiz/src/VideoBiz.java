/*
 * CSE 17
 * Donna To
 * dkt220
 * [with assistance from tutor name (tutor email)]
 * Program #5		DEADLINE: December 8, 2017
 * Program: WebRentz Movie Rental System - VideoBiz
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Represents the WebRentz business */
public class VideoBiz {
	private ArrayList<Movie> movies; // list of all movies owned by WebRentz
	private ArrayList<Customer> customers; // list of all customers 

	/**
	 * Reads in the customers and movies from files. Terminates gracefully if error
	 * reading files.
	 */
	public VideoBiz() {
		/*File file = null;
		String title;
		int id;
		int numCopies;
		try {
			file = new File("/Users/Tod/Desktop/movies.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] command = line.split("\\t+");
				id = Integer.parseInt(command[0]);
				title = command[1];
				numCopies = Integer.parseInt(command[2]);
			}
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR - Could not open file " + file + ".");
			System.exit(1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			file = new File("/Users/Tod/Desktop/customers.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] command = line.split("\\t+")
			}
		}*/
		int currentLine = 0;
		Scanner fileInput = null;
		File movieFile = new File("/Users/Tod/Desktop/movies.txt");
		File customerFile = new File("/Users/Tod/Desktop/customers.txt");
		try {
			fileInput = new Scanner(movieFile).useDelimiter("\\t|[\\n\\r\\f]+");
		} catch (FileNotFoundException ex) {
			System.out.println("“ERROR – Could not open file " + movieFile + ".");
			System.exit(0);
		}
		
		while (fileInput.hasNext() == true) {
			currentLine++;
			String type = fileInput.next();
			int id = fileInput.nextInt();
			String title = fileInput.next();
			int numCopies = fileInput.nextInt();
			
			
		}

		try {
			fileInput = new Scanner(customerFile).useDelimiter("\\t|[\\n\\r\\f]+");
		} catch (FileNotFoundException ex) {
			System.out.println("“ERROR – Could not open file " + customerFile + ".");
			System.exit(0);
		}
		
		while (fileInput.hasNext() == true) {
			currentLine++;
			int id = fileInput.nextInt();
			String name = fileInput.next();
			
		}
	}

	/** If there are avail. copies of the movie (specified by requestTrans), then creates rental transaction w/ same date and processes it
	 * otherwise, adds the customer to the end of the wait list */
	public void processNewRequest(NewRequest requestTrans) {

	}

	/** Removes the rental for the movie (increase number of avail. copies)
	 * Rents the movie to the next person (if any) on the wait list by creating a rental transaction w/ same date and processing it */
	public void processReturn(Return returnTrans) {

	}

	/** Reads a set of a new request and return transaction from the given file & processes them
	 * Ignore invalid values
	 * Assume that every transaction has the required fields */
	public void processTransactionFile(File transFile) {
	}

	public Customer getCustomerById(int id) {
		return null;

	}

	public Movie getMovieById(int id) {
		return null;

	}

	public void printMovieReport() {

	}

	public static void main(String[] args) {

	}
}
