package main.java.com.jsu.view.traveler.block;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.java.com.jsu.view.scenes.Scenes;
public class Mainviewcontroller {
    @FXML Label travelercenter;
    @FXML ImageView travelercenterimage;
    public void initialize()
    {
        travelercenter.setOnMouseClicked(event -> {
            if(event.getClickCount()==1)
            {
                personalcenter(event);
            }
        });
        travelercenterimage.setOnMouseClicked(event -> {
            if(event.getClickCount()==1)
            {
                personalcenter(event);
            }
        });
    }
    @FXML public void personalcenter(MouseEvent event){new Scenes().travelercenter();}
}
