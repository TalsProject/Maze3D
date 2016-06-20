package presenter;

import model.Model;


/**
 * The Class ReadSolutionsCommand.
 */
public class ReadSolutionsCommand implements Command {
	/** The model. */
	private Model _model;
	
	/**
	 * Instantiates a new save maze command.
	 *
	 * @param model the model
	 */
	public ReadSolutionsCommand(Model model) {
		_model = model;
	}

	/* (non-Javadoc)
	 * @see presenter.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		_model.readSolutions();
	}
}
