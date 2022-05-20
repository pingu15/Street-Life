package streetLife;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Computer {
	
	public ComputerFile cur;
	
	public Reader r;
	
	public Computer() {
		
	}
	
	public void setFile(String name) {
		this.cur = new ComputerFile(name, "", null);
	}
	
	public void start(Stage stage) throws IOException {
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_LEFT);
		
		TextField t = new TextField();
		t.setId("ComputerFont");
		r = new Reader("text\\CompStart.txt");
		t.appendText(r.nextPara());
		t.setFont(Functions.getFont("SourceCodePro-Light", 12));
		gp.getChildren().add(t);
		
		Functions.setScene(stage, gp, Color.BLACK);
	}
	
	public void open() {
		
	}
	
}
