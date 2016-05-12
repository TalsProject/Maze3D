package domains;


/**
 * The Class Action.
 */
public class Action {
	
	/** The description of the action. */
	private String _description;
	
	/** The cost of the action. */
	private double _cost;
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return _description;
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
	 * Instantiates a new action.
	 *
	 * @param description the description of this action	
	 * @param cost the cost of this action
	 */
	public Action(String description, double cost) {		
		_description = description;
		_cost = cost;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return _description;
	}	
}
