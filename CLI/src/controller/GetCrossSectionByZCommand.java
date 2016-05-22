package controller;

import model.Model;
import view.View;

public class GetCrossSectionByZCommand implements Command {
	private View _view;
	private Model _model;
	
	public GetCrossSectionByZCommand(View view, Model model) {
		_view = view;
		_model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		int index = Integer.valueOf(args[0]);
		String name = args[1];
		
		_view.displayMessage(_model.getCrossSectionByZ(name, index));
	}
}
