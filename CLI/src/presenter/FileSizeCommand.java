package presenter;

import model.Model;
import view.View;


/**
 * The Class FileSizeCommand.
 */
public class FileSizeCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/** The view. */
	private View _view;
	
	/**
	 * file size command.
	 *
	 * @param model the model
	 */
	public FileSizeCommand(View view, Model model) {
		_model = model;
		_view = view;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("file_size command must contain a file path with no spaces argument\n");
			return;
		}
		String filePath = args[0];
		
		_model.fileSize(filePath);
	}
}
