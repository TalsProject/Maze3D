package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.BFS;
import algorithms.search.BfsFactory;
import algorithms.search.DFS;
import algorithms.search.Solution;




/**
 * Demo class.
 *
 * @author Tal 
 */

public class Demo {
	
	/**
	 * This method runs a demo.
	 */
	
	public void run() {
		
		MyMaze3dGenerator gen = new MyMaze3dGenerator();
		Maze3d maze = gen.generate(11, 11, 11);	
		System.out.println(maze);		
		MazeAdapter adapter = new MazeAdapter(maze);
		

		
		DFS dfs = new DFS();
		Solution solution = dfs.search(adapter);
		System.out.println("DFS size: " + solution.getStates().size());
		System.out.println(solution);
        
		
		
		BFS breadthFS = BfsFactory.getBreadthFS();
		Solution breadthFSsolution = breadthFS.search(adapter);
		System.out.println("Breadth FS size: " + breadthFSsolution.getStates().size());
		System.out.println(breadthFSsolution);
		
		
		
		BFS bestFS = BfsFactory.getBestFS();
		Solution bestFSsolution = bestFS.search(adapter);
		System.out.println("Best FS size: " + bestFSsolution.getStates().size());
		System.out.println(bestFSsolution);
	
	}
}
