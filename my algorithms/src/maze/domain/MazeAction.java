package maze.domain;

import java.util.HashMap;
import java.util.Map;

import algorithms.mazeGenerators.Direction;
import domains.Action;



/**
 * The Class MazeAction.
 */
public class MazeAction extends Action {
		
	
	/** The move direction. */
	public final Direction _move;
	
	
	
	/** The Constant MOVEMENT_COST. */
	private static final Map<Direction, Integer> MOVEMENT_COST = new HashMap<>();
	
	static {
		MOVEMENT_COST.put(Direction.LEFT, 1);
		MOVEMENT_COST.put(Direction.RIGHT, 1);
		MOVEMENT_COST.put(Direction.FORWARD, 1);
		MOVEMENT_COST.put(Direction.BACKWARD, 1);
		MOVEMENT_COST.put(Direction.DOWN, 1);
		MOVEMENT_COST.put(Direction.UP, 1);
		MOVEMENT_COST.put(Direction.UP_FORWARD, 20);
		MOVEMENT_COST.put(Direction.UP_BACKWARD, 20);
		MOVEMENT_COST.put(Direction.UP_LEFT, 20);
		MOVEMENT_COST.put(Direction.UP_RIGHT, 20);
		MOVEMENT_COST.put(Direction.DOWN_FORWARD, 20);
		MOVEMENT_COST.put(Direction.DOWN_BACKWARD, 20);
		MOVEMENT_COST.put(Direction.DOWN_LEFT, 20);
		MOVEMENT_COST.put(Direction.DOWN_RIGHT, 20);
		MOVEMENT_COST.put(Direction.FORWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.FORWARD_RIGHT, 20);
		MOVEMENT_COST.put(Direction.BACKWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.BACKWARD_RIGHT, 20);
		MOVEMENT_COST.put(Direction.UP_FORWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.UP_BACKWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.UP_FORWARD_RIGHT, 20);
		MOVEMENT_COST.put(Direction.UP_BACKWARD_RIGHT, 20);
		MOVEMENT_COST.put(Direction.DOWN_FORWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.DOWN_BACKWARD_LEFT, 20);
		MOVEMENT_COST.put(Direction.DOWN_FORWARD_RIGHT, 20);
		MOVEMENT_COST.put(Direction.DOWN_BACKWARD_RIGHT, 20);
	}
	
	/**
	 * Instantiates a new maze action.
	 *
	 * @param move the Direction we want to move to.
	 */
	public MazeAction(Direction move) {
		super(move.toString(), MOVEMENT_COST.get(move));
		_move = move;
	}
}
