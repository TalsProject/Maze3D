package controller;

import model.Model;
import view.View;


/**
 * The Interface Controller.
 */
public interface Controller {
	
	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	void setModel(Model model);
	
	/**
	 * Sets the view.
	 *
	 * @param view the new view
	 */
	void setView(View view);
	
	/**
	 * Display message.
	 *
	 * @param message the message
	 */
	void displayMessage(String message);	
	
	/**
	 * Generate commands.
	 */
	void generateCommands();
}
