package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;


/**
 * The Class MazeDisplay.
 */
public abstract class MazeDisplay extends Canvas {

	/**
	 * Draw maze.
	 *
	 * @param e the e
	 */
	protected abstract void drawMaze(PaintEvent e);
	
	/** The maze data. */
	protected int[][] mazeData;
	
	/** The playr pos. */
	protected Position playrPos;
	
	/** The goal position. */
	protected Position goalPosition;
	
	/** The character. */
	protected Image character;
	
	/** The gate. */
	protected Image gate;
	
	/**
	 * Sets the gate.
	 *
	 * @param gate the new gate
	 */
	public void setGate(Image gate) {
		this.gate = gate;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param mazeData the maze data
	 * @param playerPos the player pos
	 * @param goalPosition the goal position
	 * @param character the character
	 */
	public void setData(int[][] mazeData, Position playerPos, Position goalPosition, Image character) {
		this.mazeData = mazeData;
		this.playrPos = playerPos;
		this.goalPosition = goalPosition;
		this.character = character;
	}
	
	/**
	 * Instantiates a new maze display.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public MazeDisplay(Composite parent, int style) {
		super(parent, style);	
		
		this.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				drawMaze(e);				
			}
		});
	}
}
