import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Christopher Szafranski
 *
 */
public class AsciiDisplay {

	private char[][] grid; 
	  private ArrayList<Shape> shapes; // collection of Shape objects to be displayed
	  public AsciiDisplay(char[][] grid, ArrayList<Shape> shapes)
	  {
	    this.grid = grid;
	    this.shapes = shapes;
	  }
	  
	  // should not alter grid array
	  public void addShape(Shape s)
	  {
	    //shapes.add(new Shape());
	  }
	  
	  public int moveShape(String id, Coordinate newLoc)
	  {
	    //shapes.move(int id ,new Shape(id, newLoc));
	    // moves shape w/ new id to newLoc, returns 0. 
	    // if shape not in shapes, return -1
		  return 1;
	  }
	  
	  public void printGrid()
	  {
	    // call updateGrid(), print grid contents
	  }
	  
	  public void deleteAll()
	  {
	    // +.clear():void ? 
	  }
	  
	  
	  public void putChar(int x, int y, char c)
	  {
	    // put c at (x,y) on grid
	    // x = column, y = row
	  }
	  
	  private void updateGrid()
	  {
	    // +.clear():void grid
	    // "draws" each element of shapes in it 
	  }
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Check for args 
			//if(args) do stuff
			//else print usage	
		//
		if (args.length == 1)
	    {
			AsciiDisplay display = fileReader(args[0]);
	      
	    }
	    else 
	    {
	    System.out.println("Usage: java\n" + 
				"AsciiDisplay filename");
	    System.exit(0);//optional you could loop or just exit
	    }
	}


	private static AsciiDisplay fileReader(String filename) {
		// TODO Auto-generated method stub
		try {
			char[][] temp = new char[30][15];
			ArrayList<Shape> shapesTemp = new ArrayList<Shape>();
			
		      File file = new File(filename);
		      FileReader fileReader = new FileReader(file);
		      BufferedReader bufferedReader = new BufferedReader(fileReader);
		      String line;
		      while ((line = bufferedReader.readLine()) != null)
		      {
		        //TO DO break string into String[] using String.split(".~something~...")
		        
		        String[] command = line.split("\\s+");
		        System.out.println(line); 
		        int len = command.length;
		        if(len == 6) {
			        	if(command[0].equals("R")) {
			        		//run makeRectangle()
			        	}
			        	else {
		        			System.out.println("This is a bad command");
		        			//System.exit(0);
		        		}
		        }
		        else if(len == 5) {
			        	if(command[0].equals("S")) {
			        		//run makeSquare()
			        	}
			        	else {
		        			System.out.println("This is a bad command");
		        			//System.exit(0);
		        		}
		        }
		        else if(len == 4) {
			        	if(command[0].equals("M")) {
		        			//run doMove()
		        		}
		        		else if(command[0].equals("P")) {
		        			makePoint(command, temp , shapesTemp);
		        		}
		        		else {
		        			System.out.println("This is a bad command");
		        			//System.exit(0);
		        		}
	        		
		        }
		        else if(len == 1) {
		        		if(command[0].equals("E")) {
		        			//run eraseAll()
		        		}
		        		else if(command[0].equals("D")) {
		        			//run drawAll();
		        		}
		        		else {
		        			System.out.println("This is a bad command");
		        			//System.exit(0);
		        		}
	        		
		        }
		        
		        
		      }
		      fileReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		///AsciiDisplay/src/face.txt
		
		return new AsciiDisplay(new char[30][15],new ArrayList<Shape>());
	}
	private static AsciiDisplay makePoint(String[] strar, char[][] grid, ArrayList<Shape> shapes) {
		
		Point temp = new Point(strar[1], new Coordinate(Integer.parseInt(strar[2]), Integer.parseInt(strar[3])));
		shapes.add(temp);
		
		return new AsciiDisplay(new char[30][15],new ArrayList<Shape>());
	}

}
