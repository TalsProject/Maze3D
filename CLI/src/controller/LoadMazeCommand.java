package controller;

import model.Model;


/**
 * The Class LoadMazeCommand.
 */
public class LoadMazeCommand implements Command {

	/** The _model. */
	private Model _model;
	
	/**
	 * load maze command.
	 *
	 * @param model the model
	 */
	public LoadMazeCommand(Model model) {
		_model = model;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String fileName = args[0];
		String name = args[1];
		
		_model.loadMaze(fileName, name);
	}
}
