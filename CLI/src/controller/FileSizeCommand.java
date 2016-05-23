package controller;

import model.Model;


/**
 * The Class FileSizeCommand.
 */
public class FileSizeCommand implements Command {
	
	/** The model. */
	private Model _model;
	
	/**
	 * file size command.
	 *
	 * @param model the model
	 */
	public FileSizeCommand(Model model) {
		_model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String filePath = args[0];
		
		_model.fileSize(filePath);
	}
}
