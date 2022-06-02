/**
 * class running the deficinecy room
 */

package streetLife;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.*;

public class DeficiencyRoom implements EventHandler<ActionEvent> {
    Stage stage;

    //scene 1 variables
    private ImageView screen1 = new ImageView();
    private Button button1;
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

    /**
     * constructor
     * @param s stage which room should run on
     */
    public DeficiencyRoom(Stage s){
        stage = s;
    }

    /**
     * setting up each scene and running it
     */
    public void start(){
        //general
        stage.setTitle("Deficiency Room");
        stage.setX(10);
        stage.setY(10);

        //scene 1
        button1 = new Button();
        button1.setText("continue");
        button1.setOnAction(this);
        button1.setLayoutX(850);
        button1.setLayoutY(490);
        pane1.getChildren().addAll(button1);

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

        //start
        stage.setScene(scene1);
        stage.show();
    }

    /**
     * handle method for buttons and key presses, etc.
     * @param event the event which occurred
     */
    public void handle(ActionEvent event) {
        if(event.getSource() == button1){
            stage.setScene(scene2);
            inputS2();
        }
    }

    public void inputS2(){
        scene2.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene3);
                inputS3();
            }
        });
    }

       public void inputS3(){
        scene3.setOnMouseClicked((MouseEvent e) -> {
            if(e.getX() > 150 && e.getX() < 260 && e.getY() > 350 && e.getY() < 380){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }

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
        });
    }

    public void inputPopUpS4(Scene s){
        s.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE){
                stage.setScene(scene4);
                inputS4();
            }
        });
    }
}
