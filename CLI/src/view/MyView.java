package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View {

	private final BufferedReader _in;
	private final Writer _out;
	private CLI _cli;

	
	public MyView(Controller controller, BufferedReader in, Writer out) {		
		_in = in;
		_out = out;
	}
			
	@Override
	public void displayMessage(String message) {
		try {
			_out.write(message);
			_out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

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
	public void sendCommands(HashMap<String, Command> commands) {
		_cli = new CLI(_in, _out, commands);
	}
}
