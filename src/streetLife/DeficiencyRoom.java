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
        stage.setTitle("Deficiency Room");
        stage.setX(10);
        stage.setY(10);

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

        Image image2 = new Image("deficiency 2.png");
        screen2.setImage(image2);
        screen2.setFitWidth(960);
        screen2.setPreserveRatio(true);

        root2.getChildren().addAll(screen2, pane2);

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
        }
    }
}
