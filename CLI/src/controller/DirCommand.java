package controller;

import model.Model;

public class DirCommand implements Command {
	private Model _model;
	
	public DirCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String path = args[0];
		
		_model.printFilesWithinDirectory(path);
	}
}
