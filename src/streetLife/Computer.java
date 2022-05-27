package streetLife;

import java.io.IOException;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Computer {
	
	/**
	 * number of choice prompts
	 */
	final static int CHOICES = 5;
	
	/**
	 * name of user
	 */
	static String name;
	
	/**
	 * reader to read from text files
	 */
	static Reader r;
	
	/**
	 * scenes for the computer and when an image is displayed
	 */
	static Scene comp, image;
	
	/**
	 * index of current choice
	 */
	static int index;
	
	/**
	 * array of choice prompts
	 */
	static String[] choice;
	
	/**
	 * settled text the user cannot edit
	 */
	static Text settled;
	
	/**
	 * input text the user can edit
	 */
	static TextArea input;
	
	/**
	 * current computer folder
	 */
	static ComputerFile cur;
	
	
	/**
	 * back button to return to terminal screen
	 */
	static Button back;
	
	/**
	 * Starts the panic stage using a computer terminal simulation
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		setChoices();
		settled = new Text();
		settled.setText("");
		input = new TextArea();
		input.setText("");
		display();
		input();
	}
	
	/**
	 * Creates screen with text
	 * 
	 * @throws IOException
	 */
	private static void show() throws IOException {
		ScrollPane sp = new ScrollPane();
		Group g = new Group();
		g.setTranslateY(10);
		settled.setLineSpacing(8);
		settled.setFont(Functions.getFont("computer", 14));
		settled.setFill(Color.WHITE);
		settled.setWrappingWidth(Main.WIDTH-15);
		settled.setTranslateX(5);
		settled.setTranslateY(20);
		g.getChildren().add(settled);
		double h = settled.getLayoutBounds().getHeight()-10;
		input.setId("ComputerText");
		input.setFont(Functions.getFont("computer", 14));
		input.setWrapText(true);
		input.setPrefWidth(Main.WIDTH-15);
		input.setPrefHeight(Main.HEIGHT-h-10);
		input.setTranslateY(h);
		g.getChildren().add(input);
		g.prefHeight(Main.HEIGHT);
		sp.setContent(g);
		sp.setId("ScrollPane");
		comp = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(comp, Color.BLACK);
	}
	
	/**
	 * Adds input text to settled text and displays it
	 * 
	 * @throws IOException
	 */
	private static void display() throws IOException {
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
	}
	
	/**
	 * On user key pressed
	 */
	private static void input() {
		input.setOnKeyPressed((KeyEvent e) -> {
			if(e.getCode() == KeyCode.ENTER) {
				try {
					handle();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Handles input on enter key
	 * 
	 * @throws IOException
	 */
	private static void handle() throws IOException {
		String s = settled.getText();
		String v = input.getText();
		s += v + "\n";
		if(index == 0) {
			name = v;
			input = new TextArea();
			input();
			setFile(name, new ComputerFile(name, "C:\\Users", null));
			settled.setText(s);
			index++;
			display();
			return;
		} 
		if(index == 1) {
			input = new TextArea();
			boolean flag = false;
			if(v.split(" ").length == 1) {
				s += "\'" + v + "\' is not a recognized command.\n";
			} else if(v.split(" ")[0].equals("open")) {
				if(v.split(" ")[1].equals("bankaccount.png")) {
					flag = true;
				} else {
					s += "open: \'" + v.split(" ")[1] + "\' is not an open command.\n";
				}
			} else {
				s += "\'" + v.split(" ")[0] + "\' " + Functions.getError("command") + "\n";
			}
			settled.setText(s);
			input();
			if(flag) {
				Functions.openImage("bankaccount.png", 72, 433, 200, 72, "backbutton");
				onClick();
			} else {
				display();
			}
			return;
		}
		if(index == 2) {
			if(v.equalsIgnoreCase("y")) {
				index = 3;
				input = new TextArea();
				input();
				settled.setText(s);
				display();
				return;
			}
			if(v.equalsIgnoreCase("n")) {
				index = 4;
				input = new TextArea();
				input();
				settled.setText(s);
				display();
				return;
			}
			input = new TextArea();
			input();
			s += "enter y or n.\n";
			settled.setText(s);
			display();
			return;
		}
	}
	
	/**
	 * Goes back to terminal screen
	 */
	private static void onClick() {
		back.setOnMouseClicked((MouseEvent e) -> {
			try {
				handleButton();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
	
	/**
	 * hands events based on current choice button is operating on 
	 * 
	 * @throws IOException
	 */
	private static void handleButton() throws IOException {
		if(index == 1) {
			index++;
			display();
			return;
		}
	}

	/**
	 * Adds the choice prompts from text file
	 * 
	 * @throws IOException
	 */
	private static void setChoices() throws IOException {
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
	
	/**
	 * 
	 * @param name name of the folder or file
	 * @param par name of the parent folder
	 */
	private static void setFile(String name, ComputerFile par) {
		cur = new ComputerFile(name, par.pathName+"\\"+name, par);
	}
	
}
