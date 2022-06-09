package streetLife;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("rawtypes")
public class MainMenu implements EventHandler {

    /**TODO:
     * add and implement an instruction screen
     */
    private ImageView startIcon;
    private Button startB;
    private ImageView aboutIcon;
    private Button aboutB;
    private ImageView creditsIcon;
    private Button creditsB;
    private ImageView exitIcon;
    private Button exitB;
    private ImageView instructionsIcon;
    private Button instructionsB;
    private ImageView insBackIcon;
    private Button insBackB;
    
    private Image menuI;
    private Image back;
    private ImageView menuIV;
    private Image exitI;
    private ImageView exitIV;
    private Image creditsI;
    private ImageView creditsIV;
    private ImageView creditsBackIcon;
    private Button creditsBackB;
    private Image aboutI;
    private ImageView aboutIV;
    private ImageView aboutBackIcon;
    private Button aboutBackB;

    private Group menuG;
    private Scene menuS;
    private Text prompter;
    private FadeTransition prompterFade;
    private Group exitG;
    private Scene exitS;
    private Group creditsG;
    private Scene creditsS;
    private Group aboutG;
    private Scene aboutS;
    private Image instructionsI;
    private ImageView instructionsIV;
    private Group instructionsG;
    private Scene instructionsS;

    private Stage stage;
    Font prompterFont = Font.font("Courier New", FontWeight.BOLD, 16);
    
    DeficiencyRoom d;

