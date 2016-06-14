package presenter;

import model.Model;
import view.View;


/**
 * The Class DirCommand.
 */
public class LoadPropertiesCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/**
	 * Instantiates a new dir command.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public LoadPropertiesCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String fileFullPath = args[0];
		
		for (int i = 1; i < args.length; i++) {
			fileFullPath += " " + args[i];
		}
		
		_model.loadPropetties(fileFullPath);
	}
}
