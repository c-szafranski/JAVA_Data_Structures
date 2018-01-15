import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* CSE 17
 * Donna To
 * dkt220
 * [Assisted by: ]
 * Program #3		DEADLINE: November 4, 2017
 * Program Description: Veterinary Hospital_Dog
 */

public class Dog extends Pet 
	implements Vaccinatable {
	
	private boolean fixed;			// true if dog has been fixed
	private Date vaccineDate;		// date of last vaccination

	/** Constructor without parameter, fixed */
	public Dog(String name, String owner, double weight, Date vaccineDate) {
		super(name, owner, weight);
		this.vaccineDate = vaccineDate;
		fixed = false;
	}
	
	/** Constructor with parameter, fixed */
	public Dog(String name, String owner, double weight, Date vaccineDate, boolean fixed) {
		super(name, owner, weight);
		this.vaccineDate = vaccineDate;
		this.fixed = fixed;
	}
	
	public String getSize() {
		// implement Pet's method?? 
		String size;
		if (weight < 30) {
			size = "Small";
		} else if (weight > 50) {
			size = "Large";
		} else {
			size = "Medium";
		}
		return size;
	}
	
	public Date getVaccineDate() {
		return vaccineDate;
	}
	
	public void setVaccineDate(Date aVaccineDate) {
		vaccineDate = aVaccineDate;
	}
	
	/** Parse the string as a date in specified format and returns it. If incorrect format, throw */
	public Date parse(String source) {
		Date result = null;
		try {
			SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
			result = (Date)stdDate.parse(source);
			
		} catch (ParseException parseEx) {
			System.out.println("ERROR - Vaccine date " + source + " is not in mm/dd/yy format! Skipping line "); // + line-number/index
		}
		return result;
	}
	
	/** Returns string representing the Date in specified format */
	public String format(Date date) {
		SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
		String result = stdDate.format(date);
		return result;
	}
	
	public boolean isFixed() {
		return fixed;
	}
	
	public void setFixed(boolean aFixed) {
		fixed = aFixed;
	}
	public String toString() {
		return String.format( name + " owned by " + owner + ": " + getSize() + " Dog, " 
		+ weight + " lbs. not fixed, last vaccine: "+ vaccineDate);
	}
}
