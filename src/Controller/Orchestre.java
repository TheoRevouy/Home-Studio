package Controller;

import View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Orchestre {

    public Button backAtHomeButton;

    public void backAtHome(ActionEvent actionEvent) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("../Template/home.fxml"));
        Scene homeView = new Scene(homeViewParent);
        Screen screen=Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        View.setWindow(window, bounds, homeView);
    }


}
