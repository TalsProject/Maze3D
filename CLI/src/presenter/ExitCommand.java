package presenter;

import model.Model;


/**
 * The Class ExitCommand.
 */
public class ExitCommand implements Command {
	
	/** The _model. */
	private Model _model;
	
	/**
	 * new exit command.
	 *
	 * @param model the model
	 */
	public ExitCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		_model.interrupt();
	}
}
