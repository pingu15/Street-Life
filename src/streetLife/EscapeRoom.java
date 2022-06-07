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
	static Button alley, shelter, start, street;
	
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
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		sp = new StackPane();
		bg = new Background(Functions.getBg("start"));
		sp.setBackground(bg);
		sc = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(sc, Color.BLACK);
		alley = new Button();
		alley.setVisible(true);
		alley.setId("switchbutton");
		shelter = new Button();
		shelter.setVisible(true);
		shelter.setId("switchbutton");
		start = new Button();
		start.setVisible(false);
		start.setId("switchbutton");
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
		if(e.getSource() == alley) {
			sp.setBackground(new Background(Functions.getBg("alley")));
			alley.setVisible(false);
			shelter.setVisible(false);
			start.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == shelter) {
			sp.setBackground(new Background(Functions.getBg("shelter")));
			alley.setVisible(false);
			shelter.setVisible(false);
			start.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == start) {
			sp.setBackground(new Background(Functions.getBg("start")));
			alley.setVisible(true);
			shelter.setVisible(true);
			start.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == street) {
			sp.setBackground(new Background(Functions.getBg("street")));
			alley.setVisible(false);
			shelter.setVisible(false);
			start.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == sp) {
			Computer.open();
		}
	}
	
}