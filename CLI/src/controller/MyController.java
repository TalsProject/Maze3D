package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {
	private Model model;
	private View view;
	private HashMap<String, Command> commands;
	
	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}

	@Override
	public void setModel(Model model) {
		this.model = model;		
	}

	@Override
	public void setView(View view) {		
		this.view = view;	
	}	
	
	public void generateCommands() {
		commands = new HashMap<String, Command>();
		commands.put("generate_maze_3d", new Generate3dMazeCommand(model));
		commands.put("save_maze", new SaveMazeCommand(model));
		commands.put("load_maze", new LoadMazeCommand(model));
		commands.put("dir", new DirCommand(view, model));
		commands.put("display", new DisplayCommand(model));
		commands.put("display_cross_section_by_x", new GetCrossSectionByXCommand(view, model));
		commands.put("display_cross_section_by_y", new GetCrossSectionByYCommand(view, model));
		commands.put("display_cross_section_by_z", new GetCrossSectionByZCommand(view, model));
		commands.put("maze_size", new MazeSizeCommand(model));
		commands.put("file_size", new FileSizeCommand(model));
		commands.put("solve", new SolveCommand(model));
		commands.put("display_solution", new DisplaySolutionCommand(model));
		commands.put("exit", new ExitCommand(model));
		view.sendCommands(commands);
	}
}
