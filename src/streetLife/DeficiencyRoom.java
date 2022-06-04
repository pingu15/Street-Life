/**
 * class running the deficinecy room
 */

package streetLife;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.*;
import java.time.LocalTime;

public class DeficiencyRoom implements EventHandler<ActionEvent> {
    Stage stage;

    //scene 1 variables
    private ImageView screen1 = new ImageView();
    private Pane pane1 = new Pane();
    private Group root1 = new Group();
    private Scene scene1 = new Scene(root1, 960, 540);

    //scene 2 variables
    private ImageView screen2 = new ImageView();
    private Pane pane2 = new Pane();
    private Group root2 = new Group();
    private Scene scene2 = new Scene(root2, 960, 540);

    //scene 3 variables
    private ImageView screen3 = new ImageView();
    private Pane pane3 = new Pane();
    private Group root3 = new Group();
    private Scene scene3 = new Scene(root3, 960, 540);

    //scene 4 variables
    private ImageView screen4 = new ImageView();
    private Pane pane4 = new Pane();
    private Group root4 = new Group();
    private Scene scene4 = new Scene(root4, 960, 540);

    //scene 4 popup variables
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
    private Pane pane4f = new Pane();
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
     * constructor
     * @param s stage which room should run on
     */
    public DeficiencyRoom(Stage s){
        stage = s;
    }

    /**
     * setting up each scene and running the first scene
     */
    public void start(){
        //general
        stage.setTitle("Deficiency Room");
        stage.setX(10);
        stage.setY(10);

        //scene 1
        Image image1 = new Image("deficiency 1.png");
        screen1.setImage(image1);
        screen1.setFitWidth(960);
        screen1.setPreserveRatio(true);

        root1.getChildren().addAll(screen1, pane1);

        //scene 2
        Image image2 = new Image("deficiency 2.png");
        screen2.setImage(image2);
        screen2.setFitWidth(960);
        screen2.setPreserveRatio(true);

        root2.getChildren().addAll(screen2, pane2);

        //scene 3
        Image image3 = new Image("deficiency 3.png");
        screen3.setImage(image3);
        screen3.setFitWidth(960);
        screen3.setPreserveRatio(true);

        root3.getChildren().addAll(screen3, pane3);

        //scene 4
        Image image4 = new Image("deficiency 4.png");
        screen4.setImage(image4);
        screen4.setFitWidth(960);
        screen4.setPreserveRatio(true);

        root4.getChildren().addAll(screen4, pane4);

        Image image4a = new Image("deficiency 4 pop up.png");
        screen4a.setImage(image4a);
        screen4a.setFitWidth(960);
        screen4a.setPreserveRatio(true);

        root4a.getChildren().addAll(screen4a, pane4a);

        Image image4b = new Image("deficiency 4 pop up (2).png");
        screen4b.setImage(image4b);
        screen4b.setFitWidth(960);
        screen4b.setPreserveRatio(true);

        root4b.getChildren().addAll(screen4b, pane4b);

        Image image4c = new Image("deficiency 4 pop up (3).png");
        screen4c.setImage(image4c);
        screen4c.setFitWidth(960);
        screen4c.setPreserveRatio(true);

        root4c.getChildren().addAll(screen4c, pane4c);

        Image image4d = new Image("deficiency 4 pop up (4).png");
        screen4d.setImage(image4d);
        screen4d.setFitWidth(960);
        screen4d.setPreserveRatio(true);

        root4d.getChildren().addAll(screen4d, pane4d);

        Image image4e = new Image("deficiency 4 pop up (5).png");
        screen4e.setImage(image4e);
        screen4e.setFitWidth(960);
        screen4e.setPreserveRatio(true);

        root4e.getChildren().addAll(screen4e, pane4e);

        Image image4f = new Image("deficiency 4 pop up (6).png");
        screen4f.setImage(image4f);
        screen4f.setFitWidth(960);
        screen4f.setPreserveRatio(true);

        root4f.getChildren().addAll(screen4f, pane4c);

        Image image4g = new Image("deficiency 4 pop up (7).png");
        screen4g.setImage(image4g);
        screen4g.setFitWidth(960);
        screen4g.setPreserveRatio(true);

        root4g.getChildren().addAll(screen4g, pane4g);

        Image image4h = new Image("deficiency 4 pop up (8).png");
        screen4h.setImage(image4h);
        screen4h.setFitWidth(960);
        screen4h.setPreserveRatio(true);

        root4h.getChildren().addAll(screen4h, pane4h);

        //start
        int start = LocalTime.now().getSecond();
        if(start >= 54) {
            start -= 60;
        }

        //trying to get timer two work so that scene switches after certain amount of time but it shows blank screen
        stage.setScene(scene1);
        stage.show();

        while(true){
            if(LocalTime.now().getSecond() == start + 6){
                stage.setScene(scene2);
                inputS2();
                break;
            }
        }
    }

    public void handle(ActionEvent e){

    }

    /**
     * method to deal with input on screen 2 which calls screen 3
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
     * method to deal with input on screen 3 which calls screen 4
     */
       public void inputS3(){
        scene3.setOnMouseClicked((MouseEvent e) -> {
            if(e.getX() > 150 && e.getX() < 260 && e.getY() > 350 && e.getY() < 380){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }

    /**
     * method to deal with input on screen 4 which calls pop up screens
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
        });
    }

    /**
     * method for the input on pop up screens which calls back to screen 4
     * @param s
     */
    public void inputPopUpS4(Scene s){
        s.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }
}
