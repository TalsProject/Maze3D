package controller;

import model.Model;
import view.View;


/**
 * The Class DisplayCommand.
 */
public class DisplayCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * Instantiates a new display command.
	 *
	 * @param model the model
	 */
	public DisplayCommand(View view, Model model) {
		_model = model;
		_view = view;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		if (args == null || args.length != 1)
			_view.displayMessage("display command must contain 1 argument a maze name\n");
		else
			_view.displayMessage(_model.mazeToString(name));
	}
}