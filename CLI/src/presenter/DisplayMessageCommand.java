package presenter;

import model.Model;
import view.View;


/**
 * The Class DisplayMessageCommand.
 */
public class DisplayMessageCommand implements Command {

	/** The view. */
	private View view;
	
	/** The model. */
	private Model model;
	
	/**
	 * Instantiates a new display message command.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public DisplayMessageCommand(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	/* (non-Javadoc)
	 * @see presenter.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String msg = model.getMessage();
		view.displayMessage(msg);
	}

}
