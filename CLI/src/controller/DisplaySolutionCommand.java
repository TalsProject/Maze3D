package controller;

import model.Model;


/**
 * The Class DisplaySolutionCommand.
 */
public class DisplaySolutionCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/**
	 * display solution command.
	 *
	 * @param model the model
	 */
	public DisplaySolutionCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		_model.displaySolution(name);
	}
}
