package controller;

import model.Model;
import view.View;

public class GetCrossSectionByXCommand implements Command {
	private View _view;
	private Model _model;
	
	public GetCrossSectionByXCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		int index = Integer.valueOf(args[1]);
		
		_view.displayMessage(_model.getCrossSectionByX(name, index));
	}
}
