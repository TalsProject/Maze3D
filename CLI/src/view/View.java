package view;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;

/**
 * The Interface View.
 */
public interface View {
	
	/**
	 * Display message.
	 *
	 * @param message the message
	 */
	public void displayMessage(String message);
	
	public void displayMaze(Maze3d maze);

	public void displaySolution(Maze3d maze, Solution solution);
	
	/**
	 * Start.
	 */
	public void start();
}
