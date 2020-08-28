package Controller;

import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    public Button drumPadButton;
    public Button banButton;
    public Button leaveButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void leaveApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) leaveButton.getScene().getWindow();
        stage.close();
    }



    public void goToDrumPadView(ActionEvent actionEvent) throws IOException {
        Parent drumPadViewParent = FXMLLoader.load(getClass().getResource("../Template/drumpadKeyboard.fxml"));
        Scene drumPadView = new Scene(drumPadViewParent);
        Screen screen = Screen.getPrimary();;
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, drumPadView);
    }

    public void goToOrchestreView(ActionEvent actionEvent) throws IOException{
        Parent orchestreViewParent = FXMLLoader.load(getClass().getResource("../Template/piano.fxml"));
        Scene orchestreView = new Scene(orchestreViewParent);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window,bounds, orchestreView);
    }


}
