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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class MazeWindow extends BasicWindow implements View {

	private MazeDisplay mazeDisplay;
	
	@Override
	public void initWidgets() {
		character = new Image(display, ".\\images\\character.jpg");
		
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);
				
		shell.addListener(SWT.Close, new Listener() {
	        public void handleEvent(Event event) {
	        	exit();
	        }
	    });

		Composite buttonsGroup = new Composite(shell, SWT.BORDER);
		buttonsGroup.setLayout(new FillLayout(SWT.VERTICAL));
		//buttonsGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
		
		Button btnGenerateMaze = new Button(buttonsGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
							
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String commandLine = "generate_3d_maze aaa 10 10 10";
				setChanged();
				notifyObservers(commandLine);				
			}				
		});
				
		Button btnSolveMaze = new Button(buttonsGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");
		
		Button btnDisplayMaze = new Button(buttonsGroup, SWT.PUSH);
		btnDisplayMaze.setText("Display maze");
		
		btnDisplayMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String command = "display_maze aaa";
				setChanged();
				notifyObservers(command);				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button btnExit = new Button(buttonsGroup, SWT.PUSH);
		btnExit.setText("Exit");
		
		btnExit.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				exit();			
			}				
		});
		
		mazeDisplay = new Maze2DDisplay(shell, SWT.BORDER);
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
					direction = Direction.UP;;
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

	@Override
	public void start() {
		this.run();		
	}

	@Override
	public void displayMaze(Maze3d maze) {
		Position pos = maze.getPlayerPosition();
		mazeDisplay.setData(maze.getCrossSectionByZ(pos.z), pos, character);
		mazeDisplay.redraw();
	}
}
