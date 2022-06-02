package streetLife;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Functions {
	
	/**
	 * map of font keys to font names
	 */
	private static HashMap<String, String> fonts;
	
	/**
	 * map of error keys to errors
	 */
	private static HashMap<String, String> errors;
	
	/**
	 * displays an image
	 * 
	 * @param img the file name of the image to display
	 * @throws IOException
	 */
	public static void openImage(String img, int x, int y, int w, int h, String id) throws IOException {
		ImageView iv = new ImageView();
		InputStream in = new FileInputStream("computer\\"+img);
		Image image = new Image(in);
		iv.setImage(image);
		iv.setFitHeight(Main.HEIGHT);
		iv.setPreserveRatio(true);
		Group g = new Group();
		g.getChildren().add(iv);
		addBack(g, x, y, w, h, id);
		Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(sc, Color.BLACK);
	}
	
	/**
	 * commands to run on load of the game
	 * 
	 * @throws IOException
	 */
	public static void onLoad() throws IOException {
		fonts = new HashMap<String, String>();
		fonts.put("computer", "Courier New");
		errors = new HashMap<String, String>();
		Reader r = new Reader("text\\Errors.txt");
		while(r.ready()) {
			errors.put(r.readLine(), r.readLine());
		}
		r.close();
	}
	
	/**
	 * sets the current scene with a background
	 * 
	 * @param sc the scene to set
	 * @param bg the color of the background
	 */
	public static void setScene(Scene sc, Color bg) {
		sc.getStylesheets().add("style.css");
		sc.setFill(bg);
		Main.stage.setScene(sc);
		Main.stage.show();
	}
	
	/**
	 * returns a font given a key
	 * 
	 * @param key name of the key
	 * @param size the size of the font
	 * @return the font required
	 * @throws IOException
	 * @see 
	 */
	public static Font getFont(String key, int size) throws IOException {
		return Font.font(fonts.get(key), size);
	}

	/**
	 * returns an error given its key
	 * 
	 * @param key the key to the error
	 * @return the error as a string
	 */
	public static String getError(String key) {
		return errors.get(key);
	}
	
	public static void addBack(Group g, int x, int y, int w, int h, String id) throws IOException {
		Computer.back = new Button();
		Computer.back.setId(id);
		Computer.back.setFont(getFont("computer", 20));
		Computer.back.setText("Back");
		Computer.back.setTranslateX(x);
		Computer.back.setTranslateY(y);
		Computer.back.setPrefWidth(w);
		Computer.back.setPrefHeight(h);
		g.getChildren().add(Computer.back);
	}
	
}
