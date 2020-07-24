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
        Timeline tl4 = new Timeline();
        Timeline tl3 = new Timeline();
        Timeline tl2 = new Timeline();
        Timeline tl1 = new Timeline();

        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(clickButton(button) % 5 == 1){
                    System.out.println("1");
                    changeFrequency(note,4,tl4);
                }else if(clickButton(button) % 5 == 2){
                    System.out.println("2");
                    tl4.stop();
                    changeFrequency(note,3,tl3);
                }else if(clickButton(button) % 5 == 3){
                    System.out.println("3");
                    tl3.stop();
                    changeFrequency(note,2,tl2);
                }else if(clickButton(button) % 5 == 4){
                    System.out.println("4");
                    tl2.stop();
                    changeFrequency(note,1,tl1);
                }else if (clickButton(button) % 5 == 0){
                    System.out.println("0");
                    tl1.stop();
                }
            }
        });
    }

    public int clickButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            count++;
            System.out.println(count);
        });

        return count;
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

    public void changeFrequency(AudioClip note, int time, Timeline tl){
        Duration duration = Duration.seconds(time);
        EventHandler playNote = event -> note.play();
        kf = new KeyFrame(duration, playNote);
        tl.getKeyFrames().add(kf);
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

    }


    public void recordAudio(ActionEvent actionEvent) {
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
    }

    public void changeBind(ActionEvent actionEvent) {
    }
}
