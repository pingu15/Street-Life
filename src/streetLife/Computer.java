package streetLife;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Computer {
	
	public ComputerFile cur;
	
	public Reader r;
	
	public Computer() {
		this.cur = new ComputerFile("Administrator", "C:\\Windows\\system32", null);
	}
	
	public void setFile(String name, ComputerFile par) {
		this.cur = new ComputerFile(name, par.pathName+"\\name", par);
	}
	
	public void start(Stage stage) throws IOException {
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_LEFT);
		Functions.setScene(stage, gp, Color.WHITE);
		Text title = new Text();
		gp.getChildren().add(title);
		title.maxHeight(Main.HEIGHT);
		title.maxWidth(Main.WIDTH);
		title.setText(r.nextPara());
		title.setStroke(Color.WHITE);
		title.setFont(Functions.getFont("computer"));
		TextArea t = new TextArea();
		gp.getChildren().add(t);
		t.setId("ComputerText");
		t.setPrefHeight(Main.HEIGHT);
		t.setPrefWidth(Main.WIDTH);
		t.setWrapText(true);
		r = new Reader("text\\CompStart.txt");
		t.appendText(r.nextPara());
		t.setFont(Functions.getFont("computer"));
		
	}
	
	public void userInput() {
		
	}
	
	public void open() {
		
	}
	
}
