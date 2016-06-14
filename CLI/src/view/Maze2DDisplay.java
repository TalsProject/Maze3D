package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;

public class Maze2DDisplay extends MazeDisplay {

	public Maze2DDisplay(Composite parent, int style) {
		super(parent, style);		
		setBackground(new Color(null, 255, 255, 255));
	}

	@Override
	protected void drawMaze(PaintEvent e) {
		if (mazeData == null)
			return;
		
		e.gc.setForeground(new Color(null, 0, 0, 0));
		e.gc.setBackground(new Color(null, 0, 0, 0));

		int width = getSize().x;
		int height = getSize().y;

		int w = width / mazeData[0].length;
		int h = height / mazeData.length;

		for (int i = 0; i < mazeData.length; i++) {
			for (int j = 0; j < mazeData[i].length; j++) {
				if (mazeData[i][j] != Maze3d.FREE) {
					e.gc.fillRectangle(i * w, j * h, w, h);
				}
			}
		}
		
		e.gc.drawImage(character, 0, 0, 120, 84, playrPos.x * w, playrPos.y * h, w, h);
		
		if (playrPos.z == goalPosition.z) {
			e.gc.drawImage(gate, 0, 0, 512, 504, goalPosition.x * w, goalPosition.y * h, w, h);
		}
	}
}
