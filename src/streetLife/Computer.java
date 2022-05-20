package streetLife;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Computer {
	
	public ComputerFile cur;
	
	public Reader r;
	
	public Computer() {
		r = new Reader();
	}
	
	public void setComputer(String name) {
		this.cur = new ComputerFile(name, true, "", null);
	}
	
	public void start(Stage stage) throws IOException {
		StackPane sp = new StackPane();
		sp.setAlignment(Pos.TOP_LEFT);
		Scene sc = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		sc.setFill(Color.BLACK);
		Text t = new Text();
		String v = "", tmp;
		r.setFile("text\\CompStart.txt");
		while((tmp = r.readLine()) != null) {
			v += tmp + "\n";
		}
		t.setText(v);
		t.setFont(Fonts.getFont("CascadiaCode-Regular", 12));
		System.out.println(t.getFont());
		t.setStroke(Color.WHITE);
		t.setTranslateX(5);
		t.setTranslateY(5);
		sp.getChildren().add(t);
		stage.setScene(sc);
		stage.show();
	}
	
	public void open() {
		
	}
	
}
