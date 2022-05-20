package streetLife;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Functions {
	
	public static void setScene(Stage stage, GridPane gp, Color bg) {
		Scene sc = new Scene(gp, Main.WIDTH, Main.HEIGHT);
		sc.setFill(bg);
		sc.getStylesheets().add("C:\\Users\\maxsu\\eclipse-workspace\\Street Life\\stylesheets\\style.css");
		stage.setScene(sc);
		stage.show();
	}
	
	public static Font getFont(String name, int size) throws IOException {
		InputStream in = new FileInputStream("fonts\\"+name+".ttf");
		return Font.loadFont(in, size);
	}

}
