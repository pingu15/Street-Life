package streetLife;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Functions {
	
	public static HashMap<String, Font> fonts;
	
	public static void onLoad() throws IOException {
		addFont("computer", "SourceCodePro-Regular", 14);
	}
	
	public static void setScene(Stage stage, GridPane gp, Color bg) {
		Scene sc = new Scene(gp, Main.WIDTH, Main.HEIGHT);
		sc.setFill(bg);
		sc.getStylesheets().add("style.css");
		stage.setScene(sc);
		stage.show();
	}
	
	public static void addFont(String key, String name, int size) throws IOException {
		InputStream in = new FileInputStream("fonts\\"+name+".ttf");
		fonts.put(key, Font.loadFont(in, size));
	}
	
	public static Font getFont(String key) {
		return fonts.get(key);
	}

}
