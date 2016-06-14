package maze.domain;

import algorithms.mazeGenerators.Position;
import domains.State;


/**
 * The Class MazeState.
 */
public class MazeState extends State {
	
	/** The current player position. */
	private Position _currPlayerPosition;
	
	/**
	 * Instantiates a new maze state.
	 *
	 * @param pos the position in the maze
	 */
	public MazeState(Position pos) {
		_currPlayerPosition = pos;
		setDescription(pos.toString());
	}	

	/**
	 * Gets the current player position.
	 *
	 * @return the current player position
	 */
	public Position getCurrPlayerPosition() {
		return _currPlayerPosition;
	}

	/**
	 * Sets the current player position.
	 *
	 * @param currPlayerPosition the new current player position
	 */
	public void setCurrPlayerPosition(Position currPlayerPosition) {
		_currPlayerPosition = currPlayerPosition;
	}
	

}
