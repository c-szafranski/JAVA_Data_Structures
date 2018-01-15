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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.Request;

/** Represents the WebRentz business */
public class VideoBiz {
	private ArrayList<Movie> movies; // list of all movies owned by WebRentz
	private ArrayList<Customer> customers; // list of all customers 

	/**
	 * Reads in the customers and movies from files. Terminates gracefully if error
	 * reading files.
	 */
	public VideoBiz() {
		movies = new ArrayList<Movie>();
		customers = new ArrayList<Customer>();
		readData("/VideoSwagBox/src/customer.txt", "c");
		readData("/VideoSwagBox/src/movies.txt", "m");
	}
	public void readData(String fileName, String option) {
		File file = null;
		Scanner fileX = null;
		
		try {
			System.out.println("Attempting file read..." + fileName);
			file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			int i = 0;
			
			if(option.equals("m")) {
				while ((line = bufferedReader.readLine()) != null) {
					String[] data = line.split("\\s+");
					System.out.println(line);
					movies.add(new Movie(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2])));
				}
			}
			else if(option.equals("c")) {
				while ((line = bufferedReader.readLine()) != null) {
					String[] data = line.split("\\s+");
					System.out.println(line);
					customers.add(new Customer(Integer.parseInt(data[0]),data[1]));
				}
			}
			
			fileReader.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR - Could not open file " + fileName + ".");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readTransaction(String fileName, String option, VideoBiz video) {
		File file = null;
		Scanner fileX = null;
		
		try {
			
			file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			//for(int i = 0; i < 5; i++) {
				while ((line = bufferedReader.readLine()) != null) {
					String[] data = line.split("\\s+");
					System.out.println(line);
					if(data[1].equals("N")) {
						Rental rental = new Rental(video.customers.get(Integer.parseInt(data[2])),video.movies.get(Integer.parseInt(data[3])),new Date(data[0]));
						System.out.println(rental.getMovieEventString());
					}
					else if(data[1].equals("R")) {
						Return rtrn = new Return(video.customers.get(Integer.parseInt(data[2])),video.movies.get(Integer.parseInt(data[3])),new Date(data[0]));
						System.out.println(rtrn.getMovieEventString());
					}
					else {
						System.out.println("Error reading transaction ~bzzt~");
						System.exit(-1);
					}
					
				}
				
			
			fileReader.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR - Could not open file " + fileName + ".");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
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
		VideoBiz videobizzz = new VideoBiz();
		readTransaction(args[0], "t",videobizzz);
	}
}
