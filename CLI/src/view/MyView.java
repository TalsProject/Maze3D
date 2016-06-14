package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;


/**
 * The Class MyView.
 */
public class MyView extends Observable implements View, Observer {

	/** The in. */
	private final BufferedReader _in;
	
	/** The out. */
	private final Writer _out;
	
	/** The CLI. */
	private CLI _cli;
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param controller the controller
	 * @param in the BufferedReader
	 * @param out the Writer
	 */
	public MyView(BufferedReader in, Writer out) {		
		_in = in;
		_out = out;
		_cli = new CLI(in, out);
		_cli.addObserver(this);
	}
			
	/* (non-Javadoc)
	 * @see view.View#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		try {
			_out.write(message);
			_out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/* (non-Javadoc)
	 * @see view.View#start()
	 */
	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				_cli.start();
			}
			
		});	
		thread.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == _cli) {
			this.setChanged();
			this.notifyObservers(arg);			
		}		
	}
	
	@Override
	public void displayMaze(Maze3d maze) {
		try {
			_out.write(maze.toString());
			_out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void displaySolution(Maze3d maze, Solution solution) {
		displayMessage(solution.toString());
	}
}
