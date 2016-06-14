package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;

public abstract class MazeDisplay extends Canvas {

	protected abstract void drawMaze(PaintEvent e);
	protected int[][] mazeData;
	protected Position playrPos;
	protected Position goalPosition;
	protected Image character;
	protected Image gate;
	
	public void setGate(Image gate) {
		this.gate = gate;
	}
	
	public void setData(int[][] mazeData, Position playerPos, Position goalPosition, Image character) {
		this.mazeData = mazeData;
		this.playrPos = playerPos;
		this.goalPosition = goalPosition;
		this.character = character;
	}
	
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
