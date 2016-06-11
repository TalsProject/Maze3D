package presenter;

import model.Model;
import view.View;


/**
 * The Class SaveMazeCommand.
 */
public class SaveMazeCommand implements Command {

	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * Instantiates a new save maze command.
	 *
	 * @param model the model
	 */
	public SaveMazeCommand(View view, Model model) {
		
		_model = model;
		_view = view;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 2) {
			_view.displayMessage("save_maze command must contain 2 argument a maze name and a file path with no spaces \n");
			return;
		}
		String name = args[0];
		String fileName = args[1];
		
		_model.saveMaze(name, fileName);
	}
}
