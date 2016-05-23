package controller;

import model.Model;
import view.View;


/**
 * The Class MazeSizeCommand.
 */
public class MazeSizeCommand implements Command {
	
	/** The _model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * maze size command.
	 *
	 * @param model the model
	 */
	public MazeSizeCommand(View view, Model model) {
		_model = model;
		_view = view;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("maze_size command must contain 1 argument a maze name\n");
			return;
		}
		String name = args[0];
		
		_model.mazeSize(name);
	}
}
