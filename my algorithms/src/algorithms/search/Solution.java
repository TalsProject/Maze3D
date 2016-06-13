package algorithms.search;

import java.io.Serializable;
import java.util.List;

import domains.State;


/**
 * The Class Solution.
 */
public class Solution implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The states. */
	private List<State> _states;

	/**
	 * Gets the states.
	 *
	 * @return the states
	 */
	public List<State> getStates() {
		return _states;
	}

	/**
	 * Sets the states.
	 *
	 * @param states the new states
	 */
	public void setStates(List<State> states) {
		_states = states;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		for (State s: _states) {
			sb.append(s).append("\n");
			
			if(_states.size()-1!=index){
			sb.append("next move: ").append("\n");
			index ++;
			}
			
		}
		return sb.toString();
	}
}
