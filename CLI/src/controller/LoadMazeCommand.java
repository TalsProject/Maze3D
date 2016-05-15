package controller;

import model.Model;

public class LoadMazeCommand implements Command {

	private Model _model;
	
	public LoadMazeCommand(Model model) {
		_model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String fileName = args[1];
		
		_model.loadMaze(fileName, name);
	}

}
