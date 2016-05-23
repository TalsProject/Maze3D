package controller;

import model.Model;


/**
 * The Class DisplayCommand.
 */
public class DisplayCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/**
	 * Instantiates a new display command.
	 *
	 * @param model the model
	 */
	public DisplayCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String path = args[0];
		
		_model.printFilesWithinDirectory(path);
	}
}