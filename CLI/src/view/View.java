package view;

import java.util.HashMap;

import controller.Command;


/**
 * The Interface View.
 */
public interface View {
	
	/**
	 * Display message.
	 *
	 * @param message the message
	 */
	void displayMessage(String message);
	
	/**
	 * Start.
	 */
	void start();
	
	/**
	 * Send commands.
	 *
	 * @param commands the commands
	 */
	void sendCommands(HashMap<String, Command> commands);
}
