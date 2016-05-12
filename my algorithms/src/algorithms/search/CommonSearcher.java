package algorithms.search;
import java.util.ArrayList;

import domains.State;


/**
 * The Class CommonSearcher.
 */
public abstract class CommonSearcher implements Searcher {
		
	/**
	 * Instantiates a new common searcher.
	 */
	public CommonSearcher() {
		
	}
	
	/**
	 * 
	 * This function get a state and return all the why to this state from 
	 * the beginning and then return the solution with the list of
	 * the way from this state to the beginning state.
	 *
	 * @param state the state
	 * @return the solution
	 */
	protected Solution backtrace(State state) {
		State s = state;
		ArrayList<State> states = new ArrayList<State>();
		while (s != null) {
			states.add(0, s);	
			s = s.getCameFrom();
		}
		Solution solution = new Solution();
		solution.setStates(states);
		return solution;
	}
}
