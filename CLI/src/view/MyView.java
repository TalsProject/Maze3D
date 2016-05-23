package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import controller.Command;
import controller.Controller;


/**
 * The Class MyView.
 */
public class MyView implements View {

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
	public MyView(Controller controller, BufferedReader in, Writer out) {		
		_in = in;
		_out = out;
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

	/* (non-Javadoc)
	 * @see view.View#sendCommands(java.util.HashMap)
	 */
	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		_cli = new CLI(_in, _out, commands);
	}
}
