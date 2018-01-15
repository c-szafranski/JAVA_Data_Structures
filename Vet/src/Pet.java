/* CSE 17
 * Donna To
 * dkt220
 * [Assisted by: ]
 * Program #3		DEADLINE: November 4, 2017
 * Program Description: Veterinary Hospital_Pet
 */

public abstract class Pet {
	protected String name;
	protected String owner;
	protected double weight;
	
	/** Constructor */
	public Pet(String name, String owner, double weight) {
		this.name = name;
		this.owner = owner;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double aWeight) {
		weight = aWeight;
	}
	
	/** returns small, medium, large relative to same type animals */
	public abstract String getSize();
	
	public String toString() {
		return String.format(name + " owned by " + owner + ": " + getSize() + " Pet, " + weight + " lbs.");
	}
	
	/** overrides Object's equals() to return true if o has same name and owner */
	public boolean equals(Object o) {
		boolean flag = false;
		if ((((Pet) o).getName() == this.name) && (((Pet) o).getOwner() == this.owner)) {
			flag = true;
		}
		return flag;
	}
}
