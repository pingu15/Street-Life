package streetLife;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Street Life is a JavaFX Application that teaches users about homelessness through an interactive game.
 * 
 * @author Max Sun
 * @author Zoe Fan-Chiang
 * @author Derek Ma
 * @version 3.0
 * @since 2022-06-10
 */
public class Main extends Application {
	
	/**
	 * width of stage
	 */
	public static final int WIDTH = 960;
	
	/**
	 * height of stage
	 */
	public static final int HEIGHT = 540;
	
	/**
	 * primary stage
	 */
	public static Stage stage;

	/**
	 * Starts the program
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * Starts the application.
	 * 
	 * @param stage The primary stage on which the program runs
	 * @Override
	 */
	public void start(Stage stage) throws Exception {
		Functions.onLoad();
		Main.stage = stage;
		stage.setX(0);
		stage.setY(0);
		stage.getIcons().add(Functions.getImage("logo.png", 500, 500));
		stage.setResizable(false);
		stage.setTitle("Street Life");
		stage.show();
		SplashScreen s = new SplashScreen(stage, new MainMenu(stage));
		s.run();
	}

}
