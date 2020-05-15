package Controller;

import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {

    @FXML
    public Button drumPadButton;
    public Button banButton;
    public Button leaveButton;


    public void leaveApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) leaveButton.getScene().getWindow();
        stage.close();
    }

    public void goToDrumPadView(ActionEvent actionEvent) throws IOException {
        Parent drumPadViewParent = FXMLLoader.load(getClass().getResource("../Template/drumpadKeyboard.fxml"));
        Scene drumPadView = new Scene(drumPadViewParent);
        Screen screen=Screen.getPrimary();;
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, drumPadView);
    }
}
