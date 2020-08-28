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

public class Trumpet implements Initializable, TrumpetKit {

    public AnchorPane trumpetAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playTrumpet(KeyEvent keyEvent) {

        trumpetAnchorPane.setOnKeyPressed(keyEvent1 -> {
            switch (keyEvent1.getCode()){
                case S:
                    play_audio(TrumpetKit.TG3);
                    break;
                case D:
                    play_audio(TrumpetKit.TC4);
                    break;
                case F:
                    play_audio(TrumpetKit.TG4);
                    break;
                case G:
                    play_audio(TrumpetKit.TC5);
                    break;
                case H:
                    play_audio(TrumpetKit.TG5);
                    break;
                case J:
                    play_audio(TrumpetKit.TC6);
                    break;
            }
        });
    }

    public void play_audio(String name) {
        AudioClip note = new AudioClip(this.getClass().getResource(name).toString());
        note.play();
    }

    public void goToPlayDrum(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/drum.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }

    public void goToPlayPiano(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/piano.fxml"));
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
