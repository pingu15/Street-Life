package streetLife;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Street Life teaches users about homelessness, through a fun and interactive game
 * 
 * @author Max Sun, Zoe Fan-Chiang, Derek Ma
 * @version 1.0
 * @since 2022-05-20
 */
public class Main extends Application {
	
	public static final int WIDTH = 960, HEIGHT = 540;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Functions.onLoad();
		stage.setTitle("Street Life");
		Intro intro = new Intro(stage);
		intro.start();
		Computer comp = new Computer(stage);
		comp.start();
		//EscapeRoom escape = new EscapeRoom(stage);
		//escape.start();
	}

}
