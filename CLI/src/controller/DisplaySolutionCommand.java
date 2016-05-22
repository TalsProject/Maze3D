package controller;

import model.Model;

public class DisplaySolutionCommand implements Command {
	private Model _model;
	
	public DisplaySolutionCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		_model.displaySolution(name);
	}
}
