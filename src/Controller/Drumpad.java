package Controller;

import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Drumpad implements Initializable {

    @FXML
    public Button backAtHomeButton;

    @FXML
    public Button drumpadOne;
    public Button drumpadTwo;
    public Button drumpadThree;
    public Button drumpadFour;
    public Button drumpadFive;
    public Button drumpadSix;
    public Button drumpadSeven;
    public Button drumpadEight;
    public Button drumpadNine;
    public Button drumpadTen;
    public Button drumpadEleven;
    public Button drumpadTwelve;
    public Button drumpadThirteen;
    public Button drumpadFourteen;

    public AnchorPane drumPadAnchorPane;

    @Override
    public  void initialize(URL location, ResourceBundle ressources){

    }

    public void backAtHome(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/home.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();;
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);

    }

    public void playDrumPad(KeyEvent keyEvent) throws IOException {

        drumPadAnchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {

                switch (keyEvent.getCode()){
                    case E:
                        play_audio();
                        System.out.println("e");
                        break;
                    case D:
                        System.out.println("d");
                        break;
                    case C:
                        System.out.println("c");
                        break;
                    case R:
                        System.out.println("r");
                        break;
                    case F:
                        System.out.println("f");
                        break;
                    case V:
                        System.out.println("v");
                        break;
                    case T:
                        System.out.println("t");
                        break;
                    case G:
                        System.out.println("g");
                        break;
                    case Y:
                        System.out.println("y");
                        break;
                    case H:
                        System.out.println("h");
                        break;
                    case B:
                        System.out.println("b");
                        break;
                    case U:
                        System.out.println("u");
                        break;
                    case J:
                        System.out.println("j");
                        break;
                    case N:
                        System.out.println("n");
                        break;
                  }
            }
        });
    }

    public void play_audio(){
        AudioClip note = new AudioClip(this.getClass().getResource("../Media/Sound/test.mp3").toString());
        note.play();
    }
}
