package streetLife;

import java.io.IOException;
import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EscapeRoom {
	
	/**
	 * Button for switching backgrounds
	 */
	static Button school, library, street;
	
	/**
	 * the background image
	 */
	static Background bg;
	
	/**
	 * the scene for the escape room
	 */
	static Scene sc;
	
	/**
	 * layer for scene formatting
	 */
	static StackPane sp;
	
	/**
	 * the current location
	 */
	static String cur;
	
	/**
	 * icons for chat and comp
	 */
	static ImageView chat, comp;

	/**
	 * chat pane
	 */
	static StackPane cp;
	
	/**
	 * chat scroll pane
	 */
	static ScrollPane ch;
	
	/**
	 * whether or not chat is open
	 */
	static boolean chatOpen;
	
	/**
	 * left or right text options
	 */
	static TextOption left, right;
	
	static Button b;
	
	static Button leftB, rightB;
	
	static HashMap<String, TextOption[][]> MAP;
	static HashMap<String, Integer> ROUND;

	static String picked;
	
	static Text lastSettled;
	
	static Group g;
	
	static int week = 1;
	
	/**
	 * starts the escape room
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		setParts();
		sp = new StackPane();
		bg = new Background(Functions.getBg("street.png"));
		sp.setBackground(bg);
		sp.setAlignment(Pos.TOP_LEFT);
		sc = new Scene(sp, Main.WIDTH, Main.HEIGHT);
		Functions.setScene(sc, Color.BLACK);
		street = new Button();
		street.setVisible(false);
		street.setId("switchbutton");
		street.setText("Back");
		street.setPrefWidth(100);
		street.setPrefHeight(50);
		street.setFont(Functions.getFont("Courier", 20));
		street.setTranslateX(50);
		street.setTranslateY(50);
		library = new Button();
		library.setPrefWidth(100);
		library.setPrefHeight(50);
		library.setVisible(true);
		library.setId("switchbutton");
		library.setText("Library");
		library.setTranslateX(50);
		library.setTranslateY(240);
		library.setFont(Functions.getFont("Courier", 20));
		school = new Button();
		school.setPrefWidth(100);
		school.setPrefHeight(50);
		school.setVisible(true);
		school.setId("switchbutton");
		school.setText("School");
		school.setFont(Functions.getFont("Courier", 20));
		school.setTranslateX(810);
		school.setTranslateY(240);
		sp.getChildren().addAll(school, library, street);
		chat = new ImageView(Functions.getImage("chat.png", 70, 70));
		comp = new ImageView(Functions.getImage("comp.png", 70, 70));
		chat.setTranslateX(390);
		chat.setTranslateY(440);
		comp.setTranslateX(500);
		comp.setTranslateY(440);
		sp.getChildren().addAll(chat, comp);
		but(library);
		but(school);
		but(street);
		but(chat);
		but(comp);
		cur = "street";
		picked = "";
		left = MAP.get(cur)[ROUND.get(cur)][1];
		cp = new StackPane();
		b = new Button("Advance Week");
		b.setTranslateX(400);
		b.setTranslateY(250);
		b.setPrefWidth(150);
		b.setPrefHeight(50);
		b.setTextFill(Color.BLACK);
		b.setFont(Functions.getFont("Courier", 12));
		but(b);
		sp.getChildren().add(b);
		g = new Group();
		displayChat();
	}
	
	public static void open() throws IOException {
		if(cur.equals("library")) {
			bg = new Background(Functions.getBg("library.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(cur.equals("school")) {
			bg = new Background(Functions.getBg("school.png"));
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(cur.equals("street")) {
			bg = new Background(Functions.getBg("street.png"));
			sp.setBackground(bg);
			library.setVisible(true);
			school.setVisible(true);
			street.setVisible(false);
		}
		Functions.setScene(sc, Color.BLACK);
	}
	
	private static void but(Node b) {
		b.setOnMousePressed((MouseEvent event) -> {
			try {
				handleMouse(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		b.setOnMouseEntered((MouseEvent event) -> {
			 try {
				handleHover(event);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
		b.setOnMouseExited((MouseEvent event) -> {
			 try {
				handleExit(event);
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 });
	}
	
	private static void handleHover(MouseEvent e) throws IOException {
		if(e.getSource() == chat) {
			chat.setTranslateY(430);
		}
		if(e.getSource() == comp) {
			comp.setTranslateY(430);
		}
	}
	
	private static void handleExit(MouseEvent e) throws IOException {
		if(e.getSource() == chat) {
			chat.setTranslateY(440);
		}
		if(e.getSource() == comp) {
			comp.setTranslateY(440);
		}
	}
	
	private static void handleMouse(MouseEvent e) throws IOException {
		if(e.getSource() == library) {
			closeChat();
			chatOpen = false;
			bg = new Background(Functions.getBg("library.png"));
			cur = "library";
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == school) {
			closeChat();
			chatOpen = false;
			bg = new Background(Functions.getBg("school.png"));
			cur = "school";
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == street) {
			closeChat();
			chatOpen = false;
			bg = new Background(Functions.getBg("street.png"));
			cur = "street";
			sp.setBackground(bg);
			library.setVisible(true);
			school.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == chat) {
			if(chatOpen) {
				openChat();
			} else {
				closeChat();
			}
			chatOpen = !chatOpen;
		}
		if(e.getSource() == comp) {
			closeChat();
			chatOpen = false;
			Computer.open();
		}
		if(e.getSource() == b) {
			advWeek();
			return;
		}
		if(e.getSource() == leftB) {
			if(left.left != null) {
				int h = lastSettled == null ? 0 : (int)lastSettled.getTranslateY()+20;
				left.setTranslateY(h);
				left.setTranslateX(300);
				left.setWrappingWidth(300);
				left.setTextAlignment(TextAlignment.RIGHT);
				g.getChildren().add(left);
				lastSettled = left;
				Text set = new Text(left.response);
				set.setFont(Functions.getFont("Courier", 12));
				h = (int)lastSettled.getTranslateY()+20;
				set.setTranslateY(h);
				set.setTranslateX(10);
				set.setWrappingWidth(300);
				g.getChildren().add(set);
				cp.getChildren().remove(left);
				if(right != null) cp.getChildren().remove(right);
				lastSettled = set;
				left = left.left;
				right = left.right;
				displayChat();
			} else {
				ROUND.put(cur, ROUND.get(cur)+1);
				left = right = null;
				picked = cur;
				displayChat();
			}
		}
		if(e.getSource() == rightB) {
			if(right.left != null) {
				int h = lastSettled == null ? 0 : (int)lastSettled.getTranslateY()+20;
				right.setTranslateY(h);
				right.setTranslateX(300);
				right.setWrappingWidth(300);
				right.setTextAlignment(TextAlignment.RIGHT);
				g.getChildren().add(right);
				lastSettled = right;
				Text set = new Text(right.response);
				set.setFont(Functions.getFont("Courier", 12));
				h = (int)lastSettled.getTranslateY()+20;
				set.setTranslateY(h);
				set.setTranslateX(10);
				set.setWrappingWidth(300);
				g.getChildren().add(set);
				cp.getChildren().remove(left);
				if(right != null) cp.getChildren().remove(right);
				lastSettled = set;
				left = right.left;
				right = right.right;
				displayChat();
			} else {
				ROUND.put(cur, ROUND.get(cur)+1);
				left = right = null;
				picked = cur;
				displayChat();
			}
		}
	}
	
	private static void openChat() throws IOException {
		ch = new ScrollPane();
		ch.setTranslateX(5);
		ch.setTranslateY(5);
		ch.setPrefWidth(630);
		ch.setMaxWidth(630);
		ch.setMaxHeight(280);
		g = new Group();
		g.setTranslateX(5);
		g.setTranslateY(5);
		ch.setContent(g);
		ch.setId("ChatScroll");
		cp = new StackPane();
		cp.setTranslateX(160);
		cp.setTranslateY(20);
		cp.setPrefWidth(640);
		cp.setMaxWidth(640);
		cp.setMaxHeight(400);
		cp.setPrefHeight(400);
		cp.setId("ChatPane");
		cp.setVisible(true);
		cp.setAlignment(Pos.TOP_LEFT);
		cp.getChildren().add(ch);
		sp.getChildren().add(cp);
		left = MAP.get(cur)[ROUND.get(cur)][1];
		left.setTextAlignment(TextAlignment.CENTER);
		ch.setContent(g);
		displayChat();
	}
	
	private static void closeChat() {
		cp.setVisible(false);
	}
	
	private static void setParts() throws IOException {
		String[] parts = {"school", "library", "street"};
		MAP = new HashMap<>();
		ROUND = new HashMap<>();
		for(String s : parts) {
			ROUND.put(s, 1);
			MAP.put(s, new TextOption[4][1]);
			for(int i = 1; i <= 3; i++) {
				Reader r = new Reader(s+"\\part"+i+".txt");
				int N = r.readInt();
				TextOption[] cur = MAP.get(s)[i] = new TextOption[N+1];
				int[][] adj = new int[N+1][2];
				String l;
				while(!(l = r.readLine()).equals("")) {
					int a = Integer.parseInt(l.split(" ")[0]);
					int b = Integer.parseInt(l.split(" ")[1]);
					adj[a][adj[a][0] != 0 ? 1 : 0] = b;
				}
				for(int j = 1; j <= N; j++) {
					TextOption t = new TextOption();
					try {
						t.IDX = r.readInt();
					} catch (Exception ex) {
						System.out.println(s+"\\part"+i+".txt");
					}
					t.setText(r.readLine());
					t.response = r.readLine();
					t.res = ' ';
					cur[j] = t;
				}
				for(int j = 1; j <= N; j++) {
					cur[j].left = adj[j][0] == 0 ? null : cur[adj[j][0]];
					cur[j].right = adj[j][1] == 0 ? null : cur[adj[j][1]];
				}
				r.close();
				/*r = new Reader(s+"\\part"+i+"Res.txt");
				while(r.ready()) {
					int idx = r.readInt();
					cur[idx].res = r.readLine().charAt(0);
				}
				r.close();*/
			}
		}
	}
	
	private static void displayChat() throws IOException {
		cp.getChildren().remove(rightB);
		cp.getChildren().remove(leftB);
		if(!picked.equals("")) {
			Text t = new Text("You already spoke with someone this week. Advance week to speak again.");
			t.setTranslateX(165);
			t.setTranslateY(360);
			t.prefWidth(630);
			t.prefHeight(55);
			t.setId("textoption");
			return;
		}
		if(ROUND.get(cur) == 4) {
			Text t = new Text("No more text options with this person.");
			t.setTranslateX(165);
			t.setTranslateY(360);
			t.prefWidth(630);
			t.prefHeight(55);
			t.setId("textoption");
			return;
		}
		left.setTranslateX(5);
		left.setTranslateY(290);
		left.setWrappingWidth(right == null ? 630 : 310);
		left.setId("textoption");
		left.setFill(Color.BLACK);
		left.setVisible(true);
		left.setFont(Functions.getFont("Courier", 12));
		leftB = new Button();
		rightB = new Button();
		leftB.setTranslateX(left.getTranslateX());
		leftB.setTranslateY(left.getTranslateY());
		leftB.setId("selectbutton");
		leftB.setPrefWidth(left.getWrappingWidth());
		leftB.setPrefHeight(100);
		if(right != null) {
			right.setTranslateX(320);
			right.setTranslateY(290);
			right.setWrappingWidth(310);
			right.setFont(Functions.getFont("Courier", 12));
			right.prefHeight(50);
			right.setId("textoption");
			cp.getChildren().remove(rightB);
			rightB = new Button();
			rightB.setTranslateX(right.getTranslateX());
			rightB.setTranslateY(right.getTranslateY());
			rightB.setId("selectbutton");
			rightB.setPrefWidth(right.getWrappingWidth());
			rightB.setPrefHeight(100);
		}
		cp.getChildren().add(leftB);
		cp.getChildren().add(left);
		if(right != null) cp.getChildren().add(right);
		if(rightB != null) cp.getChildren().add(rightB);
		but(leftB);
		if(right != null) but(rightB);
		return;
	}
	
	private static void advWeek() throws IOException {
		week++;
		if(week == 7) {
			Group r = new Group();
			ImageView i = new ImageView(Functions.getScene("win.png"));
			r.getChildren().add(i);
			Scene win = new Scene(r, Main.WIDTH, Main.HEIGHT);
			Functions.setScene(win, Color.BLACK);
			win.setOnKeyPressed((KeyEvent event) -> {
				if(event.getCode() == KeyCode.SPACE) {
					try {
						MainMenu m = new MainMenu(Main.stage);
						m.run();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			DirectionsGame d = new DirectionsGame(Main.stage);
			d.newGame();
		}
	}
	
}