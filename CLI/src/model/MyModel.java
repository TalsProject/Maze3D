package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;
import io.CompressorUtils;
import model.utils.ObjectSizeFetcher;



public class MyModel implements Model {
	private Controller _controller;
	private ArrayList<Thread> _threads = new ArrayList<Thread>();
	private HashMap<String, Maze3d> _mazes = new HashMap<String, Maze3d>();
	
	
	public MyModel(Controller controller)
	{
		this._controller = controller;
	}
	
	@Override
	public void generateMaze(String name, int rows, int cols, int hight) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {				
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(rows, cols, hight);
				_mazes.put(name, maze);
				_controller.displayMessage("Maze " + name + " is ready");				
			}				
		});
		thread.start();	
		_threads.add(thread);
	}

	@Override
	public void saveMaze(String name, String fileName) {
		if (!_mazes.containsKey(name)) {
			_controller.displayMessage("Maze " + name + " does not exist\n");
			return;
		}
		Maze3d maze = _mazes.get(name);
		
		try {
			CompressorUtils.writeToFile(fileName, maze);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadMaze(String fileName, String name) {
		try {
			_mazes.put(name, CompressorUtils.readFromFile(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String mazeToString(String name) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}
		
		return _mazes.get(name).toString();
	}

	@Override
	public String getCrossSectionByX(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}
		
		return intArrayToString(_mazes.get(name).getCrossSectionByX(index));
	}

	@Override
	public String getCrossSectionByY(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}
		
		return intArrayToString(_mazes.get(name).getCrossSectionByX(index));
	}

	@Override
	public String getCrossSectionByZ(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}
		
		return intArrayToString(_mazes.get(name).getCrossSectionByX(index));
	}
	
	public static String intArrayToString(int[][] arr) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				result.append(arr[i][j]);
				result.append(" ");
			}
			result.append("\n");
		}
		
		return result.toString();
	}

	@Override
	public String mazeSize(String name) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}
		
		return String.valueOf(ObjectSizeFetcher.getObjectSize(_mazes.get(name)));
	}

	@Override
	public String fileSizeInBytes(String filePath) {
		File file = new File(filePath);
		return String.valueOf(file.length());
	}
}
