package algorithms.search;

import domains.Searchable;


/**
 * The Interface Searcher.
 */
public interface Searcher {
	
	/**
	 * This function get a problem - (type of Searchable adapter) 
	 *and return the solution by using one of the searching algorithm.
	 *
	 * @param s the Searchable adapter problem to solve
	 * @return the solution
	 */
	Solution search(Searchable s);
}
