package controller;

import model.Model;

public class Generate3dMazeCommand implements Command {
	private Model model;
	public Generate3dMazeCommand(Model model) {
		this.model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		int rows = Integer.parseInt(args[1]);
		int cols = Integer.parseInt(args[2]);
		int hight = Integer.parseInt(args[3]);
		
		model.generateMaze(name, rows, cols, hight);
	}

}
