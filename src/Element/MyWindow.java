package Element;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyWindow extends Stage{

    private Stage window;

    Screen screen=Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();

    public MyWindow(){

    }

    public void setWindow(Stage window){
        
        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());
        window.setResizable(false);

        window.show();
    }
}
