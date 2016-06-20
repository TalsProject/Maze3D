package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import boot.Main;



/**
 * The Class MazeWindow.
 */
public class MazeWindow extends BasicWindow implements View {

	/** The maze display. */
	private MazeDisplay mazeDisplay;
	
	/** The x goal location. */
	private Label xGoalLocation;
	
	/** The y goal location. */
	private Label yGoalLocation;
	
	/** The z goal location. */
	private Label zGoalLocation;
	
	/** The x location. */
	private Label xLocation;
	
	/** The y location. */
	private Label yLocation;
	
	/** The z location. */
	private Label zLocation;
	
	/** The last move. */
	private Label lastMove;
	
	/** The moves oprions. */
	private Label movesOprions;

	/* (non-Javadoc)
	 * @see view.BasicWindow#initWidgets()
	 */
	@Override
	public void initWidgets() {
		String fileSeperator = Main._osProperties.fileSeperator;
		
		character = new Image(display, "." + fileSeperator + "resources" + fileSeperator + "images" + fileSeperator + "character.jpg");
		gate = new Image(display, "." + fileSeperator + "resources" + fileSeperator + "images" + fileSeperator + "gate.png");

		GridLayout gridLayout = new GridLayout(2, false);
		shell.setText("MAZE 3D");
		shell.setLayout(gridLayout);

		shell.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				exit();
			}
		});

		initMenu();

		Composite leftGroup = new Composite(shell, SWT.BORDER);
		leftGroup.setLayout(new FillLayout(SWT.VERTICAL));

		Composite buttonsGroup = new Composite(leftGroup, SWT.BORDER);
		buttonsGroup.setLayout(new FillLayout(SWT.TOP));

		Composite goalLocation = new Composite(leftGroup, SWT.BORDER);
		goalLocation.setLayout(new FillLayout(SWT.BUTTON1));

		Label destanetionLocation = new Label(goalLocation, SWT.PUSH);
		destanetionLocation.setText("Goal Location");

		xGoalLocation = new Label(goalLocation, SWT.PUSH);
		xGoalLocation.setText("X: -1");
		yGoalLocation = new Label(goalLocation, SWT.PUSH);
		yGoalLocation.setText("Y: -1");
		zGoalLocation = new Label(goalLocation, SWT.PUSH);
		zGoalLocation.setText("Z: -1");

		Composite playerLocation = new Composite(leftGroup, SWT.BORDER);
		playerLocation.setLayout(new FillLayout(SWT.BUTTON1));

		Label titlePlayerLocation = new Label(playerLocation, SWT.PUSH);
		titlePlayerLocation.setText("Player Location");

		xLocation = new Label(playerLocation, SWT.PUSH);
		xLocation.setText("X: -1");
		yLocation = new Label(playerLocation, SWT.PUSH);
		yLocation.setText("Y: -1");
		zLocation = new Label(playerLocation, SWT.PUSH);
		zLocation.setText("Z: -1");
		lastMove = new Label(playerLocation, SWT.PUSH);
		lastMove.setText("Last Move:");

		Composite movesOptionGroup = new Composite(leftGroup, SWT.BORDER);
		movesOptionGroup.setLayout(new FillLayout(SWT.BUTTON1));

		Label movesOprionsTitle = new Label(movesOptionGroup, SWT.PUSH);
		movesOprionsTitle.setText("Moves Options");

		movesOprions = new Label(movesOptionGroup, SWT.PUSH);
		movesOprions.setText("\n\n\n\n");

		Button btnGenerateMaze = new Button(buttonsGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");

		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int numberOfCells = Main._prop.getNumberOfCells();
				String commandLine = "generate_3d_maze aaa " + numberOfCells + " " + numberOfCells + " " + numberOfCells;
				setChanged();
				notifyObservers(commandLine);
			}
		});

		Button btnSolveMaze = new Button(buttonsGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");

		btnSolveMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String command = "solve aaa";
				setChanged();
				notifyObservers(command);

				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				command = "display_solution aaa";
				setChanged();
				notifyObservers(command);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		Button btnDisplayMaze = new Button(buttonsGroup, SWT.PUSH);
		btnDisplayMaze.setText("Display maze");

		btnDisplayMaze.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String command = "display_maze aaa";
				setChanged();
				notifyObservers(command);
				mazeDisplay.forceFocus();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		Button resetMaze = new Button(buttonsGroup, SWT.PUSH);
		resetMaze.setText("Reset maze");

		resetMaze.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String command = "reset_maze aaa";
				setChanged();
				notifyObservers(command);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		Button btnExit = new Button(buttonsGroup, SWT.PUSH);
		btnExit.setText("Exit");

		btnExit.addSelectionListener(new exitListener());

		mazeDisplay = new Maze2DDisplay(shell, SWT.BORDER);
		mazeDisplay.setGate(gate);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		mazeDisplay.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Direction direction = null;

				if (SWT.KEYPAD_8 == e.keyCode) {
					direction = Direction.FORWARD;
				} else if (SWT.KEYPAD_2 == e.keyCode) {
					direction = Direction.BACKWARD;
				} else if (SWT.KEYPAD_6 == e.keyCode) {
					direction = Direction.RIGHT;
				} else if (SWT.KEYPAD_4 == e.keyCode) {
					direction = Direction.LEFT;
				} else if (SWT.KEYPAD_5 == e.keyCode) {
					direction = Direction.UP;
					;
				} else if (SWT.KEYPAD_0 == e.keyCode) {
					direction = Direction.DOWN;
				}

				if (direction != null) {
					String command = "move aaa " + direction.toString();
					setChanged();
					notifyObservers(command);
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see view.View#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				MessageBox msg = new MessageBox(shell);
				msg.setMessage(message);
				msg.open();
			}
		});
	}

	/**
	 * Help message.
	 *
	 * @param title the title
	 * @param message the message
	 */
	public void helpMessage(String title, String message) {
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				MessageBox msg = new MessageBox(shell, SWT.ICON_QUESTION);
				msg.setText(title);
				msg.setMessage(message);
				msg.open();
			}
		});
	}

	/* (non-Javadoc)
	 * @see view.View#start()
	 */
	@Override
	public void start() {
		this.run();
	}

	/**
	 * The listener interface for receiving exit events.
	 * The class that is interested in processing a exit
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addexitListener<code> method. When
	 * the exit event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see exitEvent
	 */
	class exitListener implements SelectionListener {
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent event) {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent event) {
			exit();
		}
	}

	/* (non-Javadoc)
	 * @see view.View#displayMaze(algorithms.mazeGenerators.Maze3d)
	 */
	@Override
	public void displayMaze(Maze3d maze) {
		Position goalPos = maze.getGoalPosition();

		xGoalLocation.setText("X: " + goalPos.x);
		yGoalLocation.setText("Y: " + goalPos.y);
		zGoalLocation.setText("Z: " + goalPos.z);

		Position playerPos = maze.getPlayerPosition();
		xLocation.setText("X: " + playerPos.x);
		yLocation.setText("Y: " + playerPos.y);
		zLocation.setText("Z: " + playerPos.z);
		String lastMoveStr = "";
		if (maze.getLastMove() != null) {
			lastMoveStr = maze.getLastMove().toString();
		}
		lastMove.setText("Last Move: " + lastMoveStr);

		StringBuilder movesOptions = new StringBuilder();
		for (Direction direction : maze.getPossibleMoves(playerPos)) {
			movesOptions.append(direction.toString());
			movesOptions.append("\n");
		}

		movesOprions.setText(movesOptions.toString());

		mazeDisplay.setData(maze.getCrossSectionByZ(playerPos.z), playerPos, goalPos, character);
		mazeDisplay.redraw();
	}

	/* (non-Javadoc)
	 * @see view.View#displaySolution(algorithms.mazeGenerators.Maze3d, algorithms.search.Solution)
	 */
	@Override
	public void displaySolution(Maze3d maze, Solution solution) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < solution.getStates().size(); i++) {
					domains.State state = solution.getStates().get(i);
					Direction direction = Maze3d.getDirectionBetweenPositions(
							solution.getStates().get(i - 1).getPosition(), state.getPosition());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							String command = "move aaa " + direction;
							setChanged();
							notifyObservers(command);
						}
					});
				}
			}
		}).start();
	}

	/**
	 * Inits the menu.
	 */
	private void initMenu() {
		menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		MenuItem loadPropertiesItem = new MenuItem(fileMenu, SWT.PUSH);
		loadPropertiesItem.setText("&Open properties");

		loadPropertiesItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog dialog = new FileDialog(shell, SWT.OPEN);
				dialog.setFilterExtensions(new String[] { "*.xml" });
				String result = dialog.open();
				setChanged();
				notifyObservers("load_properties " + result);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("E&xit");

		MenuItem helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		helpMenuHeader.setText("&Help");

		Menu helpMenu = new Menu(shell, SWT.DROP_DOWN);
		helpMenuHeader.setMenu(helpMenu);

		MenuItem helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
		helpGetHelpItem.setText("&Help");

		fileExitItem.addSelectionListener(new exitListener());
		helpGetHelpItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				helpMessage("Help", "Use key board to play - numbers 0,2,4,5,6,8");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}
}
