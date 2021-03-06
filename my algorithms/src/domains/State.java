package domains;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import algorithms.mazeGenerators.Position;

/**
 * The Class State.
 */
public class State implements Comparable<State>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The description. */
	private String _description;
	
	/** The cost. */
	private double _cost;
	
	/** The state that this state came from. */
	private State _cameFrom;
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return _description;
	}
	
	public Position getPosition() {
		String pattern = "^\\((\\d+),(\\d+),(\\d+)\\)$";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(_description);
		if (m.find()) {
			return new Position(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
		}
		
		return null;
	}
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		_description = description;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return _cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		_cost = cost;
	}
	
	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State getCameFrom() {
		return _cameFrom;
	}
	
	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State cameFrom) {
		_cameFrom = cameFrom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State s) {
		double compare = _cost - s._cost;
		
		if (compare > 0) {
			return (int) Math.ceil(compare);
		}
		
		return (int) Math.floor(compare);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return _description.equals(((State)arg0)._description);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return _description.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return _description;
	}
}
