/**
 * The main menu directs the player into the game.
 * The player can also choose the instructions, credits, about the game, and to exit the game.
 *
 * @author Max Sun
 * @author Zoe Fan-Chiang
 * @author Derek Ma
 * @version 3.0
 * @since 2022-06-10
 */

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
    //button declaration
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

    //backgrounds declaration
    private Image menuI;
    private Image back;
    private ImageView menuIV;
    private Image exitI;
    private ImageView exitIV;
    private Image creditsI;
    private ImageView creditsIV;

    //back button declaration
    private ImageView creditsBackIcon;
    private Button creditsBackB;
    private Image aboutI;
    private ImageView aboutIV;
    private ImageView aboutBackIcon;
    private Button aboutBackB;

    //group and scene declaration
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

    //class constructor
    @SuppressWarnings("unchecked")
	public MainMenu(Stage stage) throws IOException{
        //stage init------------------------------------------------------------------
        this.stage = stage;
        d = new DeficiencyRoom(Main.stage);
        d.setScenes();
        //Button init-----------------------------------------------------------------
            //start button init
        startIcon = new ImageView(Functions.getScene("startbutton.png"));
        startIcon.setFitHeight(40);
        startIcon.setPreserveRatio(true);
        startB = new Button("", startIcon);
        startB.setOnAction(this);
        startB.setLayoutX(200);
        startB.setLayoutY(265);
        startB.setPrefWidth(startIcon.getFitWidth());
        startB.setMaxHeight(startIcon.getFitHeight());

            //instructions button init
        instructionsIcon = new ImageView(Functions.getScene("instructions.png"));
        instructionsIcon.setFitHeight(40);
        instructionsIcon.setPreserveRatio(true);
        instructionsB = new Button("", instructionsIcon);
        instructionsB.setOnAction(this);
        instructionsB.setLayoutX(200);
        instructionsB.setLayoutY(320);

            //about button init
        aboutIcon = new ImageView(Functions.getScene("about.png"));
        aboutIcon.setFitHeight(40);
        aboutIcon.setPreserveRatio(true);
        aboutB = new Button("", aboutIcon);
        aboutB.setOnAction(this);
        aboutB.setLayoutX(200);
        aboutB.setLayoutY(375);

            //credits button init
        creditsIcon = new ImageView(Functions.getScene("credits.png"));
        creditsIcon.setFitHeight(40);
        creditsIcon.setPreserveRatio(true);
        creditsB = new Button("", creditsIcon);
        creditsB.setOnAction(this);
        creditsB.setLayoutX(200);
        creditsB.setLayoutY(430);

            //exit button init
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

        //adds all buttons to the main menu group as well as the background image
        menuG = new Group();
        menuG.getChildren().add(menuIV);
        menuG.getChildren().add(startB);
        menuG.getChildren().add(instructionsB);
        menuG.getChildren().add(aboutB);
        menuG.getChildren().add(creditsB);
        menuG.getChildren().add(exitB);

        menuS = new Scene(menuG, 960, 540);
        menuS.getStylesheets().add("style.css");

        //instructions screen init------------------------------------------------------------
        //instructions background init
        instructionsI = Functions.getScene("instructionsScreen.png");
        instructionsIV = new ImageView(instructionsI);
        instructionsIV.setFitWidth(960);
        instructionsIV.setPreserveRatio(true);

        //instructions back button init
        insBackIcon = new ImageView(back);
        insBackIcon.setFitHeight(40);
        insBackIcon.setPreserveRatio(true);
        insBackB = new Button("", insBackIcon);
        insBackB.setOnAction(this);
        insBackB.setLayoutX(790);
        insBackB.setLayoutY(475);

        //adds all buttons to the instructions group as well as the background image
        instructionsG = new Group();
        instructionsG.getChildren().add(instructionsIV);
        instructionsG.getChildren().add(prompter);
        instructionsG.getChildren().add(insBackB);

        instructionsS = new Scene(instructionsG, 960, 540);
        instructionsS.getStylesheets().add("style.css");

        //credits screen init----------------------------------------------------------
            //credits background init
        creditsI = Functions.getScene("creditsScreen.png");
        creditsIV = new ImageView(creditsI);
        creditsIV.setFitWidth(960);
        creditsIV.setFitHeight(540);

            //credits back button init
        creditsBackIcon = new ImageView(back);
        creditsBackIcon.setFitHeight(40);
        creditsBackIcon.setPreserveRatio(true);
        creditsBackB = new Button("", creditsBackIcon);
        creditsBackB.setOnAction(this);
        creditsBackB.setLayoutX(790);
        creditsBackB.setLayoutY(475);

            //adds all buttons to the credits group as well as the background image
        creditsG = new Group();
        creditsG.getChildren().add(creditsIV);
        creditsG.getChildren().add(creditsBackB);

        creditsS = new Scene(creditsG, 960, 540);
        creditsS.getStylesheets().add("style.css");

        //about screen init------------------------------------------------------------
            //about background init
        aboutI = Functions.getScene("aboutScreen.png");
        aboutIV = new ImageView(aboutI);
        aboutIV.setFitWidth(960);
        aboutIV.setFitHeight(540);

            //about back button init
        aboutBackIcon = new ImageView(back);
        aboutBackIcon.setFitHeight(40);
        aboutBackIcon.setPreserveRatio(true);
        aboutBackB = new Button("", aboutBackIcon);
        aboutBackB.setOnAction(this);
        aboutBackB.setLayoutX(790);
        aboutBackB.setLayoutY(475);

            //adds all buttons to the about group as well as the background image
        aboutG = new Group();
        aboutG.getChildren().add(aboutIV);
        aboutG.getChildren().add(aboutBackB);

        aboutS = new Scene(aboutG, 960, 540);
        aboutS.getStylesheets().add("style.css");

        //exit screen init-------------------------------------------------------------
            //exit background init
        exitI = Functions.getScene("exitScreen.png");
        exitIV = new ImageView(exitI);
        exitIV.setFitWidth(960);
        exitIV.setFitHeight(540);

            //exit back button init
        prompter = new Text(105,190,"Press any key to continue...");
        prompter.setFill(Color.WHITE);
        prompter.setFont(prompterFont);
        prompter.setVisible(false);

            //prompter animation
        prompterFade = new FadeTransition(Duration.seconds(1),prompter);
        prompterFade.setFromValue(1);
        prompterFade.setToValue(0);
        prompterFade.setAutoReverse(true);
        prompterFade.setCycleCount(Timeline.INDEFINITE);

            //adding all buttons to the exit group as well as the background image
        exitG = new Group();
        exitG.getChildren().add(exitIV);
        exitG.getChildren().add(prompter);
        exitS = new Scene(exitG,  960, 540);
        exitS.getStylesheets().add("style.css");
    }

    //runs all Menu Items-------------------------------------------------------
    public void run(){
        stage.setScene(menuS);
    }


    //handle method which handles all button clicks------------------------------------
    @Override
    public void handle(Event event) {

        //back button pressed-------------------------------------------------------
        if(event.getSource() == aboutBackB || event.getSource() == creditsBackB || event.getSource() == insBackB){
            //set the scene to the main menu
            stage.setScene(menuS);
        }

        //start button pressed-------------------------------------------------------
        if(event.getSource()==startB){
            //starts the Deficiency Room game
            try {
				d.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

        //instructions button pressed-------------------------------------------------------
        if(event.getSource()==instructionsB){
            //switches to the instructions screen
        	stage.setScene(instructionsS);
        }

        //about button pressed-------------------------------------------------------
        if(event.getSource()==aboutB){
            //switches to the about screen
            stage.setScene(aboutS);
        }

        //credits button pressed-------------------------------------------------------
        if(event.getSource()==creditsB){
            //switches to the credits screen
            stage.setScene(creditsS);
        }

        //exit button pressed-------------------------------------------------------
        if(event.getSource()==exitB){
            //sends game to the exit screen
            stage.setScene(exitS);
            //displays flashing prompter to let user know they are exiting the game
            prompter.setVisible(true);
            prompterFade.play();
            //on key press, closes the program
            exitS.setOnKeyPressed(evt -> {
                System.exit(0);
            });
        }
    }
}
