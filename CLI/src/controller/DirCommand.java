package controller;

import model.Model;
import view.View;

public class DirCommand implements Command {
	private Model _model;
	private View _view;
	
	public DirCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		if (args == null || args.length != 1) {
			_view.displayMessage("Dir command must contain one argument\n");
			return;
		}
		String path = args[0];
		
		_model.printFilesWithinDirectory(path);
	}
}
