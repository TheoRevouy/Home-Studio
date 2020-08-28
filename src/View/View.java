package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Template/home.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Screen screen=Screen.getPrimary();;
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root);

        window.setTitle("HOME STUDIO");
        setWindow(window, bounds, scene);
    }

    public static void setWindow(Stage window, Rectangle2D bounds, Scene scene) {
        Image icon = new Image(View.class.getResourceAsStream("../Media/Picture/logo.PNG"));
        window.setScene(scene);
        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
        window.setResizable(false);
        window.getIcons().add(icon);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
