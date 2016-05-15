package controller;

import model.Model;
import view.View;

public class MazeSizeCommand implements Command {
	private View _view;
	private Model _model;
	
	public MazeSizeCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		
		_view.displayMessage(_model.mazeSize(name));
	}
}
