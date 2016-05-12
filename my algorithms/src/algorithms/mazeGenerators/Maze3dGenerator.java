package algorithms.mazeGenerators;


/**
 * The Interface Maze3dGenerator.
 */
public interface Maze3dGenerator {

	/**
	 * This function will generate a 3D maze.
	 *
	 * @param rows the size of rows of the 3d maze
	 * @param cols the size of columns of the 3d maze
	 * @param hight the size of hight of the 3d maze
	 * @return the maze3d
	 */
	Maze3d generate(int rows, int cols, int hight);
	
	/**
	 * This function will measure the time its takes to generate the 3D maze
	 *
	 * @param rows the size of rows of the 3d maze
	 * @param cols the size of columns of the 3d maze
	 * @param hight the size of hight of the 3d maze
	 * @return a string in millisecond of time its takes to generate the 3D maze
	 */
	String measureAlgorithmTime(int rows, int cols, int hight);
}
