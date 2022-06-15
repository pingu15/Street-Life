package streetLife;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Terminal-like screen to run commands
 * 
 * @author Max Sun
 * @since 1.0
 */
public class Computer {
	
	/**
	 * number of choice prompts
	 */
	final static int CHOICES = 13;
	
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
	 * back button to return to computer screen
	 */
	static Button back;
	
	/**
	 * whether or not user has read message
	 */
	static boolean readBoss;
	
	/**
	 * commands for computer
	 */
	static String helpCommands;
	
	/**
	 * Starts the panic stage using a computer terminal simulation
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		Group g = new Group();
    	Scene tmp = new Scene(g, Main.WIDTH, Main.HEIGHT);
    	ImageView img = new ImageView(Functions.getScene("about2.png"));
		g.getChildren().add(img);
		Functions.setScene(tmp, Color.BLACK);
		tmp.setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode() == KeyCode.SPACE) {
				try {
					setChoices();
					setCommands();
					settled = new Text();
					settled.setText("");
					input = new TextArea();
					input.setText("");
					display();
					handle();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Opens the computer during escape room 
	 * 
	 * @throws IOException
	 */
	public static void open() throws IOException {
		settled = new Text();
		settled.setText("Microsoft Doors [Version 10.0.69000.420]\n"
				+ "(c) Microsoft Corporation. All rights reserved.\n"
				+ "\n");
		input = new TextArea();
		input.setText("");
		display();
		handle();
	}
	
