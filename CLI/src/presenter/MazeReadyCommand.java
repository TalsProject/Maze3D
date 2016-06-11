package presenter;

import model.Model;
import view.View;

public class MazeReadyCommand implements Command {

	private View view;
	private Model model;
		
	public MazeReadyCommand(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] args) {		
		view.displayMessage(model.getMessage());
	}

}
