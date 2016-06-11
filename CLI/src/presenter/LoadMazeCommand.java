package presenter;

import model.Model;
import view.View;


/**
 * The Class LoadMazeCommand.
 */
public class LoadMazeCommand implements Command {

	/** The _model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * load maze command.
	 *
	 * @param model the model
	 */
	public LoadMazeCommand(View view, Model model) {
		_model = model;
		_view = view;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 2) {
			_view.displayMessage("load_maze command must contain 2 argument file path and a maze name\n");
			return;
		}
		String fileName = args[0];
		String name = args[1];
		
		_model.loadMaze(fileName, name);
	}
}
