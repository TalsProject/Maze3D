package algorithms.search;

import java.util.AbstractQueue;
import java.util.Map;
import java.util.Map.Entry;
import domains.Action;
import domains.Searchable;
import domains.State;



/*
 * questions from Java project part B:
 * 1: 
 * Option A : The advantage inherent from BreadthFS to BestFS is
 * that you are not making extra double code and you can play with the
 * Costs in one place without touching the code of BreadthFS 
 * Because the BreadthFS have a LinkedBlockingQueue or an arrayblockingQueue and not
 * a PriorityQueue so it dose not affect him anyway he will find
 * the shortest whey for his destination regardless the Costs effect.
 * 
 * 
 * Option B :The advantage of just put 2 Class one for BreadthFS
 * and one for BestFS is that we can easily change one 
 * algorithm without influence the other one.
 * and we can copy the same code and only put 1 for all Costs in the BreadthFS as default.
 * 
 * 
 * 2.
 *  I chose the first option because the advantage I mentioned in the first question
 * but with a little "twist"
 * Instead of inherent I made a BfsFactory class with 2 function that will make the 2 option 
 * and send a specific type of  Queue for BreadthFS - LinkedBlockingQueue
 * and for BestFS a PriorityQueue as suggest in option A.
 * 
 */

/**
 * The Class BFS.
 * This class use for both Best FS and Breadth FS algorithms.
 */
public class BFS extends CommonSearcher {
	
	

	/** The open queue. */
	protected AbstractQueue<State> _openQueue;
	
	/** The closed queue. */
	protected AbstractQueue<State> _closedQueue;
	
	/**
	 * Instantiates a new BFS.
	 *
	 * @param openQueue the open queue
	 * @param closeQueue the close queue
	 */
	public BFS(AbstractQueue<State> openQueue, AbstractQueue<State> closeQueue) {
		_openQueue = openQueue;
		_closedQueue = closeQueue;
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#search(domains.Searchable)
	 */
	@Override
	public Solution search(Searchable s) {
		_openQueue.add(s.getStartState());
		
		while (!_openQueue.isEmpty()) {
			State state = _openQueue.poll();
			_closedQueue.add(state);
			
			if (state.equals(s.getGoalState())) 
				return backtrace(state);
			
			Map<Action, State> actions = s.getAllPossibleActions(state);
			for (Entry<Action, State> entry : actions.entrySet()) {
				Action action = entry.getKey();
				State successor = entry.getValue();
				
				if (!_openQueue.contains(successor) && !_closedQueue.contains(successor)) {
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + action.getCost());
					_openQueue.add(successor);
				} else if (state.getCost() + action.getCost() < successor.getCost()) {
					
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + action.getCost());
					
					// update priority in queue by removing and adding the state
					_openQueue.remove(successor);
					_openQueue.add(successor);					
				}
			}
		}
		
		return null; // won't reach this line never
	}
}
