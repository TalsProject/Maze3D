package controller;

import model.Model;


/**
 * The Class Generate3dMazeCommand.
 */
public class Generate3dMazeCommand implements Command {
	
	/** The model. */
	private Model model;
	
	/**
	 * generate3d maze command.
	 *
	 * @param model the model
	 */
	public Generate3dMazeCommand(Model model) {
		this.model = model;
	}	
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		int rows = Integer.parseInt(args[1]);
		int cols = Integer.parseInt(args[2]);
		int hight = Integer.parseInt(args[3]);
		
		model.generateMaze(name, rows, cols, hight);
	}

}
