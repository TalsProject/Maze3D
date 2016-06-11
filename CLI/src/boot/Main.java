package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.MyModel;
import presenter.Presenter;
import view.MyView;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// CLI
		MyModel model = new MyModel();		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		MyView view = new MyView(in, out);
		
		Presenter presenter = new Presenter(model, view);
		view.addObserver(presenter);
		model.addObserver(presenter);
		
		view.start();
		
//		// SWT
//		MyModel model = new MyModel();		
//		MazeWindow view = new MazeWindow();
//		
//		Presenter presenter = new Presenter(model, view);
//		view.addObserver(presenter);
//		model.addObserver(presenter);
//		
//		view.start();	

	}

}
