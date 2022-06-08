package streetLife;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class EscapeRoom {
	
	/**
	 * Button for switching backgrounds
	 */
	static Button school, library, street;
	
	/**
	 * the background image
	 */
	static Background bg;
	
	/**
	 * the scene for the escape room
	 */
	static Scene sc;
	
	/**
	 * layer for scene formatting
	 */
	static StackPane sp;
	
	/**
	 * the current location
	 */
	static String cur;
	
	/**
	 * starts the escape room
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		sp = new StackPane();
		bg = new Background(Functions.getBg("library"));
		sp.setBackground(bg);
		sc = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(sc, Color.BLACK);
		street = new Button();
		street.setVisible(true);
		street.setId("switchbutton");
		sp.setOnMousePressed((MouseEvent event) -> {
			try {
				handleMouse(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void open() {
		
	}
	
	private static void handleMouse(MouseEvent e) throws IOException {
		
	}
	
}