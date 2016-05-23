package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import controller.Command;


/**
 * The Class CLI.
 */
public class CLI {
	
	/** The in. */
	private final BufferedReader _in;
	
	/** The out. */
	private final Writer _out;
	
	/** The commands. */
	private final HashMap<String, Command> _commands;
	
	/**
	 * Instantiates a new CLI.
	 *
	 * @param in the in
	 * @param out the out
	 * @param commands the commands
	 */
	public CLI(BufferedReader in, Writer out, HashMap<String,Command> commands) {
		_in = in;
		_out = out;
		_commands = commands;
	}
	
	/**
	 * Start.
	 */
	public void start() {
		try {
			_out.write("Enter command: ");
			_out.flush();
			String line = _in.readLine();
			while (!(line.equals("exit"))) {
				
				String[] arr = line.split(" ");
				String str = "";
				int i = 0;					
				
				Command command = null;
				while (command == null && i < arr.length) {
					str += arr[i];
					command = _commands.get(str);
					str += " ";
					i++;
				}
				
				if (command == null) {
					_out.write("Command not found\n");
					_out.flush();							
				} else {
					
					String[] args = null;
					if (i < arr.length) {
						args = new String[arr.length - i];
						System.arraycopy(arr, i, args, 0, arr.length - i);
					}						
					
					command.doCommand(args);						
				}						
				
				_out.write("Enter command: ");
				_out.flush();
				line = _in.readLine();
			}
			
			_commands.get("exit").doCommand(null);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}						
	}
}

