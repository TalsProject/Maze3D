package presenter;

import algorithms.search.Solution;
import model.Model;
import view.View;


/**
 * The Class DisplaySolutionCommand.
 */
public class DisplaySolutionCommand implements Command {
	
	private View _view;
	private Model _model;
	
	/**
	 * display solution command.
	 *
	 * @param model the model
	 */
	public DisplaySolutionCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		Solution solution = _model.getSolution(name);
		
		if (solution != null) {
			_view.displaySolution(_model.getMaze(name), solution);
		}
	}
}
