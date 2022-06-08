package streetLife;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen {
    private Stage stage;
    private MainMenu mainMenu;

    private ImageView regularIV;
    private Group regularG;
    private Scene regularS;

    private ImageView flickerIV;
    private Text prompter;
    private Group flickerG;
    private Scene flickerS;

    private Image logo;
    private ImageView logoIV;
    private Group logoG;
    private Scene logoS;

    private FadeTransition logoFade;
    private FadeTransition prompterFade;
    private Timeline flicker;
    private Timeline pause;

    Font titleFont = Font.font("Courier New", FontWeight.BOLD, 24);
    Font prompterFont = Font.font("Courier New", FontWeight.BOLD, 16);

    public SplashScreen(Stage stage, MainMenu mainMenu) throws IOException{
        //stage init
        this.stage = stage;
        this.mainMenu = mainMenu;

        //screen with the logo-----------------------------------------------------
        logo = Functions.getScene("logoScreen.png");
        logoIV = new ImageView(logo);
        logoIV.setFitWidth(960);
        logoIV.setFitHeight(540);
        logoG = new Group();
        logoG.getChildren().add(logoIV);
        logoS = new Scene(logoG, 960,540);

        //regular scene init-------------------------------------------------------
        regularIV = new ImageView(Functions.getScene("isp_main.png"));
        regularIV.setFitWidth(960);
        regularIV.setFitHeight(540);
        regularG = new Group();
        regularG.getChildren().add(regularIV);
        regularS = new Scene(regularG, 960, 540);

        //flicker scene init-------------------------------------------------------
        flickerIV = new ImageView(Functions.getScene("isp_mainF.png"));
        flickerIV.setFitWidth(960);
        flickerIV.setFitHeight(540);

        prompter = new Text(185,390,"Press any key to continue...");
        prompter.setFill(Color.WHITE);
        prompter.setFont(prompterFont);
        prompter.setVisible(false);

        flickerG = new Group();
        flickerG.getChildren().add(flickerIV);
        flickerG.getChildren().add(prompter);
        flickerS = new Scene(flickerG, 960, 540);

    }

    public void run() throws InterruptedException {
        //timeline declaration to animate the splash screen

        //logo fade animation------------------------------------------------------------
        logoFade = new FadeTransition(Duration.seconds(3), logoIV);
        logoFade.setFromValue(0);
        logoFade.setToValue(1);
        logoFade.setCycleCount(1);

        //flicker animation--------------------------------------------------------------
        flicker = new Timeline(
                new KeyFrame(Duration.seconds(1.4), event -> stage.setScene(flickerS)),
                new KeyFrame(Duration.seconds(0.2), event -> stage.setScene(regularS))
        );
        flicker.setCycleCount(3);

        //pause animation----------------------------------------------------------------
        pause = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> stage.setScene(flickerS))
        );
        pause.setCycleCount(1);

        //prompter blink animation-------------------------------------------------------
        prompterFade = new FadeTransition(Duration.seconds(1),prompter);
        prompterFade.setFromValue(1);
        prompterFade.setToValue(0);
        prompterFade.setAutoReverse(true);
        prompterFade.setCycleCount(Timeline.INDEFINITE);

        //control specifications---------------------------------------------------------
        logoFade.setOnFinished(finish -> {
                    flicker.play();
                }
        );
        flicker.setOnFinished(finish -> {
            stage.setScene(flickerS);
            pause.play();
        });
        pause.setOnFinished(finish -> {
                    stage.setScene(flickerS);
                    prompter.setVisible(true);
                    prompterFade.play();
                    flickerS.setOnKeyPressed(event -> {
                        mainMenu.run();
                    });
                }
        );
        stage.setScene(logoS);
        logoFade.play();

    }
}
