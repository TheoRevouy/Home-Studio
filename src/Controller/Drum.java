package Controller;

import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Drum implements Initializable, DrumKit {

    public AnchorPane drumAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playDrum(KeyEvent keyEvent) throws IOException{

        drumAnchorPane.setOnKeyPressed(keyEvent1 -> {
            switch (keyEvent1.getCode()){
                case V:
                    play_audio(DrumKit.BASSDRUM1);
                    break;
                case B:
                    play_audio(DrumKit.BASSDRUM2);
                    break;
                case F:
                    play_audio(DrumKit.PERC1);
                    break;
                case G:
                    play_audio(DrumKit.PERC2);
                    break;
                case H:
                    play_audio(DrumKit.PERC3);
                    break;
                case D:
                    play_audio(DrumKit.CYM1);
                    break;
                case J:
                    play_audio(DrumKit.CYM2);
                    break;
                case R:
                    play_audio(DrumKit.SNARE);
                    break;
                case U:
                    play_audio(DrumKit.HAT);
            }
        });

    }

    public void play_audio(String name) {
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        note.play();
    }

    public void goToPlayPiano(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/piano.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }

    public void goToPlayTrumpet(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/trumpet.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }

    public void backAtHome(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/home.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }

}
