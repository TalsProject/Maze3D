package run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.demo.Demo;
import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;


/**
 * The Class Run.
 */
public class Run {
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//JavaWorkPartB main 
		//Demo demo = new Demo();
		//demo.run();
		MyMaze3dGenerator gen = new MyMaze3dGenerator();
		Maze3d maze = gen.generate(11, 11, 11);	


		
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(
		new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		System.out.println(loaded.equals(maze));
		

	}
	
	
	
}