package algorithms.mazeGenerators;

import java.util.Random;


/**
 * The Class SimpleMaze3dGenerator.
 * represent a simple generator for 3D maze.
 */
public class SimpleMaze3dGenerator extends BaseMaze3dGenerator{

	/** The maze. */
	private Maze3d _maze;
	
	/** The random. */
	private Random _rand = new Random();

	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#generate(int, int, int)
	 */
	@Override
	public Maze3d generate(int rows, int cols, int hight) {
		// Initiate maze
		_maze = new Maze3d(rows, cols, hight);
		// Update all cells to 1
		initMaze3d();

		// Randomly choose and set start enter position.
		chooseEnterPosition();

		// Connect between start position, go to exit , and set the exit as an end position
		goToExit();

		// Add random free cells
		int randomsCell = (int) Math.sqrt(rows * cols * hight);
		
		for (int i = 1; i < randomsCell; i++) {
			_maze.getMaze3d()[_rand.nextInt(rows)][_rand.nextInt(cols)][_rand.nextInt(hight)] = Maze3d.FREE;
		}
		
		return _maze;
	}

	/**
	 * This function initiate the maze3d
	 * by set Walls (1) or Free (0) in all the points in the maze randomly.
	 */
	private void initMaze3d() {
		int[][][] m = _maze.getMaze3d();
		for (int x = 0; x < _maze.getRows(); x++) {
			for (int y = 0; y < _maze.getCols(); y++) {
				for (int z = 0; z < _maze.getHight(); z++) {
					if (_rand.nextInt(2)==1){
						m[x][y][z] = Maze3d.WALL;
					} else {
						m[x][y][z] = Maze3d.FREE;
					}
				}
			}
		}
	}

	/**
	 * Randomly choose and set start enter position.
	 */
	private void chooseEnterPosition() {	
		int x,y,z;
		int external = _rand.nextInt(6);
		if (external < 2){
			if (external == 0){
				x = 0;
			} else {
				x = _maze.getRows() - 1;
			} 
			y = _rand.nextInt(_maze.getCols() - 2) + 1;
			z = _rand.nextInt(_maze.getHight() - 2) + 1;
		} else if(external < 4){
			if (external == 2){
				y = 0;
			} else {
				y = _maze.getCols() - 1;
			}
			x = _rand.nextInt(_maze.getRows() - 2) + 1;
			z = _rand.nextInt(_maze.getHight() - 2) + 1;
		} else {
			if (external == 4){
				z = 0;
			} else {
				z = _maze.getHight() - 1;
			}
			x = _rand.nextInt(_maze.getRows() - 2) + 1;
			y = _rand.nextInt(_maze.getCols() - 2) + 1;
		}

		_maze.setStartPosition(new Position(x, y, z));
	}


	/**
	 * Connect between start position, go to exit , and set the exit as an end position.
	 */
	private void goToExit(){

		Position p = _maze.getStartPosition();
		int[][][] m = _maze.getMaze3d();

		if (p.x == _maze.getRows() - 1 || p.x == 0 ){
			for(int i = 0; i<(_maze.getRows() - 1); i++){
				m[i][p.y][p.z] = Maze3d.FREE;
			}
			_maze.setGoalPosition(new Position(_maze.getRows() - p.x - 1, p.y, p.z));
		} else if (p.y == _maze.getCols() - 1 || p.y == 0){
			for(int i = 0; i<(_maze.getCols() - 1); i++){
				m[p.x][i][p.z] = Maze3d.FREE;
			}
			_maze.setGoalPosition(new Position(p.x, _maze.getCols() - p.y - 1, p.z));
		} else {
			for(int i = 0; i<(_maze.getHight() - 1); i++){
				m[p.x][p.y][i] = Maze3d.FREE;
			}
			_maze.setGoalPosition(new Position(p.x, p.y, _maze.getHight() - p.z - 1));
		}
	}
}





