/**
 * Class that runs the first level, otherwise known as the Deficiency Room. In this level, the user will learn about youth homelessness through interactive screens.
 * Time spent: 6 hours
 *
 * @author Zoe Fan-Chiang
 * @version 3.0
 * @since 2022-06-10
 */

package streetLife;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.*;

public class DeficiencyRoom implements EventHandler<ActionEvent> {
    /**
     * stage variable where all the scenes appear on
     */
    Stage stage;

    /**
     * variables for the first scene including imageView, pane, group, and scene
     */
    private ImageView screen1 = new ImageView();
    private Pane pane1 = new Pane();
    private Group root1 = new Group();
    private Scene scene1 = new Scene(root1, 960, 540);

    /**
     * variables for the second scene including imageView, pane, group, and scene
     */
    private ImageView screen2 = new ImageView();
    private Pane pane2 = new Pane();
    private Group root2 = new Group();
    private Scene scene2 = new Scene(root2, 960, 540);

    /**
     * variables for the third scene including imageView, pane, group, and scene
     */
    private ImageView screen3 = new ImageView();
    private Pane pane3 = new Pane();
    private Group root3 = new Group();
    private Scene scene3 = new Scene(root3, 960, 540);

    /**
     * variables for the fourth scene including imageView, pane, group, and scene
     */
    private ImageView screen4 = new ImageView();
    private Pane pane4 = new Pane();
    private Group root4 = new Group();
    private Scene scene4 = new Scene(root4, 960, 540);

    /**
     * variables for the fourth scene pop ups (technically just new scenes) including multiple imageView, pane, group, and scene
     */
    private ImageView screen4a = new ImageView();
    private Pane pane4a = new Pane();
    private Group root4a = new Group();
    private Scene scene4a = new Scene(root4a, 960, 540);

    private ImageView screen4b = new ImageView();
    private Pane pane4b = new Pane();
    private Group root4b = new Group();
    private Scene scene4b = new Scene(root4b, 960, 540);

    private ImageView screen4c = new ImageView();
    private Pane pane4c = new Pane();
    private Group root4c = new Group();
    private Scene scene4c = new Scene(root4c, 960, 540);

    private ImageView screen4d = new ImageView();
    private Pane pane4d = new Pane();
    private Group root4d = new Group();
    private Scene scene4d = new Scene(root4d, 960, 540);

    private ImageView screen4e = new ImageView();
    private Pane pane4e = new Pane();
    private Group root4e = new Group();
    private Scene scene4e = new Scene(root4e, 960, 540);

    private ImageView screen4f = new ImageView();
    private Group root4f = new Group();
    private Scene scene4f = new Scene(root4f, 960, 540);

    private ImageView screen4g = new ImageView();
    private Pane pane4g = new Pane();
    private Group root4g = new Group();
    private Scene scene4g = new Scene(root4g, 960, 540);

    private ImageView screen4h = new ImageView();
    private Pane pane4h = new Pane();
    private Group root4h = new Group();
    private Scene scene4h = new Scene(root4h, 960, 540);

    /**
     * variables for the fifth scene including imageView, pane, group, and scene
     */
    private ImageView screen5 = new ImageView();
    private Pane pane5 = new Pane();
    private Group root5 = new Group();
    private Scene scene5 = new Scene(root5, 960, 540);

    /**
     * variables for the fifth scene pop ups (once again, just new scenes) including imageView, pane, group, and scene
     */
    private ImageView screen5a = new ImageView();
    private Pane pane5a = new Pane();
    private Group root5a = new Group();
    private Scene scene5a = new Scene(root5a,960,540);

    private ImageView screen5b = new ImageView();
    private Pane pane5b = new Pane();
    private Group root5b = new Group();
    private Scene scene5b = new Scene(root5b,960,540);

    private ImageView screen5c = new ImageView();
    private Pane pane5c = new Pane();
    private Group root5c = new Group();
    private Scene scene5c = new Scene(root5c,960,540);

    private ImageView screen5d = new ImageView();
    private Pane pane5d = new Pane();
    private Group root5d = new Group();
    private Scene scene5d = new Scene(root5d,960,540);

    private ImageView screen5e = new ImageView();
    private Pane pane5e = new Pane();
    private Group root5e = new Group();
    private Scene scene5e = new Scene(root5e,960,540);

    private ImageView screen5f = new ImageView();
    private Pane pane5f = new Pane();
    private Group root5f = new Group();
    private Scene scene5f = new Scene(root5f,960,540);

    private ImageView screen6 = new ImageView();
    private Pane pane6 = new Pane();
    private Group root6 = new Group();
    private Scene scene6 = new Scene(root6, 960, 540);

    /**
     * Deficiency Room constructor
     * @param s stage which the room should run on
     */
    public DeficiencyRoom(Stage s){
        stage = s;
    }

