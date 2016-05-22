package controller;

import model.Model;

public class LoadMazeCommand implements Command {

	private Model _model;
	
	public LoadMazeCommand(Model model) {
		_model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		String fileName = args[0];
		String name = args[1];
		
		_model.loadMaze(fileName, name);
	}
}
