package presenter;

import model.Model;

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

	@Override
	public void doCommand(String[] args) {
		_model.readSolutions();
	}
}