    /**
     * Declaring and setting all the scenes
     * @throws IOException
     */
    public void setScenes() throws IOException {
    	//scene 1
        Image image1 = Functions.getDefImg("deficiency 1.png");
        screen1.setImage(image1);
        screen1.setFitWidth(960);
        screen1.setPreserveRatio(true);

        root1.getChildren().addAll(screen1, pane1);

        //scene 2
        Image image2 = Functions.getDefImg("deficiency 2.png");
        screen2.setImage(image2);
        screen2.setFitWidth(960);
        screen2.setPreserveRatio(true);

        root2.getChildren().addAll(screen2, pane2);

        //scene 3
        Image image3 = Functions.getDefImg("deficiency 3.png");
        screen3.setImage(image3);
        screen3.setFitWidth(960);
        screen3.setPreserveRatio(true);

        root3.getChildren().addAll(screen3, pane3);

        //scene 4
        Image image4 = Functions.getDefImg("deficiency 4.png");
        screen4.setImage(image4);
        screen4.setFitWidth(960);
        screen4.setPreserveRatio(true);

        root4.getChildren().addAll(screen4, pane4);

        //screen 4 pop ups

        Image image4a = Functions.getDefImg("deficiency 4 pop up.png");
        screen4a.setImage(image4a);
        screen4a.setFitWidth(960);
        screen4a.setPreserveRatio(true);

        root4a.getChildren().addAll(screen4a, pane4a);

        Image image4b = Functions.getDefImg("deficiency 4 pop up (2).png");
        screen4b.setImage(image4b);
        screen4b.setFitWidth(960);
        screen4b.setPreserveRatio(true);

        root4b.getChildren().addAll(screen4b, pane4b);

        Image image4c = Functions.getDefImg("deficiency 4 pop up (3).png");
        screen4c.setImage(image4c);
        screen4c.setFitWidth(960);
        screen4c.setPreserveRatio(true);

        root4c.getChildren().addAll(screen4c, pane4c);

        Image image4d = Functions.getDefImg("deficiency 4 pop up (4).png");
        screen4d.setImage(image4d);
        screen4d.setFitWidth(960);
        screen4d.setPreserveRatio(true);

        root4d.getChildren().addAll(screen4d, pane4d);

        Image image4e = Functions.getDefImg("deficiency 4 pop up (5).png");
        screen4e.setImage(image4e);
        screen4e.setFitWidth(960);
        screen4e.setPreserveRatio(true);

        root4e.getChildren().addAll(screen4e, pane4e);

        Image image4f = Functions.getDefImg("deficiency 4 pop up (6).png");
        screen4f.setImage(image4f);
        screen4f.setFitWidth(960);
        screen4f.setPreserveRatio(true);

        root4f.getChildren().addAll(screen4f, pane4c);

        Image image4g = Functions.getDefImg("deficiency 4 pop up (7).png");
        screen4g.setImage(image4g);
        screen4g.setFitWidth(960);
        screen4g.setPreserveRatio(true);

        root4g.getChildren().addAll(screen4g, pane4g);

        Image image4h = Functions.getDefImg("deficiency 4 pop up (8).png");
        screen4h.setImage(image4h);
        screen4h.setFitWidth(960);
        screen4h.setPreserveRatio(true);

        root4h.getChildren().addAll(screen4h, pane4h);

        //screen 5
        Image image5 = Functions.getDefImg("deficiency 5.png");
        screen5.setImage(image5);
        screen5.setFitWidth(960);
        screen5.setPreserveRatio(true);

        root5.getChildren().addAll(screen5, pane5);

        //screen 5 pop ups
        Image image5a = Functions.getDefImg("deficiency 5 pop up.png");
        screen5a.setImage(image5a);
        screen5a.setFitWidth(960);
        screen5a.setPreserveRatio(true);

        root5a.getChildren().addAll(screen5a, pane5a);

        Image image5b = Functions.getDefImg("deficiency 5 pop up (2).png");
        screen5b.setImage(image5b);
        screen5b.setFitWidth(960);
        screen5b.setPreserveRatio(true);

        root5b.getChildren().addAll(screen5b, pane5b);

        Image image5c = Functions.getDefImg("deficiency 5 pop up (3).png");
        screen5c.setImage(image5c);
        screen5c.setFitWidth(960);
        screen5c.setPreserveRatio(true);

        root5c.getChildren().addAll(screen5c, pane5c);

        Image image5d = Functions.getDefImg("deficiency 5 pop up (4).png");
        screen5d.setImage(image5d);
        screen5d.setFitWidth(960);
        screen5d.setPreserveRatio(true);

        root5d.getChildren().addAll(screen5d, pane5d);

        Image image5e = Functions.getDefImg("deficiency 5 pop up (5).png");
        screen5e.setImage(image5e);
        screen5e.setFitWidth(960);
        screen5e.setPreserveRatio(true);

        root5e.getChildren().addAll(screen5e, pane5e);

        Image image5f = Functions.getDefImg("deficiency 5 pop up (6).png");
        screen5f.setImage(image5f);
        screen5f.setFitWidth(960);
        screen5f.setPreserveRatio(true);

        root5f.getChildren().addAll(screen5f, pane5f);

        //scene 6
        Image image6 = Functions.getDefImg("deficiency complete.png");
        screen6.setImage(image6);
        screen6.setFitWidth(960);
        screen6.setPreserveRatio(true);

        root6.getChildren().addAll(screen6, pane6);
    }
    
