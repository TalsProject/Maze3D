package view;

import java.util.Observable;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public abstract class BasicWindow extends Observable implements Runnable {
	protected Display display;
	protected Shell shell;
	protected Image character;
	protected Image gate;
	protected Menu menuBar;

	public BasicWindow() {
		display = new Display();
		shell = new Shell(display);
	}

	public abstract void initWidgets();

	@Override
	public void run() {
		initWidgets();

		shell.setMenuBar(menuBar);
		shell.open();

		// main event loop
		while (!shell.isDisposed()) { // window isn't closed
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public void exit() {
		shell.dispose();
		System.exit(0);
	}
}
