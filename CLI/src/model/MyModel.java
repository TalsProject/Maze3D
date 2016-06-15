package model;

import java.beans.XMLDecoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.BFS;
import algorithms.search.BfsFactory;
import algorithms.search.DFS;
import algorithms.search.Solution;
import boot.Main;
import io.CompressorUtils;
import presenter.Properties;
import utils.FileUtil;


/**
 * The Class MyModel.
 */
public class MyModel extends Observable implements Model {
	
	/** The mazes. */
	private Map<String, Maze3d> _mazes = new HashMap<String, Maze3d>();
	
	/** The solutions. */
	private HashMap<Maze3d, Solution> _solutions = new HashMap<>();
	
	private String _message;

	private ExecutorService _executor;
	
	/**
	 * Instantiates a new my model.
	 *
	 * @param controller the controller
	 */
	public MyModel(int threadsNum) {
		_executor = Executors.newFixedThreadPool(threadsNum);
	}
	
	public String getMessage() {
		return _message;
	}

	/* (non-Javadoc)
	 * @see model.Model#generateMaze(java.lang.String, int, int, int)
	 */
	@Override
	public void generateMaze(String name, int rows, int cols, int hight) {
		_executor.submit(new Callable<Maze3d>() {
			@Override
			public Maze3d call() throws Exception {				
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(rows, cols, hight);
				_mazes.put(name, maze);
				
				displayMassage("Maze " + name + " is ready");
				return maze;				
			}	
			
		});
	}

	/* (non-Javadoc)
	 * @see model.Model#saveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void saveMaze(String name, String fileName) {
		_executor.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {				
				if (!_mazes.containsKey(name)) {
					displayMassage("Maze " + name + " does not exist\n");
					return false;
				}
				Maze3d maze = _mazes.get(name);

				try {
					CompressorUtils.writeToFile(fileName, maze);
					displayMassage("Maze " + name + " saved at " + fileName + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return false;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				return true;				
			}	
		});
	}

	/* (non-Javadoc)
	 * @see model.Model#loadMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void loadMaze(String fileName, String name) {
		_executor.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {				
				try {
					_mazes.put(name, CompressorUtils.readFromFile(fileName));
					displayMassage("Maze " + name + " loaded from " + fileName + "\n");
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				return true;				
			}	
		});
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
			displayMassage("Maze " + name + " does not exist\n");
			return;
		}

		ByteArrayOutputStream baos = FileUtil.objectToByteArrayOutputStream(_mazes.get(name));

		if (baos != null) {
			displayMassage(baos.toByteArray().length + " Bytes\n");
		}
	}

	/* (non-Javadoc)
	 * @see model.Model#fileSize(java.lang.String)
	 */
	@Override
	public void fileSize(String filePath) {
		File file = new File(filePath);
		
		if (file.isFile()) {
			displayMassage(String.valueOf(file.length()) + " Bytes\n");
		} else {
			displayMassage("The file " + filePath + " doesn't exists.\n");
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

		displayMassage(result.toString());
	}

	/* (non-Javadoc)
	 * @see model.Model#solveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void solveMaze(String name, String algoritem) {
		if (!_mazes.containsKey(name)) {
			displayMassage("Maze " + name + " does not exist\n");
			return;
		} else if (_solutions.containsKey(_mazes.get(name))) {
		} else {
			_executor.submit(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {				
					if (algoritem.equals("DFS")) {
						solveMazeDFS(name);
					} else if (algoritem.equals("BFS")) {
						solveMazeBFS(name);
					} else if (algoritem.equals("BestFS")) {
						solveMazeBestFS(name);
					} else {
						displayMassage("The algoritem " + algoritem + " does not exist\n");
					}
					
					setChanged();
					notifyObservers("save_solutions");
					return true;
				}	
			});
		}
	}
	
	@Override
	public Solution getSolution(String name) {
		Maze3d maze = _mazes.get(name);

		if (!_solutions.containsKey(maze)) {
			displayMassage("Solution for the maze " + name + " does not exist\n");
			return null;
		}
		
		return _solutions.get(maze);
	}
	
	@Override
	public Maze3d getMaze(String name) {
		if (_mazes.containsKey(name))
			return _mazes.get(name);
		else 
			return null;
	}
	
	@Override
	public void saveSolutions() {
		String fileSeperator = Main._osProperties.fileSeperator;
		
		File dir = new File("." + fileSeperator + "solutions");
		try {
			dir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileUtil.writeGZipCompressToFile(_solutions, "." + fileSeperator + "solutions" + fileSeperator + "solutions.zip");
	}
	
	@Override
	public void readSolutions() {
		String fileSeperator = Main._osProperties.fileSeperator;
		
		File dir = new File("." + fileSeperator + "solutions");
		try {
			dir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_solutions = FileUtil.readGZipCompressFromFile("." + fileSeperator + "solutions" + fileSeperator + "solutions.zip");
		
		if (_solutions == null) {
			_solutions = new HashMap();
		}
	}
	
	@Override
	public void reset(String name) {
		Maze3d maze = _mazes.get(name);
		maze.setStartPosition(maze.getStartPosition());
	}
	
	/**
	 * Solve maze dfs.
	 *
	 * @param name the name
	 */
	private void solveMazeDFS(String name) {
		Maze3d maze = _mazes.get(name);
		MazeAdapter adapter = new MazeAdapter(maze);

		DFS dfs = new DFS();
		Solution solution = dfs.search(adapter);
		_solutions.put(maze, solution);
		displayMassage("Solution for " + name + " is ready\n");
	}

	/**
	 * Solve maze breadthFS.
	 *
	 * @param name the name
	 */
	private void solveMazeBFS(String name) {
		Maze3d maze = _mazes.get(name);
		MazeAdapter adapter = new MazeAdapter(maze);

		BFS breadthFS = BfsFactory.getBreadthFS();
		Solution solution = breadthFS.search(adapter);
		_solutions.put(maze, solution);
		displayMassage("Solution for " + name + " is ready\n");
	}

	/**
	 * Solve maze bestFS.
	 *
	 * @param name the name of the maze
	 */
	private void solveMazeBestFS(String name) {
		Maze3d maze = _mazes.get(name);
		MazeAdapter adapter = new MazeAdapter(maze);

		BFS bestFS = BfsFactory.getBestFS();
		Solution solution = bestFS.search(adapter);
		_solutions.put(maze, solution);
		displayMassage("Solution for " + name + " is ready\n");
	}

	public void move(String name, Direction direction) {
		Maze3d maze = _mazes.get(name);
		if (maze.move(direction)) {
			setChanged();
			notifyObservers("display_maze " + name);
			
			if (maze.getPlayerPosition().equals(maze.getGoalPosition())) {
				displayMassage("CONGRATULATIONS!, you found the exit, you may cantinue play");
			}
		}
	}
	
	public void loadPropetties(String fileFullPath) {
		try (XMLDecoder myprop = new XMLDecoder(new FileInputStream(fileFullPath))) {
			Main._prop = (Properties) myprop.readObject();
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
	
	/* (non-Javadoc)
	 * @see model.Model#interrupt()
	 */
	@Override
	public boolean interrupt() {
		_executor.shutdown();
		displayMassage("Exit maze model\n");

		return true;
	}
	
	private void displayMassage(String msg) {
		_message = msg;
		setChanged();
		notifyObservers("display_message");
	}
}
