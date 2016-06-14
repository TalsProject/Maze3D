package view;

import algorithms.mazeGenerators.Maze3d;

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

	
	/**
	 * Start.
	 */
	public void start();
}
