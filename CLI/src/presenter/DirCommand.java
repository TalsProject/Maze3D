package presenter;

import model.Model;
import view.View;


/**
 * The Class DirCommand.
 */
public class DirCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * Instantiates a new dir command.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public DirCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("Dir command must contain one argument\n");
			return;
		}
		String path = args[0];
		
		_model.printFilesWithinDirectory(path);
	}
}
