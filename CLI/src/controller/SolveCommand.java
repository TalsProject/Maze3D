package controller;

import model.Model;

public class SolveCommand implements Command {

	private Model _model;
	
	public SolveCommand(Model model) {
		_model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String algoritem = args[1];
		
		_model.solveMaze(name, algoritem);
	}
}
