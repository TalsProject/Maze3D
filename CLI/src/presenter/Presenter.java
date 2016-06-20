package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;


/**
 * The Class Presenter.
 */
public class Presenter implements Observer {
	
	/** The model. */
	private Model model;
	
	/** The view. */
	private View view;
	
	/** The view commands. */
	private HashMap<String, Command> viewCommands;
	
	/** The model commands. */
	private HashMap<String, Command> modelCommands;
	
	/**
	 * Instantiates a new presenter.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public Presenter(Model model, View view) {
		this.model = model;
		this.view = view;
		
		buildCommands();
	}
	
	/**
	 * Builds the commands.
	 */
	private void buildCommands() {
		viewCommands = new HashMap<String, Command>();
		viewCommands.put("generate_3d_maze", new Generate3dMazeCommand(view, model));
		viewCommands.put("save_maze", new SaveMazeCommand(view, model));
		viewCommands.put("load_maze", new LoadMazeCommand(view, model));
		viewCommands.put("dir", new DirCommand(view, model));
		viewCommands.put("display_maze", new DisplayMazeCommand(view, model));
		viewCommands.put("display_cross_section_by_x", new GetCrossSectionByXCommand(view, model));
		viewCommands.put("display_cross_section_by_y", new GetCrossSectionByYCommand(view, model));
		viewCommands.put("display_cross_section_by_z", new GetCrossSectionByZCommand(view, model));
		viewCommands.put("maze_size", new MazeSizeCommand(view, model));
		viewCommands.put("file_size", new FileSizeCommand(view, model));
		viewCommands.put("solve", new SolveCommand(view, model));
		viewCommands.put("display_solution", new DisplaySolutionCommand(view, model));
		viewCommands.put("read_solutions", new ReadSolutionsCommand(model));
		viewCommands.put("move", new MoveCommand(model));
		viewCommands.put("reset_maze", new ResetMazeCommand(view, model));
		viewCommands.put("load_properties", new LoadPropertiesCommand(model));
		viewCommands.put("exit", new ExitCommand(model));
		
		modelCommands = new HashMap<String, Command>();
		modelCommands.put("display_message", new DisplayMessageCommand(model, view));
		modelCommands.put("maze_ready", new MazeReadyCommand(view, model));
		modelCommands.put("save_solutions", new SaveSolutionsCommand(model));
		modelCommands.put("display_maze", new DisplayMazeCommand(view, model));

	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		String commandLine = (String)arg;
		String[] arr = commandLine.split(" ");
		String commandName = arr[0];
		String[] args = new String[arr.length - 1];
		System.arraycopy(arr, 1, args, 0, arr.length - 1);
		
		if (o == model) {
			Command command = modelCommands.get(commandName);
			command.doCommand(args);
		} else if (o == view) {
			Command command = viewCommands.get(commandName);
			command.doCommand(args);
		}
	}

}
