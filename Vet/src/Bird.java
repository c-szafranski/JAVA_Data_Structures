/* CSE 17
 * Donna To
 * dkt220
 * [Assisted by: ]
 * Program #3		DEADLINE: November 4, 2017
 * Program Description: Veterinary Hospital_Bird
 */

public class Bird extends Pet {
	private boolean clipped;

	/** Constructor */
	public Bird(String name, String owner, double weight, boolean clipped) {
		super(name, owner, weight);
		this.clipped = clipped;
	}

	public boolean isClipped() {
		return clipped;
	}

	public void setClipped(boolean aClipped) {
		// TODO setter for clipped
		clipped = aClipped;
	}

	public String getSize() {
		// implements pets method ?!
		String size;
		if (weight > 2.0) {
			size = "Large";
		} else if (weight < 0.1) {
			size = "Small";
		} else {
			size = "Medium";
		}
		return size;
	}

	public String toString() {
		String birdString = null;
		if (isClipped() == false) {
			birdString = String.format(name + " owned by " + owner + ": " 
								+ getSize() + " Bird, " + weight + " lbs. not clipped");
		}
		return birdString;
	}
}
