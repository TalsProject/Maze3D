package controller;

import view.View;

public class DirCommand implements Command {
	private View _view;
	
	public DirCommand(View view) {
		_view = view;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String path = args[0];
		
		_view.printFilesWithinDirectory(path);
	}
}
