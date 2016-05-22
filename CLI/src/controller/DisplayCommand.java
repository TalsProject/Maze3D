package controller;

import model.Model;

public class DisplayCommand implements Command {
	private Model _model;
	
	public DisplayCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String path = args[0];
		
		_model.printFilesWithinDirectory(path);
	}
}