/**
 * The DirectionsGame is a minigame found in the EscapeRoom, which would be run in intervals.
 *
 * @author Max Sun
 * @author Zoe Fan-Chiang
 * @author Derek Ma
 * @version 3.0
 * @since 2022-06-06
 */

package streetLife;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class DirectionsGame implements EventHandler {

    //button and usages declarations------------------------------------------------------------------------------------
    private Button button1;
    private boolean b1Pressed;
    private Button button2;
    private boolean b2Pressed;
    private Button button3;
    private boolean b3Pressed;
    private Button button4;
    private boolean b4Pressed;
    private Button button5;
    private boolean b5Pressed;
    private Button button6;
    private boolean b6Pressed;
    private boolean buttonTrue;

    //6 ImageView declarations
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    private FadeTransition b1Fade;
    private FadeTransition b2Fade;
    private FadeTransition b3Fade;
    private FadeTransition b4Fade;
    private FadeTransition b5Fade;
    private FadeTransition b6Fade;

    private Text losePrompter;
    private FadeTransition losePrompterFade;
    private Text winPrompter;
    private FadeTransition winPrompterFade;
    private Text startPrompter;
    private FadeTransition startPrompterFade;

    private ImageView map;

    //potential locations of buttons------------------------------------------------------------------------------------
    private int[] buttonX;
    private int[] buttonY;

    private int orderCounter;
    private ArrayList<Integer> usedXValues;
    private ArrayList<Integer> usedYValues;

    Group directionsGameG;
    Scene directionsGameS;

    ImageView winIV;
    ImageView loseIV;
    ImageView startIV;
    Group winG;
    Scene winS;
    Group loseG;
    Scene loseS;
    Group startG;
    Scene startS;


    Stage stage;

    /**
     * initializes a new Directions minigame with a new set of buttons
     *
     * @author Derek Ma
     * @version 2.0
     * @since 2022-05-30
     * @param stage the stage that everything is put on
     */
    public DirectionsGame(Stage stage) throws IOException {
        //stage and utility variables init------------------------------------------------------------------------------
        this.stage = stage;
        buttonX = new int[]{50, 90, 130, 170, 210, 250, 290, 330, 370, 410, 450, 490, 530, 570, 610, 650, 690, 730};
        buttonY = new int[]{50, 90, 130, 170, 210, 250, 290, 330, 370};
        usedXValues = new ArrayList<Integer>();
        usedYValues = new ArrayList<Integer>();
        orderCounter = 0;

        //initialize map ImageView-----------------------------------------------------------------------------------
        map = new ImageView(Functions.getScene("map.png"));
        map.setFitWidth(960);
        map.setPreserveRatio(true);

        //initialize 6 ImageViews--------------------------------------------------------------------------------------
        imageView1 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView1.setFitWidth(25);
        imageView1.setPreserveRatio(true);
        imageView2 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView2.setFitWidth(25);
        imageView2.setPreserveRatio(true);
        imageView3 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView3.setFitWidth(25);
        imageView3.setPreserveRatio(true);
        imageView4 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView4.setFitWidth(25);
        imageView4.setPreserveRatio(true);
        imageView5 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView5.setFitWidth(25);
        imageView5.setPreserveRatio(true);
        imageView6 = new ImageView(Functions.getScene("mapIcon.png"));
        imageView6.setFitWidth(25);
        imageView6.setPreserveRatio(true);

        //Buttons and their respective variables init-------------------------------------------------------------------
        button1 = new Button("", imageView1);
        button2 = new Button("", imageView2);
        button3 = new Button("", imageView3);
        button4 = new Button("", imageView4);
        button5 = new Button("", imageView5);
        button6 = new Button("", imageView6);

        b1Pressed = false;
        b2Pressed = false;
        b3Pressed = false;
        b4Pressed = false;
        b5Pressed = false;
        b6Pressed = false;

        //animation for button fade ins---------------------------------------------------------------------------------

        b1Fade = new FadeTransition(Duration.seconds(0.5), button1);
        b1Fade.setFromValue(0);
        b1Fade.setToValue(1);

        b2Fade = new FadeTransition(Duration.seconds(0.5), button2);
        b2Fade.setFromValue(0);
        b2Fade.setToValue(1);

        b3Fade = new FadeTransition(Duration.seconds(0.5), button3);
        b3Fade.setFromValue(0);
        b3Fade.setToValue(1);

        b4Fade = new FadeTransition(Duration.seconds(0.5), button4);
        b4Fade.setFromValue(0);
        b4Fade.setToValue(1);

        b5Fade = new FadeTransition(Duration.seconds(0.5), button5);
        b5Fade.setFromValue(0);
        b5Fade.setToValue(1);

        b6Fade = new FadeTransition(Duration.seconds(0.5), button6);
        b6Fade.setFromValue(0);
        b6Fade.setToValue(1);

        b1Fade.setOnFinished(
                event -> {
                    button2.setVisible(true);
                    b2Fade.play();
                }
        );
        b2Fade.setOnFinished(
                event -> {
                    button3.setVisible(true);
                    b3Fade.play();
                }
        );
        b3Fade.setOnFinished(
                event -> {
                    button4.setVisible(true);
                    b4Fade.play();
                }
        );
        b4Fade.setOnFinished(
                event -> {
                    button5.setVisible(true);
                    b5Fade.play();
                }
        );
        b5Fade.setOnFinished(
                event -> {
                    button6.setVisible(true);
                    b6Fade.play();
                }
        );
        b6Fade.setOnFinished(
                event -> {
                    button1.setOnAction(this);
                    button2.setOnAction(this);
                    button3.setOnAction(this);
                    button4.setOnAction(this);
                    button5.setOnAction(this);
                    button6.setOnAction(this);
                }
        );

        //flashing lose prompter---------------------------------------------------------------------------------------------
        losePrompter = new Text(650,480,"Press any key to continue...");
        losePrompter.setFill(Color.WHITE);
        losePrompter.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        losePrompter.setVisible(false);

        //lose prompter blink animation-------------------------------------------------------
        losePrompterFade = new FadeTransition(Duration.seconds(1), losePrompter);
        losePrompterFade.setFromValue(1);
        losePrompterFade.setToValue(0);
        losePrompterFade.setAutoReverse(true);
        losePrompterFade.setCycleCount(Timeline.INDEFINITE);

        //flashing win prompter---------------------------------------------------------------------------------------------
        winPrompter = new Text(650,480,"Press any key to continue...");
        winPrompter.setFill(Color.WHITE);
        winPrompter.setFont(Font.font("Courier New", FontWeight.BOLD, 16));

        //win prompter blink animation---------------------------------------------------------------------------------------------

        winPrompterFade = new FadeTransition(Duration.seconds(1), winPrompter);
        winPrompterFade.setFromValue(1);
        winPrompterFade.setToValue(0);
        winPrompterFade.setAutoReverse(true);
        winPrompterFade.setCycleCount(Timeline.INDEFINITE);
        winPrompterFade.play();

        //flashing start prompter---------------------------------------------------------------------------------------------
        startPrompter = new Text(650,480,"Press any key to continue...");
        startPrompter.setFill(Color.WHITE);
        startPrompter.setFont(Font.font("Courier New", FontWeight.BOLD, 16));

        //start prompter blink animation---------------------------------------------------------------------------------------------
        startPrompterFade = new FadeTransition(Duration.seconds(1), startPrompter);
        startPrompterFade.setFromValue(1);
        startPrompterFade.setToValue(0);
        startPrompterFade.setAutoReverse(true);
        startPrompterFade.setCycleCount(Timeline.INDEFINITE);
        startPrompterFade.play();

        //adding nodes to the game scene-----------------------------------------------------------------------------------
        directionsGameG = new Group();
        directionsGameG.getChildren().add(map);
        directionsGameG.getChildren().add(button2);
        directionsGameG.getChildren().add(button1);
        directionsGameG.getChildren().add(button5);
        directionsGameG.getChildren().add(button6);
        directionsGameG.getChildren().add(button4);
        directionsGameG.getChildren().add(button3);

        directionsGameS = new Scene(directionsGameG, 960, 540);

        //initialize win and lose scene--------------------------------------------------------------------------------
        winIV = new ImageView(Functions.getScene("directionsGameWin.png"));
        winIV.setFitWidth(960);
        winIV.setPreserveRatio(true);
        loseIV = new ImageView(Functions.getScene("directionsGameLose.png"));
        loseIV.setFitWidth(960);
        loseIV.setPreserveRatio(true);
        startIV = new ImageView(Functions.getScene("directionsInstructions.png"));
        startIV.setFitWidth(960);
        startIV.setPreserveRatio(true);

        winG = new Group();
        winG.getChildren().add(winIV);
        winS = new Scene(winG, 960, 540);

        loseG = new Group();
        loseG.getChildren().add(loseIV);
        loseS = new Scene(loseG, 960, 540);

        startG = new Group();
        startG.getChildren().add(startIV);
        startS = new Scene(startG, 960, 540);

        //adding buttons to the end scene-----------------------------------------------------------------------------------
        loseG.getChildren().add(losePrompter);
        winG.getChildren().add(winPrompter);
        startG.getChildren().add(startPrompter);

    }

    /**
     * initializes a new Directions minigame with a new set of buttons
     *
     * @author Derek Ma
     * @version 3.0
     * @since 2022-06-03
     */
    public void newGame(){
        this.setUpButton(button1);
        this.setUpButton(button2);
        this.setUpButton(button3);
        this.setUpButton(button4);
        this.setUpButton(button5);
        this.setUpButton(button6);

        stage.setScene(startS);
        startS.setOnKeyPressed(
                event -> {
                    this.run();
                }
        );
    }

    /**
     * runs the directions minigame
     * resets all variables and states to their starting value
     * resets the buttons and restarts the game
     * called in newGame and handleResult
     *
     * @author Derek Ma
     * @version 4.0
     * @since 2022-06-01
     */
    public void run(){
        stage.setScene(directionsGameS);
        button1.setOnAction(null);
        button2.setOnAction(null);
        button3.setOnAction(null);
        button4.setOnAction(null);
        button5.setOnAction(null);
        button6.setOnAction(null);

        orderCounter = 0;
        buttonTrue = true;
        b1Pressed = false;
        b2Pressed = false;
        b3Pressed = false;
        b4Pressed = false;
        b5Pressed = false;
        b6Pressed = false;

        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        button5.setVisible(false);
        button6.setVisible(false);
        losePrompter.setVisible(false);

        button1.setVisible(true);
        b1Fade.play();

        stage.setScene(directionsGameS);
    }

    /**
     * helper method to set up buttons
     * includes randomly positioning the button
     * sets the size of the button
     *
     * @author Derek Ma
     * @version 1.0
     * @since 2022-06-01
     * @param b the button passed to be set up
     */
    private void setUpButton(Button b){
        int randomX;
        int randomY;
        boolean repeats;
        while(true) {
            randomX = (int) (Math.random()*18);
            randomY = (int) (Math.random()*9);
            repeats = false;
            //checks if the x - y combination repeat or not
            for (int usedX : usedXValues) {
                if (randomX == usedX) {
                    for (int usedY : usedYValues) {
                        if (randomY == usedY) {
                            repeats = true;
                        }
                    }
                }
            }

            if (!repeats) {
                usedXValues.add(randomX);
                usedYValues.add(randomY);
                break;
            }
        }

        b.setMinWidth(30);
        b.setMinHeight(30);
        b.setLayoutX(buttonX[randomX]);
        b.setLayoutY(buttonY[randomY]);
    }

    /**
     * handles the result of each round of the game
     * if the win condition is met, the game is won
     * if the win condition is not met, the game is lost
     *
     * @author Derek Ma
     * @version 1.0
     * @since 2022-06-08
     */
    private void handleResult(){
        if(buttonTrue){
            //what happens when the buttons are pressed in the correct order
            System.out.println("correct");
            stage.setScene(winS);
            directionsGameS.setOnKeyPressed(
                    event -> {
                        //proceed
                    }
            );

        } else {
            //what happens when the buttons are pressed in the incorrect order
            System.out.println("incorrect");
            losePrompter.setVisible(true);
            losePrompterFade.play();
            stage.setScene(loseS);
            loseS.setOnKeyPressed(
                    event-> {
                        this.run();
                    }
            );
        }
    }


    /**
     * handles all button events
     * handles whether the button's order pressed is correct to meet the win condition
     * makes each button disappear upon being pressed
     *
     * @author Derek Ma
     * @version 3.0
     * @since 2022-06-06
     * @param event the button press event to handle
     */
    @Override
    public void handle(Event event) {
        if(event.getSource() == button1){
            b1Pressed = true;
            orderCounter++;
            if(orderCounter != 1){
                buttonTrue = false;
            }
            button1.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }

        if(event.getSource() == button2){
            b2Pressed = true;
            orderCounter++;
            if(orderCounter != 2){
                buttonTrue = false;
            }
            button2.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }

        if(event.getSource() == button3){
            b3Pressed = true;
            orderCounter++;
            if(orderCounter != 3){
                buttonTrue = false;
            }
            button3.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }

        if(event.getSource() == button4){
            b4Pressed = true;
            orderCounter++;
            if(orderCounter != 4){
                buttonTrue = false;
            }
            button4.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }

        if(event.getSource() == button5){
            b5Pressed = true;
            orderCounter++;
            if(orderCounter != 5){
                buttonTrue = false;
            }
            button5.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }

        if(event.getSource() == button6){
            b6Pressed = true;
            orderCounter++;
            if(orderCounter != 6){
                buttonTrue = false;
            }
            button6.setVisible(false);
            if(b1Pressed && b2Pressed && b3Pressed && b4Pressed && b5Pressed && b6Pressed){
                handleResult();
            }
        }
    }
}