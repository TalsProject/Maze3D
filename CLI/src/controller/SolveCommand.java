package controller;

import model.Model;


/**
 * The Class SolveCommand.
 */
public class SolveCommand implements Command {

	/** The model. */
	private Model _model;
	
	/**
	 * solve command.
	 *
	 * @param model the model
	 */
	public SolveCommand(Model model) {
		_model = model;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String algoritem = args[1];
		
		_model.solveMaze(name, algoritem);
	}
}
