package algorithms.mazeGenerators;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


/**
 * The Class BaseMaze3dGenerator.
 */
public abstract class BaseMaze3dGenerator implements Maze3dGenerator  {

	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#measureAlgorithmTime(int, int, int)
	 */
	public String measureAlgorithmTime(int rows, int cols, int hight){
	    long startTime = System.currentTimeMillis();
	    generate(rows, cols, hight);
	    long endTime = System.currentTimeMillis();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date resultdate = new Date(endTime-startTime);
	    
	    return sdf.format(resultdate);
	}
}
