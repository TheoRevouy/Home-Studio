package Controller;

import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Drumpad implements DrumpadKit, Initializable{

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
        Screen screen=Screen.getPrimary();
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
                        play_audio(DrumpadKit.CLAP);
                        break;
                    case D:
                        play_audio(DrumpadKit.FX1);
                        break;
                    case C:
                        play_audio(DrumpadKit.FX2);
                        break;
                    case R:
                        play_audio(DrumpadKit.HATS);
                        break;
                    case F:
                        play_audio(DrumpadKit.KICK1);
                        break;
                    case V:
                        play_audio(DrumpadKit.KICK2);
                        break;
                    case T:
                        play_audio(DrumpadKit.PERC1);
                        break;
                    case G:
                        play_audio(DrumpadKit.PERC2);
                        break;
                    case Y:
                        play_audio(DrumpadKit.PERC3);
                        break;
                    case H:
                        play_audio(DrumpadKit.PERC4);
                        break;
                    case B:
                        play_audio(DrumpadKit.SNARE);
                        break;
                    case U:
                        play_audio(DrumpadKit.STABE);
                        break;
                    case J:
                        play_audio(DrumpadKit.VOCAL1);
                        break;
                    case N:
                        play_audio(DrumpadKit.VOCAL2);
                        break;
                  }
            }
        });
    }

    public void play_audio(String name){
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        note.play();
    }

    public void clapLoop(ActionEvent actionEvent) {
        AudioClip clap = new AudioClip(this.getClass().getResource(DrumpadKit.CLAP).toString());
        clap.setCycleCount(MediaPlayer.INDEFINITE);
        clap.play();
    }


    public void loop(Button button, String name) {
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());

        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() % 5 == 1){
                    System.out.println("1");
                    changeFrequency(note,5);
                }else if(mouseEvent.getClickCount() % 5 == 2){
                    System.out.println("2");
                    changeFrequency(note,1);
                }else if(mouseEvent.getClickCount() % 5 == 3){
                    System.out.println("3");
                }else if(mouseEvent.getClickCount() % 5 == 4){
                    System.out.println("4");
                }else if (mouseEvent.getClickCount() % 5 == 0){
                    System.out.println("0");
                }
            }
        });
    }

    public void moussePressed(MouseEvent actionEvent) {
        loop(drumpadOne, DrumpadKit.CLAP);
        loop(drumpadTwo, DrumpadKit.FX1);
        loop(drumpadThree, DrumpadKit.FX2);
        loop(drumpadFour, DrumpadKit.HATS);
        loop(drumpadFive, DrumpadKit.KICK1);
        loop(drumpadSix, DrumpadKit.KICK2);
        loop(drumpadSeven, DrumpadKit.PERC1);
        loop(drumpadEight, DrumpadKit.PERC2);
        loop(drumpadNine, DrumpadKit.PERC3);
        loop(drumpadTen, DrumpadKit.PERC4);
        loop(drumpadEleven, DrumpadKit.SNARE);
        loop(drumpadTwelve, DrumpadKit.STABE);
        loop(drumpadThirteen, DrumpadKit.VOCAL1);
        loop(drumpadFourteen, DrumpadKit.VOCAL2);
    }

    public void changeFrequency(AudioClip note, int duration){
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(duration), actionEvent -> note.play()));
        tl.stop();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

    }
}
