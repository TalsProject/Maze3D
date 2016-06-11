package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Observable;

import presenter.Command;


/**
 * The Class CLI.
 */
public class CLI extends Observable {
	
	/** The in. */
	private final BufferedReader _in;
	
	/** The out. */
	private final Writer _out;
	
	/**
	 * Instantiates a new CLI.
	 *
	 * @param in the in
	 * @param out the out
	 * @param commands the commands
	 */
	public CLI(BufferedReader in, Writer out) {
		_in = in;
		_out = out;
	}
	
	/**
	 * Start.
	 */
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				 
				try {					
					String line = null;
					do {
						_out.write("Enter command: ");
						_out.flush();
						line = _in.readLine();
						setChanged();
						notifyObservers(line);						
					} while (!(line.equals("exit")));					 
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}						
			}
			
		});
		thread.start();
	}
}

