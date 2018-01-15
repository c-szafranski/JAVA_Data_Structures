/* CSE 17
 * Donna To
 * dkt220
 * Program #2    
 * DEADLINE: October 12, 2017
 * Program: AsciiDisplay_Square
 */

/** subclass of Rectangle */
public class Square extends Rectangle
{
  private int size;

public Square (String id, Coordinate loc, int size)
  {
    super(id, loc, size, size);
    this.size = size; // size is the length of all the sides of the square
  }
}

// what