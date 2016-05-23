package controller;

import model.Model;


/**
 * The Class SaveMazeCommand.
 */
public class SaveMazeCommand implements Command {

	/** The model. */
	private Model _model;
	
	/**
	 * Instantiates a new save maze command.
	 *
	 * @param model the model
	 */
	public SaveMazeCommand(Model model) {
		_model = model;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String fileName = args[1];
		
		_model.saveMaze(name, fileName);
	}
}
