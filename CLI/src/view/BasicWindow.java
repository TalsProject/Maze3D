package view;

import java.util.Observable;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;


/**
 * The Class BasicWindow.
 */
public abstract class BasicWindow extends Observable implements Runnable {
	
	/** The display. */
	protected Display display;
	
	/** The shell. */
	protected Shell shell;
	
	/** The character. */
	protected Image character;
	
	/** The gate. */
	protected Image gate;
	
	/** The menu bar. */
	protected Menu menuBar;

	/**
	 * Instantiates a new basic window.
	 */
	public BasicWindow() {
		display = new Display();
		shell = new Shell(display);
	}

	/**
	 * Inits the widgets.
	 */
	public abstract void initWidgets();

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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
	
	/**
	 * Exit.
	 */
	public void exit() {
		shell.dispose();
		System.exit(0);
	}
}
