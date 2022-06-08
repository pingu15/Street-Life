package streetLife;

import javafx.application.Application;
import javafx.scene.image.Image;
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
	public static Stage stage = new Stage();
	SplashScreen splashScreen;
	MainMenu mainMenu;

	public static void main(String[] args) throws InterruptedException {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Street Life");
		esc = new EscapeRoom(stage);
		mainMenu = new MainMenu(stage);
		splashScreen = new SplashScreen(stage, mainMenu);
		Image logo = new Image("Scenes/isp_logo_nobg.png");
		stage.getIcons().add(logo);
		stage.setTitle("Escape Room");
		stage.setX(10);
		stage.setY(10);
		stage.show();
		esc.start();

		//Computer comp = new Computer();
		//comp.start(stage);
	}

}
