import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
CSE 17
Dkt220
[Assisted by: ] 
Program #4 DEADLINE: November 14, 2017
Program Description: Maze solver
*/

public class MazeSolver {
	/**
	 * solves the maze that is passed in uses recursive helper method findPath to
	 * find solution to maze returns arrayList of Cells, one for each step from
	 * start to finish thru maze
	 */
	public static ArrayList<Cell> findPath(Maze currentMaze) {
		ArrayList<Cell> solvedMaze = new ArrayList<Cell>();	
		//solvedMaze.add(currentMaze.getStartCell());
		return findPath(currentMaze, currentMaze.getStartCell(), solvedMaze);
	}

	/**
	 * recursively finds a path from start of the currentMaze to its end that goes
	 * thru current Cell the path is an ArrayList of the sequence of cells that was
	 * followed to get from the start of the maze to the current cell (ie path
	 * explored so far) should avoid revisiting cells already in this path return
	 * null if no path from current to the end that only goes thru each at most once
	 * else return the complete path from start of the maze to the end as a seq of
	 * Cells in arrayList
	 */
	private static ArrayList<Cell> findPath(Maze currentMaze, Cell current, ArrayList<Cell> path) {
		//ArrayList<Cell> newPath = path;
		System.out.println("Visiting (" + current.getRow() + "," + current.getCol()+")");
		if (current.equals(currentMaze.getEndCell())) {
			System.out.println("We made it to the end!");
			path.add(current);
			return path;
		}
		if(path.contains(currentMaze.getEndCell())) {
			return path;
		}
		if (path.contains(current)) {	
			System.out.println("Been here! (" + current.getRow() + "," + current.getCol()+")");
			return path;
		}
		else {
			path.add(current);
		}
		
		
		/** need to check if visited, add to path if not visited? and mark as visited 
		 * loop through neighbors compare each with everyone in path, if no match add it?
		 * but there's no visited method */
		if(currentMaze.getNeighbors(current).size() != 0) {
			ArrayList<Cell> temp = currentMaze.getNeighbors(current);
			for(int i=0; i<temp.size(); i++) {
				System.out.println("i="+i);
				findPath(currentMaze, temp.get(i), path);
			  }
		}
		return path;
		//findPath(currentMaze, newPath.get(newPath.size()-1), newPath);	
		
	}

	/**
	 * prints out maze solution 
	 * get character array for the maze display from the Maze class
	 * add a '.' character in each cell that is part of the solution also
	 * add a '.' in the connector spaces between cells in this solution 
	 * after solution added to display, print entire display to screen (Maze methods will help u do this)
	 * Note: in order to display walls between cells, output will include 2x2 set of
	 * characters for each cell
	 */
	public static void printSolvedMaze(Maze m, ArrayList<Cell> solution) {
		m.getMazeDisplay();
		m.printMaze();
		Cell end = m.getEndCell();
		System.out.println("Cell End(" + end.getRow() + "," + end.getCol()+")");

		for(int i= 0; i<solution.size(); i++) {
			System.out.println(i+ ". Cell (" + solution.get(i).getRow() + "," + solution.get(i).getCol()+")");
		}
		
	}

	/**
	 * user inputs an int mazeId as a command-line argument 
	 * if no command-line given, mazeId = 1
	 * if 2+ command-line give, print ERROR & exit
	 * if command-line cannot be converted to an integer, print ERROR & exit
	 * Else, generate 20widthx6height maze with specified mazeId,
	 * print maze, solve it, print maze again w solution drawn in using characters
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Maze id: ");
		int mazeId = in.nextInt();
		int count = 0;
		count = args.length;
		count++;
		try {
			// System.out.println("Enter a Maze id: ");
			// mazeId = in.nextInt();
			if (args.length == 0) {
				System.out.println("good job u inputed correctly");
				System.out.println(mazeId); //DELETE - checks 
				System.out.println(args.length); //DELETE -checks 
				Maze newMaze = new Maze(20,6,mazeId);
				printSolvedMaze(newMaze, findPath(newMaze));
				
				
			}
			else if (args.length < 0) {
				mazeId = 1;
			}
			if (count > 2) {
				System.out.println("ERROR - Too many command-line arguments.");
				System.out.println(args.length); //DELETE - checks
				System.exit(0);
			}
		} catch (InputMismatchException e) {
			System.out.println(args.length); //DELTE - checks
			System.out.println("ERROR - Input must be a number");
			System.exit(0);
		}

	}
}
