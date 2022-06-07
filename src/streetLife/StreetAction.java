package streetLife;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.text.TextAlignment.CENTER;

public class StreetAction implements EventHandler<ActionEvent> {

    private Font font = Font.font("Courier New", FontWeight.BOLD, 20);

    private EscapeRoom escape;
    private String str;
    protected Pane p2 = new Pane();
    protected Group root2 = new Group();
    protected Scene sc2;

    protected Button switchbackB;

    protected ImageView background2 = new ImageView();
    private Text text;
    private VBox textDisplay;
    private Stage stage;

    public StreetAction(Stage stage, EscapeRoom esc) {
        this.stage = stage;
        this.escape = esc;
        switchbackB = new Button();
        switchbackB.setFont(font);
        switchbackB.setText("switch back");
        switchbackB.setOnAction(this);
        switchbackB.setLayoutX(10);
        switchbackB.setLayoutY(10);

        Image escStreet = new Image("Scenes/escapeRoomStreet.png");
        background2.setImage(escStreet);
        background2.setFitWidth(960);
        background2.setPreserveRatio(true);

        str = "";
        text = new Text(str);
        text.setFont(font);
        text.setTextAlignment(CENTER);
        textDisplay = new VBox(text);
        textDisplay.setAlignment(Pos.CENTER);

        p2.getChildren().add(switchbackB);
        p2.getChildren().add(textDisplay);
        root2.getChildren().add(background2);
        root2.getChildren().add(p2);
        sc2 = new Scene(root2, 960, 540);
    }
    //inital choices when the player chooses the street

    public void displayThings() {

        stage.setScene(sc2);
        runText("You travel to a nearby alley, setting up your new home.");
    }

    private void runText(String str) {
        this.str = str;
        if(!p2.getChildren().contains(textDisplay)) {
            p2.getChildren().add(textDisplay);
        }
        IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(text.layoutXProperty(), 150);
        KeyFrame pause = new KeyFrame(
                Duration.seconds(1),
                kv
        );
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.05),
                event -> {
                    if (i.get() > str.length()) {

                        timeline.stop();
                    } else {
                        text.setText(str.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        //timeline.getKeyFrames().add(pause);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        p2.getChildren().remove(textDisplay);
    }

    public void runChoices() {
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == switchbackB) {
            stage.setScene(escape.sc1);
        }
    }
}
