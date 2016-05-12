package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import algorithms.mazeGenerators.Position;
import domains.State;


/**
 * The Class Utilities.
 */
public class Util {
	
	
	    /**
    	 * Prints 2d array.
    	 *
    	 * @param data the 2d array of data from the maze 3d
    	 */
    	//print for JavaWorkPartA main 
		public static void print(int[][] data) {
		int firstDimentionSize = data.length;
		int secondDimentionSize = data[0].length;
		
		for (int i = 0; i < firstDimentionSize; i++) {
			for (int j = 0; j < secondDimentionSize; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	/**
	 * Description of state to position.
	 * with regex usage.
	 * @param state 
	 * @return the position
	 */
	public static Position DescriptionToPosition(State state){
		String Description = state.getDescription();
		int x = -1,y = -1,z = -1;
		
		//^[(](\\d+),(\\d+),(\\d+)[)]$ - regex 
		
		Pattern p = Pattern.compile("^[(](\\d+),(\\d+),(\\d+)[)]$");
		Matcher m = p.matcher(Description);
		while (m.find()) {
			x = Integer.valueOf(m.group(1));
			y = Integer.valueOf(m.group(2));
			z = Integer.valueOf(m.group(3));
		}
		
	    Position pos = new Position(x,y,z);
	    
	    
		return  pos;
		
	}
	

	
}
