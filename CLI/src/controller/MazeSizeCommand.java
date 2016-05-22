package controller;

import model.Model;

public class MazeSizeCommand implements Command {
	private Model _model;
	
	public MazeSizeCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		_model.mazeSize(name);
	}
}
