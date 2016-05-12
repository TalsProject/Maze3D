package algorithms.search;

import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

import domains.State;


/**
 * A factory for creating BFS objects.
 */
public class BfsFactory {
	
	/**
	 * Factory function of the Best FS.
	 *call BFS with PriorityQueue.
	 *
	 * @return the best FS.
	 */
	public static BFS getBestFS() {
		return new BFS(new PriorityQueue<State>(), new PriorityQueue<State>());
	}
	
	/**
	 * Factory function of the Breadth FS.
	 * call BFS with LinkedBlockingQueue.
	 *
	 * @return the breadth FS.
	 */
	public static BFS getBreadthFS() {
		return new BFS(new LinkedBlockingQueue<State>(), new LinkedBlockingQueue<State>());
	}
}
