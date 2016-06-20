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
	
	/**
	 * Display maze.
	 *
	 * @param maze the maze
	 */
	public void displayMaze(Maze3d maze);

	/**
	 * Display solution.
	 *
	 * @param maze the maze
	 * @param solution the solution
	 */
	public void displaySolution(Maze3d maze, Solution solution);
	
	/**
	 * Start.
	 */
	public void start();
}
