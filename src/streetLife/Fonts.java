package streetLife;

import java.io.*;

import javafx.scene.text.Font;

public class Fonts {

	public static Font getFont(String name, int size) throws IOException {
		InputStream in = new FileInputStream("fonts\\"+name+".ttf");
		return Font.loadFont(in, size);
	}
	
}
