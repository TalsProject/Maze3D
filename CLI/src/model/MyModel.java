package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.BFS;
import algorithms.search.BfsFactory;
import algorithms.search.DFS;
import algorithms.search.Solution;
import controller.Controller;
import io.CompressorUtils;


/**
 * The Class MyModel.
 */
public class MyModel implements Model {
	
	/** The controller. */
	private Controller _controller;
	
	/** The threads. */
	private List<Thread> _threads = new ArrayList<Thread>();
	
	/** The mazes. */
	private Map<String, Maze3d> _mazes = new HashMap<String, Maze3d>();
	
	/** The solutions. */
	private Map<String, Solution> _solutions = new HashMap<>();

	/**
	 * Instantiates a new my model.
	 *
	 * @param controller the controller
	 */
	public MyModel(Controller controller) {
		this._controller = controller;
	}

	/* (non-Javadoc)
	 * @see model.Model#generateMaze(java.lang.String, int, int, int)
	 */
	@Override
	public void generateMaze(String name, int rows, int cols, int hight) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(rows, cols, hight);
				_mazes.put(name, maze);
				_controller.displayMessage("Maze " + name + " is ready\n");
				_threads.remove(Thread.currentThread());
			}
		});
		_threads.add(thread);
		thread.start();
	}

	/* (non-Javadoc)
	 * @see model.Model#saveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void saveMaze(String name, String fileName) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				if (!_mazes.containsKey(name)) {
					_controller.displayMessage("Maze " + name + " does not exist\n");
					return;
				}
				Maze3d maze = _mazes.get(name);

				try {
					CompressorUtils.writeToFile(fileName, maze);
					_controller.displayMessage("Maze " + name + " saved at " + fileName + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				_threads.remove(Thread.currentThread());
			}
		});
		_threads.add(thread);
		thread.start();
	}

	/* (non-Javadoc)
	 * @see model.Model#loadMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void loadMaze(String fileName, String name) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					_mazes.put(name, CompressorUtils.readFromFile(fileName));
					_controller.displayMessage("Maze " + name + " loaded from " + fileName + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				_threads.remove(Thread.currentThread());
			}
		});
		_threads.add(thread);
		thread.start();
	}

	/* (non-Javadoc)
	 * @see model.Model#mazeToString(java.lang.String)
	 */
	@Override
	public String mazeToString(String name) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}

		return _mazes.get(name).toString();
	}

	/* (non-Javadoc)
	 * @see model.Model#getCrossSectionByX(java.lang.String, int)
	 */
	@Override
	public String getCrossSectionByX(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}

		return intArrayToString(_mazes.get(name).getCrossSectionByX(index));
	}

	/* (non-Javadoc)
	 * @see model.Model#getCrossSectionByY(java.lang.String, int)
	 */
	@Override
	public String getCrossSectionByY(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}

		return intArrayToString(_mazes.get(name).getCrossSectionByY(index));
	}

	/* (non-Javadoc)
	 * @see model.Model#getCrossSectionByZ(java.lang.String, int)
	 */
	@Override
	public String getCrossSectionByZ(String name, int index) {
		if (!_mazes.containsKey(name)) {
			return "Maze " + name + " does not exist\n";
		}

		return intArrayToString(_mazes.get(name).getCrossSectionByZ(index));
	}

	/**
	 * Int array to string.
	 *
	 * @param arr the array
	 * @return the string
	 */
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

	/* (non-Javadoc)
	 * @see model.Model#mazeSize(java.lang.String)
	 */
	@Override
	public void mazeSize(String name) {
		if (!_mazes.containsKey(name)) {
			_controller.displayMessage("Maze " + name + " does not exist\n");
			return;
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(_mazes.get(name));
			_controller.displayMessage(baos.toByteArray().length + " Bytes\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.Model#fileSize(java.lang.String)
	 */
	@Override
	public void fileSize(String filePath) {
		File file = new File(filePath);
		
		if (file.isFile()) {
			_controller.displayMessage(String.valueOf(file.length()) + " Bytes\n");
		} else {
			_controller.displayMessage("The file " + filePath + " doesn't exists.\n");
		}
	}

	/* (non-Javadoc)
	 * @see model.Model#printFilesWithinDirectory(java.lang.String)
	 */
	@Override
	public void printFilesWithinDirectory(String path) {
		File file = new File(path);
		StringBuilder result = new StringBuilder();

		if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File f : files) {
				if (f.isFile()) {
					result.append(f.getName());
					result.append("\n");
				}
			}
		}

		if (result.length() == 0) {
			result.append("The File Isn't exists or directory");
		}

		_controller.displayMessage(result.toString());
	}

	/* (non-Javadoc)
	 * @see model.Model#solveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void solveMaze(String name, String algoritem) {
		if (!_mazes.containsKey(name)) {
			_controller.displayMessage("Maze " + name + " does not exist\n");
			return;
		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				if (algoritem.equals("DFS")) {
					solveMazeDFS(name);
				} else if (algoritem.equals("BFS")) {
					solveMazeBFS(name);
				} else if (algoritem.equals("BestFS")) {
					solveMazeBestFS(name);
				} else {
					_controller.displayMessage("The algoritem " + algoritem + " does not exist\n");
				}
				_threads.remove(Thread.currentThread());
			}
		});
		_threads.add(thread);
		thread.start();
	}

	/* (non-Javadoc)
	 * @see model.Model#displaySolution(java.lang.String)
	 */
	@Override
	public void displaySolution(String name) {
		if (!_solutions.containsKey(name)) {
			_controller.displayMessage("Solution for the maze " + name + " does not exist\n");
			return;
		}
		
		_controller.displayMessage(_solutions.get(name).toString());
	}
	
	/**
	 * Solve maze dfs.
	 *
	 * @param name the name
	 */
	private void solveMazeDFS(String name) {
		MazeAdapter adapter = new MazeAdapter(_mazes.get(name));

		DFS dfs = new DFS();
		Solution solution = dfs.search(adapter);
		_solutions.put(name, solution);
		_controller.displayMessage("Solution for " + name + " is ready\n");
	}

	/**
	 * Solve maze breadthFS.
	 *
	 * @param name the name
	 */
	private void solveMazeBFS(String name) {
		MazeAdapter adapter = new MazeAdapter(_mazes.get(name));

		BFS breadthFS = BfsFactory.getBreadthFS();
		Solution solution = breadthFS.search(adapter);
		_solutions.put(name, solution);
		_controller.displayMessage("Solution for " + name + " is ready\n");
	}

	/**
	 * Solve maze bestFS.
	 *
	 * @param name the name of the maze
	 */
	private void solveMazeBestFS(String name) {
		MazeAdapter adapter = new MazeAdapter(_mazes.get(name));

		BFS bestFS = BfsFactory.getBestFS();
		Solution solution = bestFS.search(adapter);
		_solutions.put(name, solution);
		_controller.displayMessage("Solution for " + name + " is ready\n");
	}

	/* (non-Javadoc)
	 * @see model.Model#interrupt()
	 */
	@Override
	public boolean interrupt() {
		for (Thread thread : _threads) {
			while (thread.isAlive()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					thread.interrupt();
				}
			}
		}
		
		_controller.displayMessage("Exit maze model\n");

		return true;
	}
	

}
