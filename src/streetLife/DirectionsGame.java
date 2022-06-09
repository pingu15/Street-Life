package streetLife;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    private FadeTransition b1Fade;
    private FadeTransition b2Fade;
    private FadeTransition b3Fade;
    private FadeTransition b4Fade;
    private FadeTransition b5Fade;
    private FadeTransition b6Fade;

    private Text prompter;
    private FadeTransition prompterFade;

    //potential locations of buttons------------------------------------------------------------------------------------
    private int[] buttonX;
    private int[] buttonY;

    private int orderCounter;
    private ArrayList<Integer> usedXValues;
    private ArrayList<Integer> usedYValues;

    Group directionsGameG;
    Scene directionsGameS;

    Stage stage;

    public DirectionsGame(Stage stage){
        //stage and utility variables init------------------------------------------------------------------------------
        this.stage = stage;
        buttonX = new int[]{50, 90, 130, 170, 210, 250, 290, 330, 370, 410, 450, 490, 530, 570, 610, 650, 690, 730, 770, 810};
        buttonY = new int[]{50, 90, 130, 170, 210, 250, 290, 330, 370, 410, 450};
        usedXValues = new ArrayList<Integer>();
        usedYValues = new ArrayList<Integer>();
        orderCounter = 0;


        //Buttons and their respective variables init-------------------------------------------------------------------
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();

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

        //flashing prompter---------------------------------------------------------------------------------------------
        prompter = new Text(650,480,"Press any key to continue...");
        prompter.setFill(Color.BLACK);
        prompter.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        prompter.setVisible(false);

        //prompter blink animation-------------------------------------------------------
        prompterFade = new FadeTransition(Duration.seconds(1),prompter);
        prompterFade.setFromValue(1);
        prompterFade.setToValue(0);
        prompterFade.setAutoReverse(true);
        prompterFade.setCycleCount(Timeline.INDEFINITE);

        //adding buttons to the scene-----------------------------------------------------------------------------------
        directionsGameG = new Group();
        directionsGameG.getChildren().add(button2);
        directionsGameG.getChildren().add(button1);
        directionsGameG.getChildren().add(button5);
        directionsGameG.getChildren().add(button6);
        directionsGameG.getChildren().add(button4);
        directionsGameG.getChildren().add(button3);
        directionsGameG.getChildren().add(prompter);

        directionsGameS = new Scene(directionsGameG, 960, 540);
    }

    public void newGame(){
        this.setUpButton(button1);
        this.setUpButton(button2);
        this.setUpButton(button3);
        this.setUpButton(button4);
        this.setUpButton(button5);
        this.setUpButton(button6);

        this.run();
    }

    public void run(){
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
        prompter.setVisible(false);

        button1.setVisible(true);
        b1Fade.play();

        stage.setScene(directionsGameS);
    }

    private void setUpButton(Button b){
        int randomX;
        int randomY;
        boolean repeats;
        while(true) {
            randomX = (int) (Math.random()*20);
            randomY = (int) (Math.random()*11);
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
        b.setOnAction(this);
    }

    private void handleResult(){
        if(buttonTrue){
            //what happens when the buttons are pressed in the correct order
            System.out.println("correct");
            directionsGameS.setOnKeyPressed(
                    event -> {}
            );

        } else {
            //what happens when the buttons are pressed in the incorrect order
            System.out.println("incorrect");
            prompter.setVisible(true);
            prompterFade.play();
            directionsGameS.setOnKeyPressed(
                    event-> {
                        this.run();
                    }
            );
        }
    }

    @Override
    public void handle(Event event) {
        if(event.getSource() == button1){
            b1Pressed = true;
            orderCounter++;
            System.out.println("button 1 works");
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
            System.out.println("button 2 works");
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
            System.out.println("button 3 works");
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
            System.out.println("button 4 works");
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
            System.out.println("button 5 works");
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
            System.out.println("button 6 works");
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