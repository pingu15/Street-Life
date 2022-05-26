package streetLife;

import java.io.IOException;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Functions {
	
	private static HashMap<String, String> fonts;
	private static HashMap<String, String> errors;
	
	public static void openImage(Stage stage, String img) {
		ImageView iv = new ImageView();
		Image image = new Image("images\\"+img, false);
		iv.setImage(image);
		iv.setFitWidth(Main.WIDTH);
		iv.setFitHeight(Main.HEIGHT);
		Group g = new Group();
		g.getChildren().add(iv);
		Functions.setScene(stage, g, Color.BLACK);
	}
	
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
	
	public static void setScene(Stage stage, Group g, Color bg) {
		Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT, bg);
		sc.getStylesheets().add("style.css");
		stage.setScene(sc);
		stage.show();
	}
	
	public static Font getFont(String key, int size) throws IOException {
		return Font.font(fonts.get(key), size);
	}

	public static String getError(String key) {
		return errors.get(key);
	}
	
}