    @SuppressWarnings("unchecked")
	public MainMenu(Stage stage) throws IOException{
        //stage init------------------------------------------------------------------
        this.stage = stage;
        d = new DeficiencyRoom(Main.stage);
        d.setScenes();
        //Button init-----------------------------------------------------------------
        startIcon = new ImageView(Functions.getScene("startbutton.png"));
        startIcon.setFitHeight(40);
        startIcon.setPreserveRatio(true);
        startB = new Button("", startIcon);
        startB.setOnAction(this);
        startB.setLayoutX(200);
        startB.setLayoutY(265);
        startB.setPrefWidth(startIcon.getFitWidth());
        startB.setMaxHeight(startIcon.getFitHeight());
        instructionsIcon = new ImageView(Functions.getScene("instructions.png"));
        instructionsIcon.setFitHeight(40);
        instructionsIcon.setPreserveRatio(true);
        instructionsB = new Button("", instructionsIcon);
        instructionsB.setOnAction(this);
        instructionsB.setLayoutX(200);
        instructionsB.setLayoutY(320);

        aboutIcon = new ImageView(Functions.getScene("about.png"));
        aboutIcon.setFitHeight(40);
        aboutIcon.setPreserveRatio(true);
        aboutB = new Button("", aboutIcon);
        aboutB.setOnAction(this);
        aboutB.setLayoutX(200);
        aboutB.setLayoutY(375);

        creditsIcon = new ImageView(Functions.getScene("credits.png"));
        creditsIcon.setFitHeight(40);
        creditsIcon.setPreserveRatio(true);
        creditsB = new Button("", creditsIcon);
        creditsB.setOnAction(this);
        creditsB.setLayoutX(200);
        creditsB.setLayoutY(430);

        exitIcon = new ImageView(Functions.getScene("exit.png"));
        exitIcon.setFitHeight(40);
        exitIcon.setPreserveRatio(true);
        exitB = new Button("", exitIcon);
        exitB.setOnAction(this);
        exitB.setLayoutX(790);
        exitB.setLayoutY(475);

        //main menu scene init------------------------------------------------------------------
        menuI = Functions.getScene("mainMenuScreen.png");
        menuIV = new ImageView(menuI);
        menuIV.setFitWidth(960);
        menuIV.setFitHeight(540);
        back = Functions.getScene("back.png");

        menuG = new Group();
        menuG.getChildren().add(menuIV);
        menuG.getChildren().add(startB);
        menuG.getChildren().add(instructionsB);
        menuG.getChildren().add(aboutB);
        menuG.getChildren().add(creditsB);
        menuG.getChildren().add(exitB);

        menuS = new Scene(menuG, 960, 540);
        menuS.getStylesheets().add("style.css");
        //credits screen init----------------------------------------------------------
        creditsI = Functions.getScene("creditsScreen.png");
        creditsIV = new ImageView(creditsI);
        creditsIV.setFitWidth(960);
        creditsIV.setFitHeight(540);

        creditsBackIcon = new ImageView(back);
        creditsBackIcon.setFitHeight(40);
        creditsBackIcon.setPreserveRatio(true);
        creditsBackB = new Button("", creditsBackIcon);
        creditsBackB.setOnAction(this);
        creditsBackB.setLayoutX(790);
        creditsBackB.setLayoutY(475);

        creditsG = new Group();
        creditsG.getChildren().add(creditsIV);
        creditsG.getChildren().add(creditsBackB);
        creditsS = new Scene(creditsG, 960, 540);
        creditsS.getStylesheets().add("style.css");
        //about screen init------------------------------------------------------------
        aboutI = Functions.getScene("aboutScreen.png");
        aboutIV = new ImageView(aboutI);
        aboutIV.setFitWidth(960);
        aboutIV.setFitHeight(540);

        aboutBackIcon = new ImageView(back);
        aboutBackIcon.setFitHeight(40);
        aboutBackIcon.setPreserveRatio(true);
        aboutBackB = new Button("", aboutBackIcon);
        aboutBackB.setOnAction(this);
        aboutBackB.setLayoutX(790);
        aboutBackB.setLayoutY(475);

        aboutG = new Group();
        aboutG.getChildren().add(aboutIV);
        aboutG.getChildren().add(aboutBackB);
        aboutS = new Scene(aboutG, 960, 540);
        aboutS.getStylesheets().add("style.css");
        //exit screen init-------------------------------------------------------------
        exitI = Functions.getScene("exitScreen.png");
        exitIV = new ImageView(exitI);
        exitIV.setFitWidth(960);
        exitIV.setFitHeight(540);

        prompter = new Text(105,190,"Press any key to continue...");
        prompter.setFill(Color.WHITE);
        prompter.setFont(prompterFont);
        prompter.setVisible(false);

        prompterFade = new FadeTransition(Duration.seconds(1),prompter);
        prompterFade.setFromValue(1);
        prompterFade.setToValue(0);
        prompterFade.setAutoReverse(true);
        prompterFade.setCycleCount(Timeline.INDEFINITE);
        instructionsI = Functions.getScene("instructionsScreen.png");
        instructionsIV = new ImageView(instructionsI);
        instructionsIV.setFitWidth(960);
        instructionsIV.setPreserveRatio(true);
        insBackIcon = new ImageView(back);
        insBackIcon.setFitHeight(40);
        insBackIcon.setPreserveRatio(true);
        insBackB = new Button("", insBackIcon);
        insBackB.setOnAction(this);
        insBackB.setLayoutX(790);
        insBackB.setLayoutY(475);
        instructionsG = new Group();
        instructionsG.getChildren().add(instructionsIV);
        instructionsG.getChildren().add(prompter);
        instructionsG.getChildren().add(insBackB);
        instructionsS = new Scene(instructionsG, 960, 540);
        instructionsS.getStylesheets().add("style.css");
        exitG = new Group();
        exitG.getChildren().add(exitIV);
        exitG.getChildren().add(prompter);
        exitS = new Scene(exitG,  960, 540);
        exitS.getStylesheets().add("style.css");
    }

    public void run(){
        //display All Menu Items-------------------------------------------------------
        stage.setScene(menuS);
    }

    @Override
    public void handle(Event event) {

        if(event.getSource() == aboutBackB || event.getSource() == creditsBackB || event.getSource() == insBackB){
            stage.setScene(menuS);
        }

        if(event.getSource()==startB){
            //testing the button's functionality
            try {
				d.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

        if(event.getSource()==instructionsB){
            //testing the button's functionality
            //switches a boolean value, switching to the instructions screen
        	stage.setScene(instructionsS);
        }

        if(event.getSource()==aboutB){
            //testing the button's functionality
            //switches a boolean value, switching to the about screen
            stage.setScene(aboutS);
        }

        if(event.getSource()==creditsB){
            //testing the button's functionality
            //switches a boolean value, switching to the credits screen
            stage.setScene(creditsS);
        }

        if(event.getSource()==exitB){
            //testing the button's functionality
            //exits the game
            stage.setScene(exitS);
            prompter.setVisible(true);
            prompterFade.play();
            exitS.setOnKeyPressed(evt -> {
                System.exit(0);
            });

        }
    }
}
