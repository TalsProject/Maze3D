package presenter;

import model.Model;
import view.View;


/**
 * The Class Generate3dMazeCommand.
 */
public class Generate3dMazeCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * generate3d maze command.
	 *
	 * @param model the model
	 */
	public Generate3dMazeCommand(View view, Model model) {
		_model = model;
		_view = view;
	}
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 4) {
			_view.displayMessage("generate_3d_maze command must contain 4 argument\n");
			return;
		}
		String name = args[0];
		int rows = Integer.parseInt(args[1]);
		int cols = Integer.parseInt(args[2]);
		int hight = Integer.parseInt(args[3]);
		
		_model.generateMaze(name, rows, cols, hight);
	}

}
