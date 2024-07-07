package main.java.com.jsu.view.manager.block;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.java.com.jsu.util.Exitalert;
import main.java.com.jsu.view.scenes.Scenes;
public class Mainviewcontoller {
    @FXML
    Label managercenter;
    @FXML
    ImageView managercenterimage;
    @FXML
    public void exitsystem(ActionEvent event)
    {
        new Exitalert().alertexit();
    }
    @FXML
    public void usermanage(ActionEvent event){new Scenes().usermanagescene();}
    @FXML
    public void routemanage(ActionEvent event){new  Scenes().routemanagescene();}
    @FXML
    public void ordermanage(ActionEvent event){new Scenes().ordermanagescene();}
    @FXML
    public void personalcenter(MouseEvent event){new Scenes().managercenter();}
    public void initialize()
    {
        managercenter.setOnMouseClicked(event -> {
            if(event.getClickCount()==1)
            {
                personalcenter(event);
            }
        });
       managercenterimage.setOnMouseClicked(event -> {
            if(event.getClickCount()==1)
            {
                personalcenter(event);
            }
        });
    }
}
