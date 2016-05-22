package controller;

import model.Model;

public class ExitCommand implements Command {
	private Model _model;
	
	public ExitCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		_model.interrupt();
	}
}
