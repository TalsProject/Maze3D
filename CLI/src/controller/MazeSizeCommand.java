package controller;

import model.Model;


/**
 * The Class MazeSizeCommand.
 */
public class MazeSizeCommand implements Command {
	
	/** The _model. */
	private Model _model;
	
	/**
	 * maze size command.
	 *
	 * @param model the model
	 */
	public MazeSizeCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		_model.mazeSize(name);
	}
}
