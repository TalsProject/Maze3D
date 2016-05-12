package algorithms.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import domains.Action;
import domains.Searchable;
import domains.State;
import maze.domain.MazeAction;
import maze.domain.MazeState;



/**
 * The Class MazeAdapter.
 */
public class MazeAdapter implements Searchable {
	
	/** The 3D maze. */
	private Maze3d _maze;
	
	/**
	 * Instantiates a new maze adapter.
	 *
	 * @param maze the maze
	 */
	public MazeAdapter(Maze3d maze) {
		this._maze = maze;
	}

	/* (non-Javadoc)
	 * @see domains.Searchable#getStartState()
	 */
	@Override
	public State getStartState() {
		return new MazeState(_maze.getStartPosition());
	}

	/* (non-Javadoc)
	 * @see domains.Searchable#getGoalState()
	 */
	@Override
	public State getGoalState() {
		return new MazeState(_maze.getGoalPosition());
	}

	/* (non-Javadoc)
	 * @see domains.Searchable#getAllPossibleActions(domains.State)
	 */
	@Override
	public Map<Action, State> getAllPossibleActions(State state) {
		Map<Action, State> map = new HashMap<>();
		MazeState mazeState = (MazeState)state; 
		Position pos = mazeState.getCurrPlayerPosition();
		List<Direction> directions = _maze.getPossibleMoves(pos);
		
		for (Direction direction : directions){
			
			Action mazeAction = new MazeAction(direction);
			Position nextPos = nextMove(direction , pos);
			State newMazeState = new MazeState(nextPos);
			map.put(mazeAction,newMazeState);
		}
		
		return map;
	}

	/**
	 * This function get the current position and the direction
	 * we want to move to and return the Position destination.
	 *
	 * @param dir the direction
	 * @param pos the position
	 * @return the position
	 */
	public Position nextMove(Direction dir , Position pos){

		switch (dir) {
		case LEFT:
			return (new Position(pos.x-1, pos.y, pos.z));
		case RIGHT:
			return (new Position(pos.x+1, pos.y, pos.z));
		case BACKWARD:
			return (new Position(pos.x, pos.y+1, pos.z));
		case FORWARD:
			return (new Position(pos.x, pos.y-1, pos.z));
		case UP:
			return (new Position(pos.x, pos.y, pos.z+1));
		case DOWN:
			return (new Position(pos.x, pos.y, pos.z-1));
		case UP_FORWARD:
			return (new Position(pos.x, pos.y-1, pos.z+1));
		case UP_BACKWARD:
			return (new Position(pos.x, pos.y+1, pos.z+1));
		case UP_LEFT:
			return (new Position(pos.x-1, pos.y, pos.z+1));
		case UP_RIGHT:
			return (new Position(pos.x+1, pos.y, pos.z+1));
		case DOWN_FORWARD:
			return (new Position(pos.x, pos.y-1, pos.z-1));
		case DOWN_BACKWARD:
			return (new Position(pos.x, pos.y+1, pos.z-1));
		case DOWN_LEFT:
			return (new Position(pos.x-1, pos.y, pos.z-1));
		case DOWN_RIGHT:
			return (new Position(pos.x+1, pos.y, pos.z-1));
		case FORWARD_LEFT:
			return (new Position(pos.x-1, pos.y-1, pos.z));
		case FORWARD_RIGHT:
			return (new Position(pos.x+1, pos.y-1, pos.z));
		case BACKWARD_LEFT:
			return (new Position(pos.x-1, pos.y+1, pos.z));
		case BACKWARD_RIGHT:
			return (new Position(pos.x+1, pos.y+1, pos.z));
		case UP_FORWARD_LEFT:
			return (new Position(pos.x-1, pos.y-1, pos.z+1));
		case UP_BACKWARD_LEFT:
			return (new Position(pos.x+1, pos.y+1, pos.z+1));
		case UP_FORWARD_RIGHT:
			return (new Position(pos.x-1, pos.y-1, pos.z-1));
		case UP_BACKWARD_RIGHT:
			return (new Position(pos.x+1, pos.y+1, pos.z-1));
		case DOWN_FORWARD_LEFT:
			return (new Position(pos.x+1, pos.y-1, pos.z-1));
		case DOWN_BACKWARD_LEFT:
			return (new Position(pos.x+1, pos.y+1, pos.z-1));
		case DOWN_FORWARD_RIGHT:
			return (new Position(pos.x+1, pos.y-1, pos.z-1));
		case DOWN_BACKWARD_RIGHT:
			return (new Position(pos.x+1, pos.y+1, pos.z-1));
		}
		
		return null;
	}
}
