package domains;

import java.util.Map;


/**
 * The Interface Searchable.
 */
public interface Searchable {
	
	/**
	 * Gets the start state.
	 *
	 * @return the start state
	 */
	State getStartState();
	
	/**
	 * Gets the goal state.
	 *
	 * @return the goal state
	 */
	State getGoalState();
	
	/**
	 * This function get a state and return a map of possible action to act
	 * from this given state
	 *
	 * @param state the state
	 * @return the all possible actions
	 */
	Map<Action, State> getAllPossibleActions(State state);
}