    /**
     * Running the first scene and starting the Room
     * @throws IOException 
     */
    public void start() throws IOException{
        //start
        stage.setScene(scene1);
        inputS1();
        stage.show();
    }

    public void handle(ActionEvent e){

    }

    /**
     * Method that deals with key press input on first screen to second screen
     */
    public void inputS1(){
        scene1.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene2);
                inputS2();
            }
        });
    }

    /**
     * Method that deals with key press input on second screen to third screen
     */
    public void inputS2(){
        scene2.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene3);
                inputS3();
            }
        });
    }

    /**
     * Method that deals with mouse click input on third screen to fourth screen
     */
       public void inputS3(){
        scene3.setOnMouseClicked((MouseEvent e) -> {
            if(e.getX() > 130 && e.getX() < 240 && e.getY() > 350 && e.getY() < 380){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }

    /**
     * Method that deals with mouse click input on fourth screen to corresponding pop ups
     */
    public void inputS4(){
        scene4.setOnMouseClicked((MouseEvent e) -> {
            if(e.getX() > 700 && e.getX() < 850 && e.getY() > 365 && e.getY() < 490){
                stage.setScene(scene4a);
                inputPopUpS4(scene4a);
            }
            if(e.getX() > 500 && e.getX() < 650 && e.getY() > 365 && e.getY() < 490){
                stage.setScene(scene4b);
                inputPopUpS4(scene4b);
            }
            if(e.getX() > 300 && e.getX() < 450 && e.getY() > 365 && e.getY() < 490){
                stage.setScene(scene4c);
                inputPopUpS4(scene4c);
            }
            if(e.getX() > 100 && e.getX() < 250 && e.getY() > 365 && e.getY() < 490){
                stage.setScene(scene4d);
                inputPopUpS4(scene4d);
            }
            if(e.getX() > 700 && e.getX() < 850 && e.getY() > 60 && e.getY() < 175){
                stage.setScene(scene4e);
                inputPopUpS4(scene4e);
            }
            if(e.getX() > 500 && e.getX() < 650 && e.getY() > 60 && e.getY() < 175){
                stage.setScene(scene4f);
                inputPopUpS4(scene4f);
            }
            if(e.getX() > 300 && e.getX() < 450 && e.getY() > 60 && e.getY() < 175){
                stage.setScene(scene4g);
                inputPopUpS4(scene4g);
            }
            if(e.getX() > 100 && e.getX() < 250 && e.getY() > 60 && e.getY() < 175){
                stage.setScene(scene4h);
                inputPopUpS4(scene4h);
            }
            if(e.getX() > 790 && e.getX() < 905 && e.getY() > 255 && e.getY() < 280){
                stage.setScene(scene5);
                inputS5();
            } //click to next screen
        });
    }

    /**
     * Method that deals with key press input on fourth screen pop ups and brings back to fourth screen
     * @param s scene of the pop up currently displayed
     */
    public void inputPopUpS4(Scene s){
        s.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }

    /**
     * Method that deals with mouse click input on fifth screen to the corresponding pop ups
     */
    public void inputS5(){
        scene5.setOnMouseClicked((MouseEvent e) -> {
            if(e.getX() > 142 && e.getX() < 167 && e.getY() > 435 && e.getY() < 460){
                stage.setScene(scene5a);
                inputPopUpS5(scene5a);
            }
            if(e.getX() > 220 && e.getX() < 245 && e.getY() > 322 && e.getY() < 347){
                stage.setScene(scene5b);
                inputPopUpS5(scene5b);
            }
            if(e.getX() > 590 && e.getX() < 615 && e.getY() > 325 && e.getY() < 350){
                stage.setScene(scene5c);
                inputPopUpS5(scene5c);
            }
            if(e.getX() > 800 && e.getX() < 825 && e.getY() > 455 && e.getY() < 480){
                stage.setScene(scene5d);
                inputPopUpS5(scene5d);
            }
            if(e.getX() > 117 && e.getX() < 142 && e.getY() > 230 && e.getY() < 255){
                stage.setScene(scene5e);
                inputPopUpS5(scene5e);
            }
            if(e.getX() > 415 && e.getX() < 440 && e.getY() > 345 && e.getY() < 370){
                stage.setScene(scene5f);
                inputPopUpS5(scene5f);
            }
            if(e.getX() > 790 && e.getX() < 905 && e.getY() > 310 && e.getY() < 335){
                stage.setScene(scene6);
                inputS6();
            } //continue to next screen
        });
    }

    /**
     * Method that deals with key press input back to fifth screen
     * @param s scene of the pop up currently displayed
     */
    public void inputPopUpS5(Scene s){
        s.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene5);
                inputS5();
            }
        });
    }

    /**
     * Method to deal with key press from sixth to panic room start screen
     */
    public void inputS6(){
        scene6.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                try {
					Computer.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
    }
}
