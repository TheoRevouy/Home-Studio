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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrumpadKeyboard implements DrumpadKit, Initializable{

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

    public Button recordButton;

    public Button bindButton;

    public AnchorPane drumPadAnchorPane;

    private int count = 1 ;
    private KeyFrame kf;


    @Override
    public  void initialize(URL location, ResourceBundle resourceBundle){

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

        drumPadAnchorPane.setOnKeyPressed(keyEvent1 -> {

            switch (keyEvent1.getCode()) {
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
        });
    }

    public void play_audio(String name){
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        note.play();
    }

    public void loop(Button button, String name) {
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        Timeline tl4 = new Timeline();
        Timeline tl3 = new Timeline();
        Timeline tl2 = new Timeline();
        Timeline tl1 = new Timeline();

        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(clickButton(button) % 5 == 1){
                    button.setStyle("-fx-background-color: green");
                    changeFrequency(note,2000,tl4);
                }else if(clickButton(button) % 5 == 2){
                    button.setStyle("-fx-background-color: yellow");
                    tl4.stop();
                    changeFrequency(note,1500,tl3);
                }else if(clickButton(button) % 5 == 3){
                    button.setStyle("-fx-background-color: orange");
                    tl3.stop();
                    changeFrequency(note,1000,tl2);
                }else if(clickButton(button) % 5 == 4){
                    button.setStyle("-fx-background-color: red");
                    tl2.stop();
                    changeFrequency(note,700,tl1);
                }else if (clickButton(button) % 5 == 0){
                    button.setStyle("-fx-background-color: white");
                    tl1.stop();
                }
            }
        });
    }

    public int clickButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            count++;
        });

        return count;
    }

    public void moussePressed(MouseEvent actionEvent) {
        loop(drumpadOne, DrumpadKit.PERC2);
        loop(drumpadTwo, DrumpadKit.PERC4);
        loop(drumpadThree, DrumpadKit.PERC3);
        loop(drumpadFour, DrumpadKit.SNARE);
        loop(drumpadFive, DrumpadKit.STABE);
        loop(drumpadSix, DrumpadKit.HATS);
        loop(drumpadSeven, DrumpadKit.VOCAL1);
        loop(drumpadEight, DrumpadKit.VOCAL2);
        loop(drumpadNine, DrumpadKit.PERC1);
        loop(drumpadTen, DrumpadKit.KICK2);
        loop(drumpadEleven, DrumpadKit.FX2);
        loop(drumpadTwelve, DrumpadKit.CLAP);
        loop(drumpadThirteen, DrumpadKit.KICK1);
        loop(drumpadFourteen, DrumpadKit.FX1);
    }

    public void changeFrequency(AudioClip note, int time, Timeline tl){
        Duration duration = Duration.millis(time);
        EventHandler playNote = event -> note.play();
        kf = new KeyFrame(duration, playNote);
        tl.getKeyFrames().add(kf);
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

    }


    /*public void recordAudio(ActionEvent actionEvent) {
        recordButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                final SoundRecorder recorder = new SoundRecorder();
                System.out.println("click here !");
                // creates a new thread that waits for a specified
                // of time before stopping
                Thread stopper = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(SoundRecorder.TIME);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        recorder.finish();
                    }
                });

                stopper.start();

                // start recording
                recorder.start();
            }
        });
    }*/

    public void goToDrumPadWithNumPad(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/drumPadNumPad.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);

    }
}
