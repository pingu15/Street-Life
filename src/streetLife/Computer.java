package streetLife;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
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
		Functions.setScene(stage, gp, Color.WHITE);
		TextArea t = new TextArea();
		gp.getChildren().add(t);
		t.setId("ComputerText");
		t.setPrefHeight(Main.HEIGHT);
		t.setPrefWidth(Main.WIDTH);
		t.setWrapText(true);
		r = new Reader("text\\CompStart.txt");
		t.appendText(r.nextPara());
		t.setFont(Functions.getFont("SourceCodePro-Regular", 14));
		
	}
	
	public void userInput() {
		
	}
	
	public void open() {
		
	}
	
}
