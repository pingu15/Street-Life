package streetLife;

import java.io.IOException;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
	
	String[] choice;
	
	final int CHOICES = 2;
	
	public Computer(Stage stage) throws IOException {
		this.stage = stage;
		setChoices();
	}
	
	public void setFile(String name, ComputerFile par) {
		this.cur = new ComputerFile(name, par.pathName+"\\"+name, par);
	}
	
	public void start() throws IOException {
		settled = new Text();
		settled.setText("");
		input = new TextArea();
		input.setText("");
		display();
		onEnter();
	}
	
	private void show() throws IOException {
		Group g = new Group();
		Functions.setScene(stage, g, Color.BLACK);
		settled.setLineSpacing(8);
		settled.setFont(Functions.getFont("computer", 14));
		settled.setFill(Color.WHITE);
		settled.setWrappingWidth(Main.WIDTH-5);
		settled.setTranslateX(5);
		settled.setTranslateY(20);
		g.getChildren().add(settled);
		double h = settled.getLayoutBounds().getHeight()-5;
		input.setId("ComputerText");
		input.setFont(Functions.getFont("computer", 14));
		input.setWrapText(true);
		input.setPrefWidth(Main.WIDTH-5);
		input.setPrefHeight(Main.HEIGHT-h);
		input.setTranslateY(h);
		g.getChildren().add(input);
	}
	
	private void display() throws IOException {
		String s = settled.getText();
		if(index > 0) {
			s += cur + "> ";
		}
		if(index < CHOICES) {
			s += choice[index];
		} else {
			s += "Press --help for a list of commands\n";
		}
		settled.setText(s);
		show();
		onEnter();
	}
	
	private void onEnter() {
		input.setOnKeyPressed((KeyEvent e) -> {
			if(e.getCode() == KeyCode.ENTER) {
				if(index == 0) {
					String s = settled.getText();
					name = input.getText();
					input = new TextArea();
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
					if(v.split(" ").length == 1) {
						s += "\'" + v + "\' is not a recognized command.\n";
					} else if(v.split(" ")[0].equals("open")) {
						if(v.split(" ")[1].equals("bankaccount.png")) {
							Functions.openImage(stage, "bankaccount.png");
							index++;
						} else {
							s += "open: \'" + v.split(" ")[1] + "\' is not an open command.\n";
						}
					} else {
						s += "\'" + v.split(" ")[0] + "\' " + Functions.getError("command") + "\n";
					}
					settled.setText(s);
					input = new TextArea();
					try {
						display();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					return;
				}
			}
		});
	}
	
	private void setChoices() throws IOException {
		r = new Reader("text\\CompStart.txt");
		choice = new String[CHOICES];
		Arrays.fill(choice, "");
		for(int c = 0; c < CHOICES; c++) {
			int lines = r.readInt();
			for(int i = 0; i < lines; i++) {
				choice[c] += r.readLine() + "\n";
			}
		}
	}
	
}
