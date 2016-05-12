package algorithms.search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import domains.Action;
import domains.Searchable;
import domains.State;



/**
 * The Class DFS.
 */
public class DFS extends CommonSearcher {
	
	/** The visited states. */
	private Set<State> _visitedStates = new HashSet<State>();
	
	/** The solution. */
	private Solution _solution;
	

	
	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#search(domains.Searchable)
	 */
	@Override	
	public Solution search(Searchable s) {
		_visitedStates.clear();
		dfs(s, s.getStartState());		
		return _solution;
	}
	
	/**
	 * This function get Searchable - the problem (the adapter) and starting state
	 * and use DFS to solve it.
	 * 
	 *
	 * @param s the the adapter
	 * @param state the starting state
	 */
	private void dfs(Searchable s, State state) {
		if (state.equals(s.getGoalState())) {
			_solution = backtrace(state);
			return;
		}
		
		_visitedStates.add(state);
		
		Map<Action,State> actions = s.getAllPossibleActions(state);
		for(State neighbor: actions.values()) {
			if (!_visitedStates.contains(neighbor)) {
				neighbor.setCameFrom(state);
				dfs(s, neighbor);					
			} 			
		}
		
		return;
	}
}
