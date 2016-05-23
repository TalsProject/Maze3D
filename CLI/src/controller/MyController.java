package controller;

import java.util.HashMap;

import model.Model;
import view.View;


/**
 * The Class MyController.
 */
public class MyController implements Controller {
	
	/** The model. */
	private Model model;
	
	/** The view. */
	private View view;
	
	/** The commands. */
	private HashMap<String, Command> commands;
	
	/* (non-Javadoc)
	 * @see controller.Controller#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}

	/* (non-Javadoc)
	 * @see controller.Controller#setModel(model.Model)
	 */
	@Override
	public void setModel(Model model) {
		this.model = model;		
	}

	/* (non-Javadoc)
	 * @see controller.Controller#setView(view.View)
	 */
	@Override
	public void setView(View view) {		
		this.view = view;	
	}	
	
	/* (non-Javadoc)
	 * @see controller.Controller#generateCommands()
	 */
	public void generateCommands() {
		commands = new HashMap<String, Command>();
		commands.put("generate_3d_maze", new Generate3dMazeCommand(view, model));
		commands.put("save_maze", new SaveMazeCommand(model));
		commands.put("load_maze", new LoadMazeCommand(model));
		commands.put("dir", new DirCommand(view, model));
		commands.put("display", new DisplayCommand(model));
		commands.put("display_cross_section_by_x", new GetCrossSectionByXCommand(view, model));
		commands.put("display_cross_section_by_y", new GetCrossSectionByYCommand(view, model));
		commands.put("display_cross_section_by_z", new GetCrossSectionByZCommand(view, model));
		commands.put("maze_size", new MazeSizeCommand(model));
		commands.put("file_size", new FileSizeCommand(view, model));
		commands.put("solve", new SolveCommand(model));
		commands.put("display_solution", new DisplaySolutionCommand(model));
		commands.put("exit", new ExitCommand(model));
		view.sendCommands(commands);
	}
}
