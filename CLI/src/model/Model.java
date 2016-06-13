package model;


/**
 * The Interface Model.
 */
public interface Model {
	
	/**
	 * Generate maze.
	 *
	 * @param name the name
	 * @param rows the rows
	 * @param cols the columns
	 * @param hight the hight
	 */
	public void generateMaze(String name, int rows, int cols, int hight);
	
	/**
	 * Save maze.
	 *
	 * @param name the name
	 * @param fileName the file name
	 */
	public void saveMaze(String name, String fileName);
	
	/**
	 * Load maze.
	 *
	 * @param fileName the file name
	 * @param name the name
	 */
	public void loadMaze(String fileName, String name);
	
	/**
	 * Maze to string.
	 *
	 * @param name the name of the maze
	 * @return the string
	 */
	public String mazeToString(String name);
	
	/**
	 * Gets the cross section by x.
	 *
	 * @param name the name
	 * @param index the index
	 * @return the cross section by x
	 */
	public String getCrossSectionByX(String name, int index);
	
	/**
	 * Gets the cross section by y.
	 *
	 * @param name the name
	 * @param index the index
	 * @return the cross section by y
	 */
	public String getCrossSectionByY(String name, int index);
	
	/**
	 * Gets the cross section by z.
	 *
	 * @param name the name
	 * @param index the index
	 * @return the cross section by z
	 */
	public String getCrossSectionByZ(String name, int index);
	
	/**
	 * Maze size.
	 *
	 * @param name the name
	 */
	public void mazeSize(String name);
	
	/**
	 * File size.
	 *
	 * @param filePath the file path
	 */
	public void fileSize(String filePath);
	
	/**
	 * Prints the files within directory.
	 *
	 * @param filePath the file path
	 */
	public void printFilesWithinDirectory(String filePath);
	
	/**
	 * Solve maze.
	 *
	 * @param name the name
	 * @param algoritem the algorithm
	 */
	public void solveMaze(String name, String algoritem);
	
	/**
	 * Display solution.
	 *
	 * @param name the name
	 */
	public void displaySolution(String name);
	
	public String getMessage();
	
	public void saveSolutions();
	
	public void readSolutions();
	
	/**
	 * Interrupt.
	 *
	 * @return true, if successful
	 */
	public boolean interrupt();

}
