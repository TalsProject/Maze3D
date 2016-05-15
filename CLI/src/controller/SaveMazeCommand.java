package controller;

import model.Model;

public class SaveMazeCommand implements Command {

	private Model _model;
	
	public SaveMazeCommand(Model model) {
		_model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String fileName = args[1];
		
		_model.saveMaze(name, fileName);
	}

}
