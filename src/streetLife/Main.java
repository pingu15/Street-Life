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
	protected EscapeRoom esc;
	public static Stage stage = new Stage();;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		esc = new EscapeRoom(stage);
		stage.setTitle("Street Life");
		esc.start(stage);
		Computer comp = new Computer();
		//comp.start(stage);
	}

}
