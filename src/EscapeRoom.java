import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscapeRoom  implements EventHandler<ActionEvent> {

    private Button testerB;
    private Button switcherB;
    private Button switchbackB;

    private ImageView background1 = new ImageView();
    private ImageView background2 = new ImageView();


    private Pane p1 = new Pane();
    private Group root1 = new Group();
    private Scene sc1 = new Scene(root1, 960, 540);

    private Pane p2 = new Pane();
    private Group root2 = new Group();
    private Scene sc2 = new Scene(root2, 960, 540);

    Stage stage;

    public EscapeRoom(){
    }

    public void start(Stage stage) {
        this.stage=stage;
        Image logo = new Image("Scenes/isp_logo_nobg.png");
        stage.getIcons().add(logo);
        stage.setTitle("Escape Room");
        stage.setX(10);
        stage.setY(10);
        //stage.setFullScreen(true);

        testerB = new Button();
        testerB.setText("continue");
        testerB.setOnAction(this);
        testerB.setLayoutX(100);
        testerB.setLayoutY(10);

        switcherB = new Button();
        switcherB.setText("switch scene");
        switcherB.setOnAction(this);
        switcherB.setLayoutX(10);
        switcherB.setLayoutY(10);

        p1.getChildren().addAll(switcherB,testerB);

        switchbackB = new Button();
        switchbackB.setText("switch back");
        switchbackB.setOnAction(this);
        switchbackB.setLayoutX(10);
        switchbackB.setLayoutY(10);

        p2.getChildren().add(switchbackB);

        Image escStart = new Image("Scenes/escapeRoomStart.png");
        background1.setImage(escStart);
        background1.setFitWidth(960);
        background1.setPreserveRatio(true);

        Image escStreet = new Image("Scenes/escapeRoomStreet.png");
        background2.setImage(escStreet);
        background2.setFitWidth(960);
        background2.setPreserveRatio(true);

        root1.getChildren().addAll(background1, p1);
        root2.getChildren().addAll(background2,p2);

        stage.setScene(sc1);
        stage.show();
    }


    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()== testerB){
            System.out.println("Button pressed.");
        }
        if(event.getSource() == switcherB){
            stage.setScene(sc2);
        }
        if(event.getSource() == switchbackB){
            stage.setScene(sc1);
        }
    }
}
