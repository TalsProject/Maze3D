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
		commands.put("dir", new DirCommand(view));
		commands.put("display", new DisplayCommand(view, model));
		commands.put("getCrossSectionByX", new GetCrossSectionByXCommand(view, model));
		commands.put("getCrossSectionByY", new GetCrossSectionByYCommand(view, model));
		commands.put("getCrossSectionByZ", new GetCrossSectionByZCommand(view, model));
		commands.put("mazeSize", new MazeSizeCommand(view, model));
		commands.put("fileSize", new FileSizeCommand(view, model));
		view.sendCommands(commands);
	}
}
