package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * The Class Position.
 * represent a position on the 3D maze.
 */
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** The rows x. */
	public int x;
	
	/** The columns y. */
	public int y;
	
	/** The hight z. */
	public int z;

	/**
	 * Instantiates a new position.
	 *
	 * @param x the rows.
	 * @param y the columns.
	 * @param z the hight.
	 */
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position) obj;
		return x == pos.x && y == pos.y && z == pos.z;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
}
