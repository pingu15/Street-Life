package streetLife;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Street Life teaches users about homelessness, through a fun and interactive game
 * 
 * @author Max Sun, Zoe Fan-Chaing, Derek Ma
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
		stage.setTitle("Street Life");
		EscapeRoom esc = new EscapeRoom();
		esc.start(stage);
		Computer comp = new Computer();
		//comp.start(stage);
	}

}
