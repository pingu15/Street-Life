package streetLife;

import java.io.IOException;
import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * The "escape room" for the user to get out of
 * 
 * @author Max Sun
 * @since 1.0
 */
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
	
	static Rectangle chatr, compr;

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
	
	static int week;
	
	static Text weekText;
	
	final static String LIB = "27131133966796";
	
	static boolean validCard;
	
	static ImageView chatImg;
	
	/**
	 * starts the escape room
	 * 
	 * @throws IOException
	 */
	public static void start() throws IOException {
		week = 1;
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
		but(library);
		but(school);
		but(street);
		sp.getChildren().addAll(chat, comp);
		chatr = new Rectangle();
		chatr.setTranslateX(chat.getTranslateX());
		chatr.setTranslateY(chat.getTranslateY());
		chatr.setWidth(70);
		chatr.setHeight(70);
		chatr.setFill(Color.TRANSPARENT);
		sp.getChildren().add(chatr);
		but(chatr);
		compr = new Rectangle();
		compr.setTranslateX(comp.getTranslateX());
		compr.setTranslateY(comp.getTranslateY());
		compr.setWidth(70);
		compr.setHeight(70);
		compr.setFill(Color.TRANSPARENT);
		sp.getChildren().add(compr);
		but(compr);
		cur = "street";
		weekText = new Text();
		weekText.setTranslateX(415);
		weekText.setTranslateY(30);
		weekText.setFont(Functions.getFont("Courier", 40));
		weekText.setFill(Color.WHITE);
		weekText.setText("Week 1");
		sp.getChildren().add(weekText);
		picked = "";
		left = MAP.get(cur)[ROUND.get(cur)][1];
		cp = new StackPane();
		b = new Button("Advance Week");
		b.setTranslateX(400);
		b.setTranslateY(240);
		b.setPrefWidth(180);
		b.setPrefHeight(50);
		b.setTextFill(Color.BLACK);
		b.setFont(Functions.getFont("Courier", 20));
		b.setId("switchbutton");
		but(b);
		sp.getChildren().add(b);
		g = new Group();
		chatImg = new ImageView();
		displayChat();
		click();
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
		if(e.getSource() == chatr) {
			chat.setTranslateY(430);
		}
		if(e.getSource() == compr) {
			comp.setTranslateY(430);
		}
		if(e.getSource() == leftB || e.getSource() == rightB) {
			sc.setCursor(Cursor.HAND);
		}
	}
	
	private static void handleExit(MouseEvent e) throws IOException {
		if(e.getSource() == chatr) {
			chat.setTranslateY(440);
		}
		if(e.getSource() == compr) {
			comp.setTranslateY(440);
		}
		if(e.getSource() == leftB || e.getSource() == rightB) {
			sc.setCursor(Cursor.DEFAULT);
		}
	}
	
	private static void handleMouse(MouseEvent e) throws IOException {
		if(e.getSource() == library) {
			Group r = new Group();
			ImageView i = new ImageView(Functions.getScene("libraryprompt.png"));
			r.getChildren().add(i);
			Scene lib = new Scene(r, Main.WIDTH, Main.HEIGHT);
			Functions.setScene(lib, Color.BLACK);
			newT(r, false);
		}
		if(e.getSource() == school) {
			closeChat();
			chatOpen = false;
			DirectionsGame d = new DirectionsGame(Main.stage);
			d.newGame();
			bg = new Background(Functions.getBg("school.png"));
			cur = "school";
			weekText.setFill(Color.BLACK);
			sp.setBackground(bg);
			library.setVisible(false);
			school.setVisible(false);
			street.setVisible(true);
		}
		if(e.getSource() == street) {
			closeChat();
			chatOpen = false;
			DirectionsGame d = new DirectionsGame(Main.stage);
			d.newGame();
			bg = new Background(Functions.getBg("street.png"));
			cur = "street";
			weekText.setFill(Color.WHITE);
			sp.setBackground(bg);
			library.setVisible(true);
			school.setVisible(true);
			street.setVisible(false);
		}
		if(e.getSource() == chatr) {
			if(chatOpen) {
				openChat();
			} else {
				closeChat();
			}
			chatOpen = !chatOpen;
		}
		if(e.getSource() == compr) {
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
				right = left.right;
				left = left.left;
				displayChat();
			} else {
				ROUND.put(cur, ROUND.get(cur)+1);
				cp.getChildren().remove(left);
				if(right != null) cp.getChildren().remove(right);
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
				cp.getChildren().remove(left);
				if(right != null) cp.getChildren().remove(right);
				left = right = null;
				picked = cur;
				displayChat();
			}
		}
	}
	
	private static void openChat() throws IOException {
		cp = new StackPane();
		cp.setAlignment(Pos.TOP_LEFT);
		cp.setTranslateX(160);
		cp.setTranslateY(20);
		cp.setMaxWidth(640);
		cp.setMaxHeight(400);
		sp.getChildren().add(cp);
		if(ROUND.get(cur) < 4) {
			left = MAP.get(cur)[ROUND.get(cur)][1];
			left.setTextAlignment(TextAlignment.CENTER);
		} else {
			displayChat();
			return;
		}
		chatImg.setImage(Functions.getImage(cur+"1.png", 640, 400));
		cp.getChildren().add(chatImg);
		displayChat();
	}
	
	private static void closeChat() {
		left = right = null;
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
					r.readLine();
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
		chatImg.setImage(Functions.getImage(cur+(right == null ? "1.png" : "2.png"), 640, 400));
		cp.getChildren().remove(rightB);
		cp.getChildren().remove(leftB);
		if(!picked.equals("")) {
			Text t = new Text("You already spoke with someone this week. Advance week to speak again.");
			t.setTranslateX(35);
			t.setTranslateY(310);
			t.setWrappingWidth(570);
			t.setTextAlignment(TextAlignment.CENTER);
			t.setId("textoption");
			t.setFont(Functions.getFont("Courier", 14));
			cp.getChildren().add(t);
			return;
		}
		if(ROUND.get(cur) == 4) {
			Text t = new Text("No more text options with this person.");
			t.setTranslateX(35);
			t.setTranslateY(310);
			t.setWrappingWidth(570);
			t.setTextAlignment(TextAlignment.CENTER);
			t.setId("textoption");
			t.setFont(Functions.getFont("Courier", 14));
			cp.getChildren().add(t);
			return;
		}
		left.setTranslateX(35);
		left.setTranslateY(310);
		left.setWrappingWidth(right == null ? 570 : 270);
		left.setId("textoption");
		left.setFill(Color.BLACK);
		left.setTextAlignment(TextAlignment.CENTER);
		left.setVisible(true);
		left.setFont(Functions.getFont("Courier", 12));
		leftB = new Button();
		rightB = new Button();
		leftB.setTranslateX(30);
		leftB.setTranslateY(300);
		leftB.setId("selectbutton");
		leftB.setPrefWidth(right == null ? 768-189 : 280);
		leftB.setPrefHeight(70);
		if(right != null) {
			right.setTranslateX(345);
			right.setTranslateY(310);
			right.setWrappingWidth(260);
			right.setFont(Functions.getFont("Courier", 12));
			right.prefHeight(50);
			right.setId("textoption");
			right.setTextAlignment(TextAlignment.CENTER);
			cp.getChildren().remove(rightB);
			rightB = new Button();
			rightB.setTranslateX(339);
			rightB.setTranslateY(300);
			rightB.setId("selectbutton");
			rightB.setPrefWidth(270);
			rightB.setPrefHeight(70);
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
		picked = "";
		if(week == 8) {
			Group r = new Group();
			ImageView i = new ImageView(Functions.getScene("win.png"));
			r.getChildren().add(i);
			Scene win = new Scene(r, Main.WIDTH, Main.HEIGHT);
			Functions.setScene(win, Color.BLACK);
			win.setOnKeyPressed((KeyEvent event) -> {
				if(event.getCode() == KeyCode.SPACE) {
					Main.mainMenu.run();
				}
			});
		} else {
			weekText.setText("Week " + week);
		}
	}
	
	private static void click() {
		sp.setOnMouseClicked((MouseEvent e) -> {
			System.out.println((int)e.getX() + " " + (int)e.getY());
		});
	}
	
	private static void newT(Group r, boolean wa) throws IOException {
		TextArea t = new TextArea();
		t.setPromptText("Enter a "+  LIB.length() + " digit card number");
		t.setTranslateX(165);
		t.setTranslateY(205);
		t.setPrefWidth(660);
		t.setPrefHeight(110);
		t.setId("libprompt");
		t.setFont(Functions.getFont("Courier", 30));
		r.getChildren().add(t);
		Text err = new Text("Invalid card number");
		if(wa) {
			r.getChildren().add(err);
			err.setFill(Color.RED);
			try {
				err.setFont(Functions.getFont("Courier", 16));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			err.setTranslateX(420);
			err.setTranslateY(300);
			
		}
		t.setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				if(t.getText().equals(LIB)) {
					closeChat();
					chatOpen = false;
					DirectionsGame d;
					try {
						d = new DirectionsGame(Main.stage);
						d.newGame();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					try {
						bg = new Background(Functions.getBg("library.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					cur = "library";
					weekText.setFill(Color.WHITE);
					sp.setBackground(bg);
					library.setVisible(false);
					school.setVisible(false);
					street.setVisible(true);
					r.getChildren().remove(t);
					r.getChildren().remove(err);
					return;
				}
				r.getChildren().remove(t);
				try {
					newT(r, true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(event.getCode() == KeyCode.ESCAPE) {
				try {
					bg = new Background(Functions.getBg("street.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				sp.setBackground(bg);
				library.setVisible(true);
				school.setVisible(true);
				street.setVisible(false);
				Functions.setScene(sc, Color.BLACK);
			}
		});
	}
	
}