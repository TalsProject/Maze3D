package controller;

import model.Model;
import view.View;

public class FileSizeCommand implements Command {
	private View _view;
	private Model _model;
	
	public FileSizeCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String filePath = args[0];
		
		_view.displayMessage(_model.fileSizeInBytes(filePath) + " Bytes \n");
	}
}
