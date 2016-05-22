package model;


public interface Model {
	public void generateMaze(String name, int rows, int cols, int hight);
	public void saveMaze(String name, String fileName);
	public void loadMaze(String fileName, String name);
	public String mazeToString(String name);
	public String getCrossSectionByX(String name, int index);
	public String getCrossSectionByY(String name, int index);
	public String getCrossSectionByZ(String name, int index);
	public void mazeSize(String name);
	public void fileSize(String filePath);
	public void printFilesWithinDirectory(String filePath);
	public void solveMaze(String name, String algoritem);
	public void displaySolution(String name);
	public boolean interrupt();
}
