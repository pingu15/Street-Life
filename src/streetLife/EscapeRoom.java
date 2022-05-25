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

public class EscapeRoom implements EventHandler<ActionEvent> {

    private Button testerB;
    private Button swStreetB;
    private Button switchbackB;
    private Button switchbackB2;
    private Button switchbackB3;
    private Button swShelterB;
    private Button swAlleyB;

    private ImageView background1 = new ImageView();
    private ImageView background2 = new ImageView();
    private ImageView background3 = new ImageView();
    private ImageView background4 = new ImageView();


    private Pane p1 = new Pane();
    private Group root1 = new Group();
    private Scene sc1 = new Scene(root1, 960, 540);

    private Pane p2 = new Pane();
    private Group root2 = new Group();
    private Scene sc2 = new Scene(root2, 960, 540);

    private Pane p3 = new Pane();
    private Group root3 = new Group();
    private Scene sc3 = new Scene(root3, 960, 540);

    private Pane p4 = new Pane();
    private Group root4 = new Group();
    private Scene sc4 = new Scene(root4, 960, 540);

    Stage stage;

    public EscapeRoom(Stage stage) {
    	this.stage = stage;
    }

    public void start() {
        Image logo = new Image("Scenes/isp_logo_nobg.png");
        stage.getIcons().add(logo);
        stage.setTitle("Escape Room");
        stage.setX(10);
        stage.setY(10);
        //stage.setFullScreen(true);

        testerB = new Button();
        testerB.setText("continue");
        testerB.setOnAction(this);
        testerB.setLayoutX(10);
        testerB.setLayoutY(10);

        swStreetB = new Button();
        swStreetB.setText("go to street");
        swStreetB.setOnAction(this);
        swStreetB.setLayoutX(20);
        swStreetB.setLayoutY(250);

        swShelterB = new Button();
        swShelterB.setText("go to shelter");
        swShelterB.setOnAction(this);
        swShelterB.setLayoutX(855);
        swShelterB.setLayoutY(250);

        swAlleyB = new Button();
        swAlleyB.setText("go to alley");
        swAlleyB.setOnAction(this);
        swAlleyB.setLayoutX(450);
        swAlleyB.setLayoutY(500);

        p1.getChildren().addAll(swStreetB,testerB, swShelterB, swAlleyB);

        switchbackB = new Button();
        switchbackB.setText("switch back");
        switchbackB.setOnAction(this);
        switchbackB.setLayoutX(10);
        switchbackB.setLayoutY(10);

        switchbackB2 = new Button();
        switchbackB2.setText("switch back");
        switchbackB2.setOnAction(this);
        switchbackB2.setLayoutX(10);
        switchbackB2.setLayoutY(10);

        switchbackB3 = new Button();
        switchbackB3.setText("switch back");
        switchbackB3.setOnAction(this);
        switchbackB3.setLayoutX(10);
        switchbackB3.setLayoutY(10);

        p2.getChildren().add(switchbackB);
        p3.getChildren().add(switchbackB2);
        p4.getChildren().add(switchbackB3);


        Image escStart = new Image("Scenes/escapeRoomStart.png");
        background1.setImage(escStart);
        background1.setFitWidth(960);
        background1.setPreserveRatio(true);

        Image escStreet = new Image("Scenes/escapeRoomStreet.png");
        background2.setImage(escStreet);
        background2.setFitWidth(960);
        background2.setPreserveRatio(true);

        Image escShelter = new Image("Scenes/escapeRoomShelter.png");
        background3.setImage(escShelter);
        background3.setFitWidth(960);
        background3.setPreserveRatio(true);

        Image escAlley = new Image("Scenes/escapeRoomAlley.png");
        background4.setImage(escAlley);
        background4.setFitWidth(960);
        background4.setPreserveRatio(true);

        root1.getChildren().addAll(background1, p1);
        root2.getChildren().addAll(background2,p2);
        root3.getChildren().addAll(background3,p3);
        root4.getChildren().addAll(background4,p4);

        stage.setScene(sc1);
        stage.show();
    }


    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()== testerB){
            System.out.println("Button pressed.");
        }
        if(event.getSource() == swStreetB){
            stage.setScene(sc2);
        }
        if(event.getSource() == swShelterB){
            stage.setScene(sc3);
        }
        if(event.getSource() == swAlleyB){
            stage.setScene(sc4);
        }
        if(event.getSource() == switchbackB||event.getSource() == switchbackB2||event.getSource() == switchbackB3){
            stage.setScene(sc1);
        }

    }
}
