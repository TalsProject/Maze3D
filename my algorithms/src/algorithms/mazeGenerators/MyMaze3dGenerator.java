package algorithms.mazeGenerators;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The Class MyMaze3dGenerator.
 */
public class MyMaze3dGenerator extends BaseMaze3dGenerator {

	/** The 3d maze. */
	private Maze3d _maze;
	
	/** The random. */
	private Random _rand = new Random();
	
	/** The end position. */
	private static Position _endPos = new Position(-1,-1,-1);
	
	/** The maximum depth. */
	private static int _maxDepth = -1;
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#generate(int, int, int)
	 */
	@Override
	public Maze3d generate(int rows, int cols, int hight) {
		_maze = new Maze3d(rows, cols,  hight);
		
		initMaze3d();
		
		// Choose random start position			
		chooseStartPosition();
		
		DFS(_maze.getStartPosition(), 0);
		_maze.setGoalPosition(_endPos);
		return _maze;
	}
	
	/**
	 * This function initiate the maze3d
	 * by set Walls (1) in all the points in the maze.
	 * 
	 */
	private void initMaze3d() {
		int[][][] m = _maze.getMaze3d();
		for (int x = 0; x < _maze.getRows(); x++) {
			for (int y = 0; y < _maze.getCols(); y++) {
				for (int z = 0; z < _maze.getHight(); z++) {
					m[x][y][z] = Maze3d.WALL;
				}
			}
		}
	}

	/**
	 * This function will randomly choose a start position
	 * and set in the maze.
	 */
	private void chooseStartPosition() {		
		int x = _rand.nextInt(_maze.getRows());
		while (x % 2 == 1)
			x = _rand.nextInt(_maze.getRows());
		
		int y = _rand.nextInt(_maze.getCols());
		while (y % 2 == 1)
			y = _rand.nextInt(_maze.getCols());

		int z = _rand.nextInt(_maze.getHight());
		while (z % 2 == 1)
			z = _rand.nextInt(_maze.getHight());

		
		_maze.setStartPosition(new Position(x, y, z));
	}
	/*

	*/
	
	
	
	/**
	 * Depth-first search algorithm will make the 3D maze.
	 * this function get the start position
	 * @param the start position
	 * @param depth the integer that set to 0 at start and will be the deepest point in the maze
	 * this will use for the end position of the 3D maze.
	 */
	private void DFS(Position pos, int depth) {
		
		List<Direction> dirs = getPossibleDirections(pos);
		 
		if (dirs.size() == 0)
			return;
		
		for (int i = 0; i < dirs.size(); i++) {
		
			// Choose random direction
			int idx = _rand.nextInt(dirs.size());
			Direction dir = dirs.get(idx);
			dirs.remove(idx);
			int[][][] m = _maze.getMaze();
			Position newPos = null;
			
			switch (dir) {
				case LEFT:
					m[pos.x-1][pos.y][pos.z] = Maze3d.FREE;
					m[pos.x-2][pos.y][pos.z] = Maze3d.FREE;
					newPos = new Position(pos.x-2, pos.y, pos.z);
					break;
				case RIGHT:
					m[pos.x+1][pos.y][pos.z] = Maze3d.FREE;
					m[pos.x+2][pos.y][pos.z] = Maze3d.FREE;
					newPos = new Position(pos.x+2, pos.y, pos.z);
					break;
				case BACKWARD:
					m[pos.x][pos.y+1][pos.z] = Maze3d.FREE;
					m[pos.x][pos.y+2][pos.z] = Maze3d.FREE;				
					newPos = new Position(pos.x, pos.y+2, pos.z);
					break;
				case FORWARD:
					m[pos.x][pos.y-1][pos.z] = Maze3d.FREE;
					m[pos.x][pos.y-2][pos.z] = Maze3d.FREE;				
					newPos = new Position(pos.x, pos.y-2, pos.z);
					break;
				case UP:
					m[pos.x][pos.y][pos.z+1] = Maze3d.FREE;
					m[pos.x][pos.y][pos.z+2] = Maze3d.FREE;				
					newPos = new Position(pos.x, pos.y, pos.z+2);
					break;
				case DOWN:
					m[pos.x][pos.y][pos.z-1] = Maze3d.FREE;
					m[pos.x][pos.y][pos.z-2] = Maze3d.FREE;				
					newPos = new Position(pos.x, pos.y, pos.z-2);
					break;
			default:
				break;
			}
				
			if (_maxDepth < depth) {
				_maxDepth = depth;
				_endPos = newPos;
			}
			
			DFS(newPos, depth + 1);
		}
	}
	
	/**
	 * This function get a position from maze3d and return a list of 
	 * the possible directions from this position.
	 *
	 * @param pos the position
	 * @return List of type Direction with the possible directions for this position
	 */
	private List<Direction> getPossibleDirections(Position pos) {
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = _maze.getMaze();
		
		// Check left neighbor
		if (pos.x - 2 >= 0 && m[pos.x-2][pos.y][pos.z] == Maze3d.WALL) {
			dirs.add(Direction.LEFT);
		}
		
		// Check right neighbor
		if (pos.x + 2 < _maze.getRows() && m[pos.x+2][pos.y][pos.z] == Maze3d.WALL) {
			dirs.add(Direction.RIGHT);
		}
		
		// Check FORWARD neighbor
		if (pos.y - 2 >= 0 && m[pos.x][pos.y - 2][pos.z] == Maze3d.WALL) {
			dirs.add(Direction.FORWARD);
		}
				
		// Check BACKWARD neighbor
		if (pos.y + 2 < _maze.getCols() && m[pos.x][pos.y + 2][pos.z] == Maze3d.WALL) {
			dirs.add(Direction.BACKWARD);
		}
		
		// Check DOWN neighbor
		if (pos.z - 2 >= 0 && m[pos.x][pos.y][pos.z - 2] == Maze3d.WALL) {
			dirs.add(Direction.DOWN);
		}
				
		// Check UP neighbor
		if (pos.z + 2 < _maze.getHight() && m[pos.x][pos.y][pos.z + 2] == Maze3d.WALL) {
			dirs.add(Direction.UP);
		}
		
		return dirs;
	}
}
