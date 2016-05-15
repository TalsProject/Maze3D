package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;

public class CompressorUtils {
	public static void writeToFile(String fileFullPath, Maze3d maze) throws IOException {
		try (OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileFullPath))) {
			out.write(maze.toByteArray());
			out.flush();
		}
	}
	
	public static Maze3d readFromFile(String fileFullPath) throws IOException {
		try (MyDecompressorInputStream in = new MyDecompressorInputStream(new FileInputStream(fileFullPath))) {
			byte[] b = in.readToByeArray();
			return new Maze3d(b);
		}
	}
}
