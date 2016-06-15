package boot;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import env.OsFactory;
import env.OsProperties;
import model.MyModel;
import presenter.Presenter;
import presenter.Properties;
import view.MazeWindow;
import view.MyView;

/**
 * The Class Main.
 */
public class Main {

	public static Properties _prop = new Properties("DFS", "GUI", 20, 10);
	public static OsProperties _osProperties;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String os = System.getProperty("os");
		if (os == null) {
			System.out.println("Missing envairument parameter called os, Options: Windows or Linux");
			return;
		}
		_osProperties = OsFactory.getEnv(os);
		
		try (XMLDecoder myprop = new XMLDecoder(new FileInputStream("." + _osProperties.fileSeperator + "resources" + _osProperties.fileSeperator + "properties.xml"))) {
			_prop = (Properties) myprop.readObject();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		MyModel model = new MyModel(_prop.getThreadNum());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		if(_prop.getUitype().equals("CLI")) {
			MyView view = new MyView(in,out);
			Presenter presenter = new Presenter(model, view);
			model.addObserver(presenter);
			view.addObserver(presenter);
			view.start();	
		} else {
			MazeWindow view = new MazeWindow();
			
			Presenter presenter = new Presenter(model, view);
			view.addObserver(presenter);
			model.addObserver(presenter);
			
			view.start();
		}
	}
}
