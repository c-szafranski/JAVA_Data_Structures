import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* CSE 17
 * Donna To
 * dkt220
 * [Assisted by: Rui Sun]
 * Program #3		DEADLINE: November 4, 2017
 * Program Description: Veterinary Hospital_Animal Hospital
 */

public class AnimalHospital {
	private ArrayList<Pet> pets; // stores all pets that are patients of hospital

	/** Constructor */
	public AnimalHospital() {
		this.pets = new ArrayList<>();
		int pets = 5;
	}

	/** Add a pet to end of pets arrayList */
	public void addPet(Pet pet) {
		pets.add(pet);
	}

	/**
	 * Read pets.text and populates pets arrayList this is just reading the file -
	 * not updating the vaccine date yet throws IOException
	 */

	/**
	 * for loop: itterate over string array construct a pet within for loop note
	 * arraylists have array.add(obj)
	 */

	public void readData(String fileName) {
		File file = null;
		Scanner fileX = null;
		
		/*try { 
			fileX = new Scanner(fileName);
			
		}
		catch (FileNotFoundException fileNotHere){
			System.out.println("ERROR - Could not open file " + fileName + ".");
			System.exit(1);
		} */
		
		
		try {
			
			file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			//for(int i = 0; i < 5; i++) {
			while ((line = bufferedReader.readLine()) != null) {
				//line = bufferedReader.readLine();
				System.out.println(line);

				String[] command = line.split("\\s+");
				String animal = command[0];
				String name = command[1];
				String owner = command[2];
				double weight = Double.parseDouble(command[3]);
				int length = command.length;
				//ArrayList<Pet> pets2 = new ArrayList<>();
				

				//if (length == 5) {
					if (animal.equals("BIRD")) {
						boolean clipped = Boolean.parseBoolean(command[4]);
						Bird newBird = new Bird(name, owner, weight, clipped);
						pets.add(newBird);
					}
				//}

			//	if (length == 6) {
					if (animal.equals("DOG")) {
						//Date startDate = null;
						try {
						SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
						Date startDate = stdDate.parse(command[4]);
						String stringDate = stdDate.format(startDate);
						boolean fixed = Boolean.parseBoolean(command[5]);
						Dog newDog = new Dog(name, owner, weight, startDate, fixed);
						pets.add(newDog);

						} catch (ParseException parseEx) {
							
						 System.out.println("ERROR - Vaccine date " + command[4] + " is not mm/dd/yy");
						}
						//String stringDate = stdDate.format(startDate);
						//SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
						//Date startDate = stdDate.parse(command[4]);

					/*	boolean fixed = Boolean.parseBoolean(command[5]);
						Dog newDog = new Dog(name, owner, weight, startDate, fixed);
						pets.add(newDog);*/
					
					}
			//	}
				i++;
			}
			fileReader.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR - Could not open file " + fileName + ".");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** Print pets arraylist contents */
	public void printPetList() {
		for (int i = 0; i < pets.size(); i++) {
			System.out.println(i + ": " + pets.get(i).toString());
		}
	}

	public int getIndex(Pet pet) {
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).equals(pet)) {
				return i;
			}
		}
		return -1;
	}

	/** Return the pet with given index. Else throw exception if invalid index */
	public Pet getPet(int index) {
		Pet petAtIndex = null;
		try {
			petAtIndex = pets.get(index);
		} catch (IndexOutOfBoundsException outBounds) {
			System.out.println("ERROR - Invalid index");
		}
		return petAtIndex;
	}

	/**
	 * read data from pets.txt print out the pets using printPetList() find Spot by
	 * Dick, if pet is a patient, set vaccination date to today's date reprint pets
	 * again
	 */
	public static void main(String[] args) {
		
		AnimalHospital anHom = new AnimalHospital();
		anHom.readData(args[0]);
		anHom.printPetList();
		Date todaysDate = new Date();
		
		for (int i = 0; i < anHom.pets.size(); i++) {
			Pet temp = anHom.getPet(i);
			if (temp.name.equals("Spot") && temp.owner.equals("Dick")) {
				System.out.println("We gotem!");
				((Dog)temp).setVaccineDate(todaysDate);
			}
		}
		anHom.printPetList();
		
		Dog updateDog = new Dog("Spot", "Dick", 63.4, new Date());

		// petToUpdate.setVaccineDate(.args.);
		for (int i = 0; i < anHom.pets.size(); i++) {
			if (anHom.pets.get(i).equals(updateDog)) {
				updateDog.setVaccineDate(todaysDate);
				System.out.println("Vaccinating Dick's dog, Spot...");
				// printPetList();
			}
		}
	}
}