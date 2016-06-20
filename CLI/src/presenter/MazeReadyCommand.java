package presenter;

import model.Model;
import view.View;


/**
 * The Class MazeReadyCommand.
 */
public class MazeReadyCommand implements Command {

	/** The view. */
	private View view;
	
	/** The model. */
	private Model model;
		
	/**
	 * Instantiates a new maze ready command.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public MazeReadyCommand(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	/* (non-Javadoc)
	 * @see presenter.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {		
		view.displayMessage(model.getMessage());
	}

}
