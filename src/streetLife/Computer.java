package streetLife;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Computer {
	
	Stage stage;
	
	String name;
	
	ComputerFile cur;
	
	Reader r;
	
	Text settled;
	
	TextArea input;
	
	int index;
	
	public Computer(Stage stage) {
		this.stage = stage;
	}
	
	public void setFile(String name, ComputerFile par) {
		this.cur = new ComputerFile(name, par.pathName+"\\"+name, par);
	}
	
	public void start() throws IOException {
		settled = new Text();
		input = new TextArea();
		r = new Reader("text\\CompStart.txt");
		display();
		onEnter();
	}
	
	private void show() throws IOException {
		Group g = new Group();
		Functions.setScene(stage, g, Color.BLACK);
		settled.setLineSpacing(8);
		settled.setFont(Font.font("Courier New", 12));
		settled.setFill(Color.WHITE);
		settled.setWrappingWidth(Main.WIDTH-5);
		settled.setTranslateX(5);
		settled.setTranslateY(20);
		g.getChildren().add(settled);
		double h = settled.getLayoutBounds().getHeight()-5;
		input.setId("ComputerText");
		input.setFont(Font.font("Courier New", 12));
		input.setWrapText(true);
		input.setPrefWidth(Main.WIDTH-5);
		input.setTranslateY(h);
		g.getChildren().add(input);
	}
	
	private void display() throws IOException {
		int lines = r.readInt();
		String s = settled.getText();
		for(int i = 1; i <= lines; i++) {
			s += r.readLine() + "\n";
		}
		settled.setText(s);
		show();
	}
	
	private void onEnter() {
		input.setOnKeyPressed((KeyEvent e) -> {
			if(e.getCode() == KeyCode.ENTER) {
				if(index == 0) {
					String s = settled.getText();
					name = input.getText();
					input.clear();
					s += name + "\n";
					setFile(name, new ComputerFile(name, "C:\\Users", null));
					settled.setText(s);
					index++;
					try {
						display();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					return;
				}
				if(index == 1) {
					String s = settled.getText();
					String v = input.getText();
					s += v + "\n";
					if(v.split(" ")[0].equals("open")) {
						if(v.split(" ")[1].equals("bankaccount.png")) {
							
						} else {
							
						}
					} else {
						
					}
				}
			}
		});
	}
	
}
