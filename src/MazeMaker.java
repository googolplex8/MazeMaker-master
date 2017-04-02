import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//select a random cell to start
		int randWidth = randGen.nextInt(maze.getWidth()-1);
		int randHeight = randGen.nextInt(maze.getHeight()-1);
		selectNextPath(maze.getCell(randWidth, randHeight));
		//call selectNextPath method with the randomly selected cell
		removeWalls(maze.getCell(0, 0), maze.getCell(0, 1));
		return maze;
	}

	private static void selectNextPath(Cell currentCell) {
		// mark current cell as visited
		// check for unvisited neighbors
		
		currentCell.setBeenVisited(true);
		if(getUnvisitedNeighbors(currentCell).size()>0){
			uncheckedCells.push(getUnvisitedNeighbors(currentCell).get(randGen.nextInt(getUnvisitedNeighbors(currentCell).size())));
		
		}
		// if has unvisited neighbors,
			// select one at random.
			// push it to the stack
			// remove the wall between the two cells
			// make the new cell the current cell and mark it as visited
		
			//call the selectNextPath method with the current cell
			
		// if all neighbors are visited
			//if the stack is not empty
				// pop a cell from the stack
				// make that the current cell
		
				//call the selectNextPath method with the current cell
	}

	private static void removeWalls(Cell c1, Cell c2) {
		int x1 = c1.getX();
		int x2 = c2.getX();
		int y1 = c1.getY();
		int y2 = c1.getY();
		if(x1==x2){
			if(y1>=y2){
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
			else{
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
		}
		if(y1==y2){
			if(x1>x2){
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
			else{
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
		}
	}

	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		if((c.getX()>=0 && c.getX()<=maze.getWidth()) && (c.getY()+1>=0 && c.getY()+1<=maze.getHeight())&&(maze.getCell(c.getX(), getY()+1).hasBeenVisited()==false)){
			neighbors.add(maze.getCell(c.getX(), getY()+1));
		}
		if((c.getX()>=0 && c.getX()<=maze.getWidth()) && (c.getY()-1>=0 && c.getY()-1<=maze.getHeight())&&(maze.getCell(c.getX(), getY()-1).hasBeenVisited()==false)){
			neighbors.add(maze.getCell(c.getX(), getY()-1));
		}
		if((c.getX()+1>=0 && c.getX()+1<=maze.getWidth()) && (c.getY()>=0 && c.getY()<=maze.getHeight())&&(maze.getCell(c.getX()+1, getY()).hasBeenVisited()==false)){
			neighbors.add(maze.getCell(c.getX()+1, getY()));
		}
		if((c.getX()-1>=0 && c.getX()-1<=maze.getWidth()) && (c.getY()>=0 && c.getY()<=maze.getHeight())&&(maze.getCell(c.getX()+1, getY()).hasBeenVisited()==false)){
			neighbors.add(maze.getCell(c.getX()-1, getY()));
		}
		return neighbors;
	}

	private static int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
}