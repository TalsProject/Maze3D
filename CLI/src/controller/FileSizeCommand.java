package controller;

import model.Model;

public class FileSizeCommand implements Command {
	private Model _model;
	
	public FileSizeCommand(Model model) {
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String filePath = args[0];
		
		_model.fileSize(filePath);
	}
}
