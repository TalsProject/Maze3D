package presenter;

import model.Model;

public class SaveSolutionsCommand implements Command {
	/** The model. */
	private Model _model;
	
	/**
	 * Instantiates a new save maze command.
	 *
	 * @param model the model
	 */
	public SaveSolutionsCommand(Model model) {
		_model = model;
	}

	@Override
	public void doCommand(String[] args) {
		_model.saveSolutions();
	}
}
