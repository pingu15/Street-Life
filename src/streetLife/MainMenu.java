package streetLife;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
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

import java.util.concurrent.TimeUnit;

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

    //background declarations
    private Image menuI;
    private ImageView menuIV;
    private Image back;
    //exit screen
    private Image exitI;
    private ImageView exitIV;
    //credits screen
    private Image creditsI;
    private ImageView creditsIV;
    private ImageView creditsBackIcon;
    private Button creditsBackB;
    //about screen
    private Image aboutI;
    private ImageView aboutIV;
    private ImageView aboutBackIcon;
    private Button aboutBackB;
    //instructions screen
    private Image instructionsI;
    private ImageView instructionsIV;
    private ImageView instructionsBackIcon;
    private Button instructionsBackB;

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
    private Group instructionsG;
    private Scene instructionsS;

    private Stage stage;
    Font prompterFont = Font.font("Courier New", FontWeight.BOLD, 16);

    public MainMenu(Stage stage){
        //stage init------------------------------------------------------------------
        this.stage = stage;

        //Button init-----------------------------------------------------------------
        startIcon = new ImageView(new Image("Scenes/start.png"));
        startIcon.setFitHeight(40);
        startIcon.setPreserveRatio(true);
        startB = new Button("", startIcon);
        startB.setOnAction(this);
        startB.setLayoutX(200);
        startB.setLayoutY(220);

        instructionsIcon = new ImageView(new Image("Scenes/instructions.png"));
        instructionsIcon.setFitHeight(40);
        instructionsIcon.setPreserveRatio(true);
        instructionsB = new Button("", instructionsIcon);
        instructionsB.setOnAction(this);
        instructionsB.setLayoutX(200);
        instructionsB.setLayoutY(280);

        aboutIcon = new ImageView(new Image("Scenes/about.png"));
        aboutIcon.setFitHeight(40);
        aboutIcon.setPreserveRatio(true);
        aboutB = new Button("", aboutIcon);
        aboutB.setOnAction(this);
        aboutB.setLayoutX(200);
        aboutB.setLayoutY(340);

        creditsIcon = new ImageView(new Image("Scenes/credits.png"));
        creditsIcon.setFitHeight(40);
        creditsIcon.setPreserveRatio(true);
        creditsB = new Button("", creditsIcon);
        creditsB.setOnAction(this);
        creditsB.setLayoutX(200);
        creditsB.setLayoutY(400);

        exitIcon = new ImageView(new Image("Scenes/exit.png"));
        exitIcon.setFitHeight(40);
        exitIcon.setPreserveRatio(true);
        exitB = new Button("", exitIcon);
        exitB.setOnAction(this);
        exitB.setLayoutX(200);
        exitB.setLayoutY(460);

        //main menu scene init------------------------------------------------------------------
        menuI = new Image("Scenes/mainMenuScreen.png");
        menuIV = new ImageView(menuI);
        menuIV.setFitWidth(960);
        menuIV.setPreserveRatio(true);
        back = new Image("Scenes/back.png");

        menuG = new Group();
        menuG.getChildren().add(menuIV);
        menuG.getChildren().add(startB);
        menuG.getChildren().add(instructionsB);
        menuG.getChildren().add(aboutB);
        menuG.getChildren().add(creditsB);
        menuG.getChildren().add(exitB);

        menuS = new Scene(menuG, 960, 540);

        //instructions screen init-----------------------------------------------------
        instructionsI = new Image("Scenes/instructionsScreen.png");
        instructionsIV = new ImageView(instructionsI);
        instructionsIV.setFitWidth(960);
        instructionsIV.setPreserveRatio(true);

        instructionsBackIcon = new ImageView(back);
        instructionsBackIcon.setFitHeight(40);
        instructionsBackIcon.setPreserveRatio(true);
        instructionsBackB = new Button("", instructionsBackIcon);
        instructionsBackB.setOnAction(this);
        instructionsBackB.setLayoutX(50);
        instructionsBackB.setLayoutY(50);

        instructionsG = new Group();
        instructionsG.getChildren().add(instructionsIV);
        instructionsG.getChildren().add(instructionsBackB);
        instructionsS = new Scene(instructionsG, 960, 540);

        //credits screen init----------------------------------------------------------
        creditsI = new Image("Scenes/creditsScreen.png");
        creditsIV = new ImageView(creditsI);
        creditsIV.setFitWidth(960);
        creditsIV.setPreserveRatio(true);

        creditsBackIcon = new ImageView(back);
        creditsBackIcon.setFitHeight(40);
        creditsBackIcon.setPreserveRatio(true);
        creditsBackB = new Button("", creditsBackIcon);
        creditsBackB.setOnAction(this);
        creditsBackB.setLayoutX(50);
        creditsBackB.setLayoutY(50);

        creditsG = new Group();
        creditsG.getChildren().add(creditsIV);
        creditsG.getChildren().add(creditsBackB);
        creditsS = new Scene(creditsG, 960, 540);

        //about screen init------------------------------------------------------------
        aboutI = new Image("Scenes/aboutScreen.png");
        aboutIV = new ImageView(aboutI);
        aboutIV.setFitWidth(960);
        aboutIV.setPreserveRatio(true);

        aboutBackIcon = new ImageView(back);
        aboutBackIcon.setFitHeight(40);
        aboutBackIcon.setPreserveRatio(true);
        aboutBackB = new Button("", aboutBackIcon);
        aboutBackB.setOnAction(this);
        aboutBackB.setLayoutX(50);
        aboutBackB.setLayoutY(50);

        aboutG = new Group();
        aboutG.getChildren().add(aboutIV);
        aboutG.getChildren().add(aboutBackB);
        aboutS = new Scene(aboutG, 960, 540);

        //exit screen init-------------------------------------------------------------
        exitI = new Image("Scenes/exitScreen.png");
        exitIV = new ImageView(exitI);
        exitIV.setFitWidth(960);
        exitIV.setPreserveRatio(true);

        prompter = new Text(600,290,"Press any key to continue...");
        prompter.setFill(Color.WHITE);
        prompter.setFont(prompterFont);
        prompter.setVisible(false);

        prompterFade = new FadeTransition(Duration.seconds(1),prompter);
        prompterFade.setFromValue(1);
        prompterFade.setToValue(0);
        prompterFade.setAutoReverse(true);
        prompterFade.setCycleCount(Timeline.INDEFINITE);

        exitG = new Group();
        exitG.getChildren().add(exitIV);
        exitG.getChildren().add(prompter);
        exitS = new Scene(exitG,  960, 540);
    }

    public void run(){
        //display All Menu Items-------------------------------------------------------
        stage.setScene(menuS);
    }

    @Override
    public void handle(Event event) {

        if(event.getSource() == aboutBackB || event.getSource() == creditsBackB || event.getSource() == instructionsBackB){
            System.out.println("back button works");
            stage.setScene(menuS);
        }

        if(event.getSource()==startB){
            //testing the button's functionality
            System.out.println("start button works");
            //switches a boolean value, starting to run the game
        }

        if(event.getSource()==instructionsB){
            //testing the button's functionality
            System.out.println("instructions button works");
            //switches a boolean value, switching to the instructions screen
            stage.setScene(instructionsS);

        }

        if(event.getSource()==aboutB){
            //testing the button's functionality
            System.out.println("about button works");
            //switches a boolean value, switching to the about screen
            stage.setScene(aboutS);
        }

        if(event.getSource()==creditsB){
            //testing the button's functionality
            System.out.println("credits button works");
            //switches a boolean value, switching to the credits screen
            stage.setScene(creditsS);
        }

        if(event.getSource()==exitB){
            //testing the button's functionality
            System.out.println("exit button works");
            //exits the game
            stage.setScene(exitS);
            prompter.setVisible(true);
            prompterFade.play();
            exitS.setOnKeyPressed(evt -> {
                System.out.println("key pressed");
                System.exit(0);
            });

        }
    }
}
