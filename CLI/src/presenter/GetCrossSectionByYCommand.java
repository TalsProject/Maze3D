package presenter;

import model.Model;
import view.View;


/**
 * The Class GetCrossSectionByYCommand.
 */
public class GetCrossSectionByYCommand implements Command {
	
	/** The _view. */
	private View _view;
	
	/** The _model. */
	private Model _model;
	
	/**
	 * gets the cross section by y command.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public GetCrossSectionByYCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		int index = Integer.valueOf(args[0]);
		String name = args[1];
		
		_view.displayMessage(_model.getCrossSectionByY(name, index));
	}
}