	/**
	 * handles any event
	 */
	public static void handle() {
		if(input != null) {
			input.setOnKeyPressed((KeyEvent event) -> {
				try {
					handleKey(event);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		if(back != null) {
			back.setOnMousePressed((MouseEvent event) -> {
				try {
					handleMouse(event);
				} catch(IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	/**
	 * Handles user key pressed
	 * 
	 * @param event
	 * @throws IOException
	 */
	private static void handleKey(KeyEvent event) throws IOException {
		if(event.getSource() == input) {
			if(index == 9 || index == 10 || index == 12) {
				index = CHOICES;
				cur = cur.par;
				ImageView nxt = new ImageView(Functions.getScene("part2done.png"));
				nxt.setFitWidth(Main.WIDTH);
				nxt.setPreserveRatio(true);
				Group gr = new Group(nxt);
				Scene temp = new Scene(gr, Main.WIDTH, Main.HEIGHT);
				Functions.setScene(temp, Color.BLACK);
				temp.setOnKeyPressed((KeyEvent e) -> {
					if(e.getCode() == KeyCode.SPACE) {
						try {
							EscapeRoom.start();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
				return;
			}
			if(event.getCode() == KeyCode.ENTER) {
				if(index < CHOICES) {
					handleChoice();
					return;
				}
				handleCommand();
				return;
			}
		}
	}
	
	/**
	 * Handles user mouse pressed
	 * 
	 * @param event
	 * @throws IOException
	 */
	private static void handleMouse(MouseEvent event) throws IOException {
		if(index == 1) {
			index = 2;
			display();
			return;
		}
		if(index == 7) {
			index = 8;
			display();
			return;
		}
		if(index == CHOICES) {
			display();
			return;
		}
	}
	
	/**
	 * Creates screen with text
	 * 
	 * @throws IOException
	 */
	private static void show() throws IOException {
		ScrollPane sp = new ScrollPane();
		Group g = new Group();
		g.setTranslateY(5);
		settled.setLineSpacing(8);
		settled.setFont(Functions.getFont("Courier", 13));
		settled.setFill(Color.WHITE);
		settled.setWrappingWidth(Main.WIDTH-20);
		settled.setTranslateX(5);
		g.getChildren().add(settled);
		double h = settled.getLayoutBounds().getHeight()-35;
		input.setId("ComputerText");
		input.setFont(Functions.getFont("Courier", 13));
		input.setWrapText(true);
		input.setPrefWidth(Main.WIDTH);
		input.setPrefHeight(Main.HEIGHT-h-15);
		input.setMaxHeight(input.getPrefHeight());
		input.setTranslateY(h);
		g.getChildren().add(input);
		g.prefHeight(Main.HEIGHT);
		sp.setContent(g);
		sp.setId("ScrollPane");
		comp = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(comp, Color.BLACK);
	}
	
	/**
	 * Adds prompts text to settled text
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
			s += "Enter --help for a list of commands\n";
		}
		settled.setText(s);
		show();
	}
	
	/**
	 * Handles regular command
	 * 
	 * @throws IOException
	 */
	private static void handleCommand() throws IOException {
		String s = settled.getText();
		String v = input.getText().trim();
		s += v + "\n";
		if(v.equals("--help")) {
			s += helpCommands;
			update(s);
			return;
		}
		if(v.equals("exit")) {
			EscapeRoom.open();
			return;
		}
		if(v.equals("dir")) {
			s += getFiles();
			update(s);
			return;
		}
		if(v.split(" ").length == 1) {
			s += v + Functions.getError("command") +"\n";
			update(s);
			return;
		}
		if(v.split(" ")[0].equals("unzip")) {
			String f = v.split(" ")[1];
			if(f.contains(".zip")) {
				boolean flag = false;
				f = f.substring(0, f.indexOf(".zip"));
				for(ComputerFile sub : cur.subFiles) {
					if(sub.name.equals(f) && !sub.unzipped) {
						sub.unzipped = true;
						flag = true;
					}
				}
				if(!flag) {
					s += "unzip: " + f + ".zip is not a valid file\n";
				}
			} else {
				s += "unzip: " + f + " is not a valid file\n";
			}
			update(s);
			return;
		}
		if(v.split(" ")[0].equals("cd")) {
			String f = v.split(" ")[1];
			boolean flag = false;
			if(f.equals("..")) {
				if(cur.par != null) {
					cur = cur.par;
				} else {
					s += "cd: parent directory does not exist\n";
				}
				update(s);
				return;
			}
			for(ComputerFile sub : cur.subFiles) {
				if(sub.name.equals(f) && sub.isFolder && sub.unzipped) {
					cur = sub;
					flag = true;
				}
			}
			if(!flag) {
				s += "cd: " + f + " is not a valid file\n";
			}
			update(s);
			return;
		}
		if(v.split(" ")[0].equals("open")) {
			boolean flag = false;
			String f = v.split(" ")[1];
			for(ComputerFile sub : cur.subFiles) {
				if(sub.name.equals(f) && !sub.isFolder) {
					flag = true;
					Group g = new Group();
					Functions.openComputerImage(g, sub.getRelativePath(), 0, 0, Main.WIDTH, Main.HEIGHT);
					if(f.equals("bankaccount.png")) {
						Functions.setButton(g, 72, 433, 200, 72, "Back", "backbutton");
					} else {
						Functions.setButton(g, Main.WIDTH/2-50, Main.HEIGHT-50, 100, 30, "Back", "backbuttonvisible");
					}
					Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT);
					Functions.setScene(sc, Color.BLACK);
				}
			}
			settled.setText(s);
			input = new TextArea();
			if(!flag) {
				s += "open: \'" + v.split(" ")[1] + "\' is not a valid file.\n";
				settled.setText(s);
				display();
				handle();
			} else {
				handle();
			}
			return;
		}
		if(v.split(" ")[0].equals("guess")) {
			if(v.split(" ").length != 3) {
				s += "open: incorrect number of parameters\n";
				update(s);
				return;
			}
			String f = v.split(" ")[1];
			String name = v.split(" ")[2];
			if(f.equalsIgnoreCase("library")) {
				if(name.equalsIgnoreCase("maya")) {
					EscapeRoom.guess[0] = true;
					s += "Correct!\n";
				} else {
					s += "Incorrect. Please try again.\n";
				}
			} else if(f.equalsIgnoreCase("street")) {
				if(name.equalsIgnoreCase("jason")) {
					EscapeRoom.guess[1] = true;
					s += "Correct!\n";
				} else {
					s += "Incorrect. Please try again.\n";
				}
			} else if(f.equalsIgnoreCase("school")) {
				if(name.equalsIgnoreCase("alexander")) {
					EscapeRoom.guess[2] = true;
					s += "Correct!\n";
				} else {
					s += "Incorrect. Please try again.\n";
				}
			} else {
				s += "open: location not valid\n";
			}
			update(s);
		}
	}
	
	/**
	 * updates the text boxes
	 * 
	 * @param s The string to set settled text box as
	 * @throws IOException
	 */
	private static void update(String s) throws IOException {
		settled.setText(s);
		input = new TextArea();
		handle();
		display();
	}
	
	/**
	 * Handles input on enter key
	 * 
	 * @throws IOException
	 */
	private static void handleChoice() throws IOException {
		String s = settled.getText();
		String v = input.getText();
		s += v + "\n";
		if(index == 0) {
			name = v;
			cur = new ComputerFile(name, "C:\\Users\\"+name, null, true);
			dfs(cur);
			index = 1;
			update(s);
			return;
		} 
		if(index == 1) {
			boolean flag = false;
			if(v.split(" ").length == 1) {
				s += "\'" + v + "\' is not a recognized command.\n";
			} else if(v.split(" ")[0].equals("open")) {
				if(v.split(" ")[1].equals("bankaccount.png")) {
					flag = true;
				} else {
					s += "open: \'" + v.split(" ")[1] + "\' is not a valid file.\n";
				}
			} else {
				s += "\'" + v.split(" ")[0] + "\' " + Functions.getError("command") + "\n";
			}
			settled.setText(s);
			input = new TextArea();
			if(flag) {
				Group g = new Group();
				Functions.openComputerImage(g, "computer\\bankaccount.png", 0, 0, Main.WIDTH, Main.HEIGHT);
				Functions.setButton(g, 72, 433, 200, 72, "Back", "backbutton");
				Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT);
				Functions.setScene(sc, Color.BLACK);
			} else {
				display();
			}
			handle();
			return;
		}
		if(index == 2) {
			if(v.equalsIgnoreCase("y")) {
				readBoss = true;
				index = 3;
				update(s);
				return;
			}
			if(v.equalsIgnoreCase("n")) {
				index = 4;
				update(s);
				return;
			}
			s += "enter y or n.\n";
			update(s);
			return;
		}
		if(index == 3 || index == 4) {
			boolean flag = false;
			if(v.split(" ").length == 1) {
				s += "\'" + v + "\' is not a recognized command.\n";
			} else if(v.split(" ")[0].equals("unzip")) {
				if(v.split(" ")[1].equals("envelope.zip")) {
					flag = true;
				} else {
					s += "unzip: \'" + v.split(" ")[1] + "\' is not a valid file.\n";
				}
			} else {
				s += "\'" + v.split(" ")[0] + "\' " + Functions.getError("command") + "\n";
			}
			if(flag) {
				for(ComputerFile sub : cur.subFiles) {
					if(sub.name.equals("envelope")) {
						sub.unzipped = true;
					}
				}
				s += "\nenvelope.zip unzipped to " + cur.pathName + "\\" + "envelope.\n\n";
				index = 5;
			}
			settled.setText(s);
			update(s);
			return;
		}
		if(index == 5) {
			boolean flag = false;
			if(v.split(" ").length == 1) {
				s += "\'" + v + "\' is not a recognized command.\n";
			} else if(v.split(" ")[0].equals("cd")) {
				if(v.split(" ")[1].equals("envelope")) {
					flag = true;
				} else {
					s += "cd: \'" + v.split(" ")[1] + "\' is not a valid directory.\n";
				}
			} else {
				s += "\'" + v.split(" ")[0] + "\' " + Functions.getError("command") + "\n";
			}
			if(flag) {
				for(ComputerFile sub : cur.subFiles) {
					if(sub.name.equals("envelope")) {
						cur = sub;
					}
				}
				index = 6;
			}
			update(s);
			return;
		}
		if(index == 6) {
			if(v.equals("dir")) {
				s += getFiles();
				index = 7;
				update(s);
				return;
			}
			s += v + Functions.getError("command") + "\n";
			update(s);
			return;
		}
		if(index == 7) {
			if(v.split(" ")[0].equals("open") && v.split(" ").length > 1) {
				boolean flag = false;
				String f = v.split(" ")[1];
				for(ComputerFile sub : cur.subFiles) {
					if(sub.name.equals(f)) {
						flag = true;
						Group g = new Group();
						Functions.openComputerImage(g, sub.getRelativePath(), 0, 0, Main.WIDTH, Main.HEIGHT);
						if(f.equals("bankaccount.png")) {
							Functions.setButton(g, 72, 433, 200, 72, "Back", "backbutton");
						} else {
							Functions.setButton(g, Main.WIDTH/2-50, Main.HEIGHT-50, 100, 30, "Back", "backbuttonvisible");
						}
						Scene sc = new Scene(g, Main.WIDTH, Main.HEIGHT);
						Functions.setScene(sc, Color.BLACK);
					}
				}
				settled.setText(s);
				input = new TextArea();
				if(!flag) {
					s += "open: \'" + v.split(" ")[1] + "\' is not a valid file.\n";
					settled.setText(s);
					display();
					handle();
				} else {
					handle();
				}
				return;
			}
			s += v + Functions.getError("command") + "\n";
			update(s);
			return;
		}
		if(index == 8) {
			if(readBoss) {
				if(v.equalsIgnoreCase("y")) {
					index = 9;
					update(s);
					return;
				}
				if(v.equalsIgnoreCase("n")) {
					index = 10;
					update(s);
					return;
				}
				s += "enter y or n.\n";
				update(s);
				return;
			} else {
				if(v.equalsIgnoreCase("y")) {
					readBoss = true;
					index = 11;
					update(s);
					return;
				}
				if(v.equalsIgnoreCase("n")) {
					index = 12;
					update(s);
					return;
				}
				s += "enter y or n.\n";
				update(s);
				return;
			}
		}
		if(index == 11) {
			if(v.equals("open messages.exe")) {
				index = 12;
				update(s);
				return;
			}
			s += v + Functions.getError("command") + "\n";
			update(s);
			return;
		}
	}

	/**
	 * Adds the choice prompts from text file
	 * 
	 * @throws IOException
	 */
	private static void setChoices() throws IOException {
		r = new Reader("CompStart.txt");
		choice = new String[CHOICES];
		Arrays.fill(choice, "");
		for(int c = 0; c < CHOICES; c++) {
			int lines = Integer.parseInt(r.readLine().split(" ")[0]);
			for(int i = 0; i < lines; i++) {
				choice[c] += r.readLine() + "\n";
			}
		}
		r.close();
	}
	
	/**
	 * Gets all the subfiles of the current computer folder
	 * 
	 * @return the list of subfiles as a string
	 */
	private static String getFiles() {
		String s = "";
		for(ComputerFile f : cur.subFiles) {
			s += (f.isFolder && !f.unzipped ? f.name+".zip" : f.name) + "\n";
		}
		return s.equals("") ? "No files\n" : s;
	}
	
	/**
	 * Sets the list of commands from the commands text file
	 * 
	 * @throws IOException
	 */
	private static void setCommands() throws IOException {
		r = new Reader("Commands.txt");
		helpCommands = r.nextPara();
		r.close();
	}
	
	/**
	 * Finds all files in the computer folder to act as the computer database
	 * 
	 * @param f the current computer file being looked through
	 */
	private static void dfs(ComputerFile f) {
		File file = new File(f.getRelativePath());
		for(File n : file.listFiles()) {
			ComputerFile c = new ComputerFile(n.getName(), f.pathName + "\\" + n.getName(), f, n.isDirectory());
			f.addSubFile(c);
			if(c.isFolder) {
				dfs(c);
			}
		}
	}
	
}
