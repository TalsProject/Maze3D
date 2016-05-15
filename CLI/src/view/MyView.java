package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View {

	private BufferedReader in;
	private Writer out;
	private CLI cli;

	
	public MyView(Controller controller, BufferedReader in, Writer out) {		
		this.in = in;
		this.out = out;
	}
			
	@Override
	public void displayMessage(String message) {
		try {
			out.write(message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				cli.start();
			}
			
		});	
		thread.start();
	}

	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		cli = new CLI(in, out, commands);
	}
	
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
		
		displayMessage(result.toString());
	}
}
