package streetLife;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EscapeRoom implements EventHandler<ActionEvent> {

    private Font font = Font.font("Courier New", FontWeight.BOLD, 14);
    protected Button testerB;
    protected Button swStreetB;
    protected Button switchbackB2;
    protected Button switchbackB3;
    protected Button swShelterB;
    protected Button swAlleyB;

    protected ImageView background1 = new ImageView();
    protected ImageView background3 = new ImageView();
    protected ImageView background4 = new ImageView();


    protected Pane p1 = new Pane();
    protected Group root1 = new Group();
    protected Scene sc1 = new Scene(root1, 960, 540);

    protected Pane p3 = new Pane();
    protected Group root3 = new Group();
    protected Scene sc3 = new Scene(root3, 960, 540);

    protected Pane p4 = new Pane();
    protected Group root4 = new Group();
    protected Scene sc4 = new Scene(root4, 960, 540);

    private StreetAction street;
    Stage stage;

    public EscapeRoom(Stage stage){
        this.stage = stage;
        street = new StreetAction(stage, this);
    }

    public void start(Stage stage) {

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
        swStreetB.setFont(font);
        swStreetB.setText("go to street");
        swStreetB.setOnAction(this);
        swStreetB.setLayoutX(20);
        swStreetB.setLayoutY(250);

        swShelterB = new Button();
        swShelterB.setFont(font);
        swShelterB.setText("go to shelter");
        swShelterB.setOnAction(this);
        swShelterB.setLayoutX(800);
        swShelterB.setLayoutY(250);

        swAlleyB = new Button();
        swAlleyB.setFont(font);
        swAlleyB.setText("go to alley");
        swAlleyB.setOnAction(this);
        swAlleyB.setLayoutX(430);
        swAlleyB.setLayoutY(500);

        p1.getChildren().addAll(swStreetB,testerB, swShelterB, swAlleyB);

        switchbackB2 = new Button();
        switchbackB2.setFont(font);
        switchbackB2.setText("switch back");
        switchbackB2.setOnAction(this);
        switchbackB2.setLayoutX(10);
        switchbackB2.setLayoutY(10);

        switchbackB3 = new Button();
        switchbackB3.setFont(font);
        switchbackB3.setText("switch back");
        switchbackB3.setOnAction(this);
        switchbackB3.setLayoutX(10);
        switchbackB3.setLayoutY(10);

        p3.getChildren().add(switchbackB2);
        p4.getChildren().add(switchbackB3);


        Image escStart = new Image("Scenes/escapeRoomStart.png");
        background1.setImage(escStart);
        background1.setFitWidth(960);
        background1.setPreserveRatio(true);

        Image escShelter = new Image("Scenes/escapeRoomShelter.png");
        background3.setImage(escShelter);
        background3.setFitWidth(960);
        background3.setPreserveRatio(true);

        Image escAlley = new Image("Scenes/escapeRoomAlley.png");
        background4.setImage(escAlley);
        background4.setFitWidth(960);
        background4.setPreserveRatio(true);

        root1.getChildren().addAll(background1, p1);
        root3.getChildren().addAll(background3,p3);
        root4.getChildren().addAll(background4,p4);

        stage.setScene(sc1);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == testerB){
            System.out.println("Button pressed.");
        }
        if(event.getSource() == swStreetB) {
            //runs the action items in swStreetB
            street.displayThings();
        }

        if(event.getSource() == swShelterB){
            stage.setScene(sc3);
        }
        if(event.getSource() == swAlleyB){
            stage.setScene(sc4);
        }
        if(event.getSource() == switchbackB2 || event.getSource() == switchbackB3){
            stage.setScene(sc1);
        }

    }
}
