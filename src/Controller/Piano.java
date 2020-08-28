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

public class Piano implements Initializable, PianoKit {

    public AnchorPane pianoAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playPiano(KeyEvent keyEvent) throws IOException {
        pianoAnchorPane.setOnKeyPressed(keyEvent1 -> {
            switch (keyEvent1.getCode()) {
                case Q:
                    play_audio(PianoKit.PIANO1);
                    break;
                case S:
                    play_audio(PianoKit.PIANO2);
                    break;
                case D:
                    play_audio(PianoKit.PIANO3);
                    break;
                case F:
                    play_audio(PianoKit.PIANO4);
                    break;
                case G:
                    play_audio(PianoKit.PIANO5);
                    break;
                case H:
                    play_audio(PianoKit.PIANO6);
                    break;
                case J:
                    play_audio(PianoKit.PIANO7);
                    break;
                case K:
                    play_audio(PianoKit.PIANO8);
                    break;
                case Z:
                    play_audio(PianoKit.PIANO9);
                    break;
                case E:
                    play_audio(PianoKit.PIANO10);
                    break;
                case R:
                    play_audio(PianoKit.PIANO11);
                    break;
                case T:
                    play_audio(PianoKit.PIANO12);
                    break;
                case Y:
                    play_audio(PianoKit.PIANO13);
                    break;
                case U:
                    play_audio(PianoKit.PIANO14);
                    break;
                case I:
                    play_audio(PianoKit.PIANO15);
                    break;
                case O:
                    play_audio(PianoKit.PIANO16);
                    break;
            }
        });
    }

    public void play_audio(String name) {
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        note.play();
    }

    public void backAtHome(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/home.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }

    public void goToPlayDrum(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/drum.fxml"));
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
}
