package presenter;

import algorithms.mazeGenerators.Direction;
import model.Model;

public class MoveCommand implements Command {

	private Model model;
	
	public MoveCommand(Model model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		String direction = args[1];
		
		model.move(name, Direction.valueOf(direction));
	}
}
