package algorithms.search;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class DFSTest {

	@Test
	public void testDfs() {
        int number;
        number = 20;
		MyMaze3dGenerator gen = new MyMaze3dGenerator();
		Maze3d maze = gen.generate(number, number, number);		
		MazeAdapter adapter = new MazeAdapter(maze);
		
		DFS dfs = new DFS();
		Solution solution = dfs.search(adapter);
		
		if (2<number & number<33){
		  assertTrue("Error, too high", number*number*number >= solution.getStates().size());
		  assertTrue("Error, too low", 1  <= solution.getStates().size());
		  assertTrue("Error, goal poind not equal to the dfs end point", adapter.getGoalState().equals(solution.getStates().get(solution.getStates().size()-1)));
		  
		  
		}else{
			assertTrue("Error, number enterd is too low less then 3 or too high more them 32 cannot generate maze more then 2^15",false);
		}
		
		
	}

}
