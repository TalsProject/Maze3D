package presenter;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;


/**
 * The Class DisplayCommand.
 */
public class DisplayMazeCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * Instantiates a new display command.
	 *
	 * @param model the model
	 */
	public DisplayMazeCommand(View view, Model model) {
		_model = model;
		_view = view;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("display command must contain 1 argument a maze name\n");
		} else {
			String name = args[0];
			Maze3d maze = _model.getMaze(name);
			
			if (maze == null) {
				_view.displayMessage("Please generate maze");
			} else {
				_view.displayMaze(_model.getMaze(name));
			}
		}
	}
}