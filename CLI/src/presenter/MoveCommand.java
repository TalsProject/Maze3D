package presenter;

import algorithms.mazeGenerators.Direction;
import model.Model;


/**
 * The Class MoveCommand.
 */
public class MoveCommand implements Command {

	/** The model. */
	private Model model;
	
	/**
	 * Instantiates a new move command.
	 *
	 * @param model the model
	 */
	public MoveCommand(Model model) {
		this.model = model;
	}
	
	/* (non-Javadoc)
	 * @see presenter.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String direction = args[1];
		
		model.move(name, Direction.valueOf(direction));
	}
}
