/* CSE 17
 * Donna To
 * dkt220
 * Program #2    
 * DEADLINE: October 12, 2017
 * Program: AsciiDisplay_Shape
 */

/** superclass of all the objects that can be draw to the display */
public class Shape
{
  protected String id;
  protected Coordinate location;
  
  public Shape(String id, Coordinate location)
  {
    this.id = id;
    this.location = location;
  }
  
  public void draw(AsciiDisplay dis)
  {
    // virtually draws "?" at LOCATION on the GRID of DIS
  }
  
  public void move(Coordinate newLoc)
  {
    // change the objects LOCATION to NEWLOC
  }
  
  public boolean equals(Object obj)
  {
    // if actual parameter is a Shape with the same ID
    return true;
    // overrides Object's equals() method
  }
}