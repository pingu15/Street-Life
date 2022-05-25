package streetLife;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Functions {
	
	public static void setScene(Stage stage, Group g, Color bg) {
		Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT, bg);
		sc.getStylesheets().add("style.css");
		stage.setScene(sc);
		stage.show();
	}
	
	public static Font getFont(String name, int size) throws IOException {
		InputStream in = new FileInputStream("fonts/"+name+".ttf");
		return Font.loadFont(in, size);
	}

}
