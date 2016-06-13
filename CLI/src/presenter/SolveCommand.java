package presenter;

import boot.Main;
import model.Model;
import view.View;


/**
 * The Class SolveCommand.
 */
public class SolveCommand implements Command {

	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * solve command.
	 *
	 * @param model the model
	 */
	public SolveCommand(View view, Model model) {
		_model = model;
		_view = view;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("solve command must contain maze name \n");
			return;
		}
		String name = args[0];
		String algoritem = Main._prop.getAlgosolve();
		
		_model.solveMaze(name, algoritem);
	}
}
