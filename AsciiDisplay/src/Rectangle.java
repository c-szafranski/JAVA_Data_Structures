
/* CSE 17
 * Donna To
 * dkt220
 * Program #2    
 * DEADLINE: October 12, 2017
 * Program: AsciiDisplay_Rectangle
 */

/** subclass of Shape */ 
public class Rectangle extends Shape 
{
  private int length;
  private int height;
  
  public Rectangle(String id, Coordinate loc, int length, int height)
  {
    super(id,loc);
    this.length = length;
    this.height = height;
  }
  
  public void draw(AsciiDisplay dis)
  {
    /*
     * updates GRID of DIS by drawing a filled-in rectangle with top 
     * left corner LOC that is HEIGHT characters tall and LENGTH wide
     * should not print to screen - use AsciiDisplay printGrid()
     * borders and interior filled with "#"'s
     */
  }
}