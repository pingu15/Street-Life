package streetLife;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
	 * icons for chat and comp
	 */
	static ImageView chat, comp;
	
	/**
	 * starts the escape room
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		sp = new StackPane();
		bg = new Background(Functions.getBg("street.png"));
		sp.setBackground(bg);
		sp.setAlignment(Pos.TOP_LEFT);
		sc = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(sc, Color.BLACK);
		street = new Button();
		street.setVisible(false);
		street.setId("switchbutton");
		street.setText("Back");
		street.setPrefWidth(50);
		street.setPrefHeight(20);
		street.setTranslateX(50);
		street.setTranslateY(50);
		library = new Button();
		library.setPrefWidth(50);
		library.setPrefHeight(20);
		library.setVisible(true);
		library.setId("switchbutton");
		library.setText("Library");
		library.setTranslateX(50);
		library.setTranslateY(260);
		school = new Button();
		school.setPrefWidth(50);
		school.setPrefHeight(20);
		school.setVisible(true);
		school.setId("switchbutton");
		school.setText("School");
		school.setTranslateX(860);
		school.setTranslateY(260);
		sp.getChildren().addAll(school, library, street);
		chat = new ImageView(Functions.getImage("chat.png", 50, 50));
		comp = new ImageView(Functions.getImage("comp.png", 50, 50));
		chat.setTranslateX(400);
		chat.setTranslateY(450);
		comp.setTranslateX(510);
		comp.setTranslateY(450);
		sp.getChildren().addAll(chat, comp);
		but(library);
		but(school);
		but(street);
		but(chat);
		but(comp);
		cur = "street";
	}
	
	public static void open() throws IOException {
		if(cur.equals("library")) {
			bg = new Background(Functions.getBg("library.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(cur.equals("school")) {
			bg = new Background(Functions.getBg("school.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(cur.equals("street")) {
			bg = new Background(Functions.getBg("street.png"));
			sp.setBackground(bg);
			library.setVisible(true);
			school.setVisible(true);
			street.setVisible(false);
		}
		Functions.setScene(sc, Color.BLACK);
	}
	
	private static void but(Node b) {
		 b.setOnMousePressed((MouseEvent event) -> {
			try {
				handleMouse(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private static void handleMouse(MouseEvent e) throws IOException {
		if(e.getSource() == library) {
			bg = new Background(Functions.getBg("library.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == school) {
			bg = new Background(Functions.getBg("school.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == street) {
			bg = new Background(Functions.getBg("street.png"));
			sp.setBackground(bg);
			library.setVisible(true);
			school.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == chat) {
			openChat();
		}
		if(e.getSource() == comp) {
			Computer.open();
		}
	}
	
	private static void openChat() {
		
	}
	
}