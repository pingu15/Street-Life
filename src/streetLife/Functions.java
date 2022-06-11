/**
 * MAXX DO THISSS
 *
 * @author Max Sun
 * @author Zoe Fan-Chiang
 * @author Derek Ma
 * @version 3.0
 * @since 2022-05-24
 */

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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Functions {
	
	/**
	 * map of error keys to errors
	 */
	private static HashMap<String, String> errors;
	
	/**
	 * map of passwords for zipped files in computer
	 */
	public static HashMap<String, String> passwords;
	
	/**
	 * map of prompts for zipped files in computer
	 */
	public static HashMap<String, String> prompts;
	
	/**
	 * displays an image from the computer folder
	 * 
	 * @param img the file name of the image to display
	 * @throws IOException
	 */
	public static void openComputerImage(Group g, String img, int x, int y, int w, int h) throws IOException {
		ImageView iv = new ImageView();
		InputStream in = new FileInputStream(img);
		Image image = new Image(in);
		iv.setImage(image);
		iv.setTranslateX(x);
		iv.setTranslateY(y);
		iv.setFitWidth(w);
		iv.setFitHeight(h);
		g.getChildren().add(iv);
	}
	
	/**
	 * commands to run on load of the game
	 * 
	 * @throws IOException
	 */
	public static void onLoad() throws IOException {
		errors = new HashMap<String, String>();
		Reader r = new Reader("Errors.txt");
		while(r.ready()) {
			errors.put(r.readLine(), r.readLine());
		}
		passwords = new HashMap<String, String>();
		r.close();
		r = new Reader("Answers.txt");
		while(r.ready()) {
			passwords.put(r.readLine(), r.readLine());
		}
		r.close();
		prompts = new HashMap<String, String>();
		r = new Reader("Questions.txt");
		while(r.ready()) {
			prompts.put(r.readLine(), r.readLine());
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
	 * returns a font given the name
	 * 
	 * @param font name of the font
	 * @param size the size of the font
	 * @return the font required
	 * @throws IOException
	 */
	public static Font getFont(String font, int size) throws IOException {
		InputStream in = new FileInputStream("fonts\\"+font+".ttf");
		return Font.loadFont(in, size);
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
	
	/**
	 * Adds a button
	 * 
	 * @param g the group to add the button to
	 * @param x the x value
	 * @param y the y value
	 * @param w the width
	 * @param h the height
	 * @param s the text inside
	 * @param id the button id
	 * @throws IOException
	 */
	public static void setButton(Group g, int x, int y, int w, int h, String s, String id) throws IOException {
		Computer.back = new Button();
		Computer.back.setId(id);
		Computer.back.setFont(getFont("Courier", 20));
		Computer.back.setText(s);
		Computer.back.setTranslateX(x);
		Computer.back.setTranslateY(y);
		Computer.back.setPrefWidth(w);
		Computer.back.setPrefHeight(h);
		g.getChildren().add(Computer.back);
	}
	
	/**
	 * Gets a background image
	 * 
	 * @param img the name of the image
	 * @return the required background image
	 * @throws IOException
	 */
	public static BackgroundImage getBg(String img) throws IOException {
		InputStream in = new FileInputStream("scenes\\"+img+".png");
		Image image = new Image(in, Main.WIDTH, Main.HEIGHT, true, true);
		return new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
	}

	/**
	 * Returns an image
	 * 
	 * @param img the image requested
	 * @param w the width of the image
	 * @param h the height of the image
	 * @return the image required
	 * @throws IOException
	 */
	public static Image getImage(String img, int w, int h) throws IOException {
		InputStream in = new FileInputStream("images\\"+img);
		return new Image(in, w, h, true, true);
	}
	
	public static Image getDefImg(String img) throws IOException {
		InputStream in = new FileInputStream("deficiency graphics\\"+img);
		return new Image(in, Main.WIDTH, Main.HEIGHT, true, true);
	}
	
	public static Image getScene(String img) throws IOException {
		InputStream in = new FileInputStream("scenes\\"+img);
		return new Image(in);
	}
	
}
