package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Maze3d.
 */
public class Maze3d {
	
	/** The rows. */
	private int rows;
	
	/** The columns. */
	private int cols;
	
	/** The hight. */
	private int hight;
	
	/** The maze3d. */
	private int[][][] maze3d;
	
	/** The start position. */
	private Position startPosition;
	
	/** The goal position. */
	private Position goalPosition;

	/** The Constant WALL. */
	public static final int WALL = 1;
	
	/** The Constant FREE. */
	public static final int FREE = 0;

	/**
	 * Instantiates a new maze3d.
	 *
	 * @param rows the rows
	 * @param cols the columns
	 * @param hight the hight
	 */
	public Maze3d(int rows, int cols, int hight) {		
		this.rows = rows;
		this.cols = cols;
		this.hight = hight;
		maze3d = new int[rows][cols][hight];
	}
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public int[][][] getMaze() {
		return maze3d;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Gets the columns.
	 *
	 * @return the columns.
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Gets the maze3d.
	 *
	 * @return the maze3d.
	 */
	public int[][][] getMaze3d() {
		return maze3d;
	}

	/**
	 * Gets the start position.
	 *
	 * @return the start position.
	 */
	public Position getStartPosition() {
		return startPosition;
	}

	/**
	 * Sets the start position.
	 *
	 * @param startPosition the new start position.
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * Gets the goal position.
	 *
	 * @return the goal position.
	 */
	public Position getGoalPosition() {
		return goalPosition;
	}

	/**
	 * Sets the goal position.
	 *
	 * @param goalPosition the new goal position
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}

	/**
	 * Prints the 3d array of the maze fluently with no levels
	 */
	public void print() {
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				for (int z = 0; z < hight; z++) {
					System.out.print(maze3d[x][y][z] + " ");
				}
				System.out.println();
			}
		}
	}
	
	

	

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	
	//printByLevels each level with getCrossSectionByZ

	public String toString() {
		
        StringBuilder result = new StringBuilder() ;
		
		for (int z = 0; z < hight; z++) {
			result.append("level: " + Integer.toString(z) + " \n");
			int[][] level = getCrossSectionByZ(z);
			int firstDimentionSize = level.length;
			int secondDimentionSize = level[0].length;
			
			for (int i = 0; i < firstDimentionSize; i++) {
				for (int j = 0; j < secondDimentionSize; j++) {
					result.append(String.valueOf(level[i][j]));
					result.append(" ");
				}
				result.append("\n");
			}
			
			result.append("\n");
		}
		return result.toString();
}


	/**
	 * Gets the hight.
	 *
	 * @return the hight
	 */
	public int getHight() {
		return hight;
	}

	/**
	 * This function get a position from the 3D maze and return its possible moves from that point
	 *to a List of directions
	 *
	 * @param postion in the 3D maze
	 * @return List of direction of the possible moves
	 */
	public List<Direction> getPossibleMoves(Position p) {
		List<Direction> options = new ArrayList<>();
		
		if (p.x > 0 && maze3d[p.x - 1][p.y][p.z] == Maze3d.FREE) {
			options.add(Direction.LEFT);
		}
		if (p.x < rows - 1 && maze3d[p.x + 1][p.y][p.z] == Maze3d.FREE) {
			options.add(Direction.RIGHT);
		}
		if (p.y > 0 && maze3d[p.x][p.y - 1][p.z] == Maze3d.FREE) {
			options.add(Direction.FORWARD);
		}
		if (p.y < cols - 1 && maze3d[p.x][p.y + 1][p.z] == Maze3d.FREE) {
			options.add(Direction.BACKWARD);
		}
		if (p.z > 0 && maze3d[p.x][p.y][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN);
		}
		if (p.z < hight - 1 && maze3d[p.x][p.y][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP);
		}
		if (p.z < hight - 1 && p.y > 0 && maze3d[p.x][p.y - 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_FORWARD);
		}
		if (p.z < hight - 1 && p.y < cols - 1 && maze3d[p.x][p.y + 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_BACKWARD);
		}
		if (p.z < hight - 1 && p.x > 0 && maze3d[p.x - 1][p.y][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_LEFT);
		}
		if (p.z < hight - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_RIGHT);
		}
		if (p.z > 0 && p.y > 0 && maze3d[p.x][p.y - 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_FORWARD);
		}
		if (p.z > 0 && p.y < cols - 1 && maze3d[p.x][p.y + 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_BACKWARD);
		}
		if (p.z > 0 && p.x > 0 && maze3d[p.x - 1][p.y][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_LEFT);
		}
		if (p.z > 0 && p.x < rows - 1 && maze3d[p.x + 1][p.y][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_RIGHT);
		}
		if (p.y > 0 && p.x > 0 && maze3d[p.x - 1][p.y - 1][p.z] == Maze3d.FREE) {
			options.add(Direction.FORWARD_LEFT);
		}
		if (p.y > 0 && p.x < rows - 1 && maze3d[p.x + 1][p.y - 1][p.z] == Maze3d.FREE) {
			options.add(Direction.FORWARD_RIGHT);
		}
		if (p.y < cols - 1 && p.x > 0 && maze3d[p.x - 1][p.y + 1][p.z] == Maze3d.FREE) {
			options.add(Direction.BACKWARD_LEFT);
		}
		if (p.y < cols - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y + 1][p.z] == Maze3d.FREE) {
			options.add(Direction.BACKWARD_RIGHT);
		}
		if (p.z < hight - 1 && p.y > 0 && p.x > 0 && maze3d[p.x - 1][p.y - 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_FORWARD_LEFT);
		}
		if (p.z < hight - 1 && p.y < cols - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y + 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.UP_BACKWARD_LEFT);
		}
		if (p.z > 0 && p.y > 0 && p.x > 0 && maze3d[p.x - 1][p.y - 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.UP_FORWARD_RIGHT);
		}
		if (p.z > 0 && p.y < cols - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y + 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.UP_BACKWARD_RIGHT);
		}
		if (p.z < hight - 1 && p.y > 0 && p.x > 0 && maze3d[p.x - 1][p.y - 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_FORWARD_LEFT);
		}
		if (p.z < hight - 1 && p.y < cols - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y + 1][p.z + 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_BACKWARD_LEFT);
		}
		if (p.z > 0 && p.y > 0 && p.x > 0 && maze3d[p.x - 1][p.y - 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_FORWARD_RIGHT);
		}
		if (p.z > 0 && p.y < cols - 1 && p.x < rows - 1 && maze3d[p.x + 1][p.y + 1][p.z - 1] == Maze3d.FREE) {
			options.add(Direction.DOWN_BACKWARD_RIGHT);
		}
		
		return options;
	}
	
	/**
	 * This function get an index in the 3D maze of x dimension 
	 * and return 2 dimension array of the cross section by x
	 *
	 * @param index of x dimension 
	 * @return 2 dimension the cross section by x
	 */
	public int[][] getCrossSectionByX(int index) {
		if (index < 0 || index >= rows) {
			throw new IndexOutOfBoundsException();
		}
		
		int[][] result = new int[cols][hight];
		
		for (int y = 0; y < cols; y++) {
			for (int z = 0; z < hight; z++) {
				result[y][z] = maze3d[index][y][z];
			}
		}
		
		return result;
	}
	
	/**
	 * This function get an index in the 3D maze of y dimension 
	 * and return 2 dimension array of the cross section by y
	 *
	 * @param index of y dimension 
	 * @return 2 dimension the cross section by y
	 * 
	 */
	public int[][] getCrossSectionByY(int index) {
		if (index < 0 || index >= cols) {
			throw new IndexOutOfBoundsException();
		}
		
		int[][] result = new int[rows][hight];
		
		for (int x = 0; x < rows; x++) {
			for (int z = 0; z < hight; z++) {
				result[x][z] = maze3d[x][index][z];
			}
		}
		
		return result;
	}
	
	/**
	 * This function get an index in the 3D maze of z dimension 
	 * and return 2 dimension array of the cross section by z
	 *
	 * @param index of z dimension 
	 * @return 2 dimension the cross section by z
	 * 
	 */
	public int[][] getCrossSectionByZ(int index) {
		if (index < 0 || index >= hight) {
			throw new IndexOutOfBoundsException();
		}
		
		int[][] result = new int[rows][cols];
		
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				result[x][y] = maze3d[x][y][index];
			}
		}
		
		return result;
	}
	
	

}
