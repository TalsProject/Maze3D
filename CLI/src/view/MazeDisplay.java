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
	protected Position pos;
	protected Image character;
	
	public void setData(int[][] mazeData, Position pos, Image character) {
		this.mazeData = mazeData;
		this.pos = pos;
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
