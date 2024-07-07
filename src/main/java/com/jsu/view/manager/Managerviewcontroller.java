package main.java.com.jsu.view.manager;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Managerviewcontroller {
    Image image=new Image("main/java/com/jsu/view/picture/Jiugui Liquor.jpg");
    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);

public void initialize()
{
    Stage stage=(Stage)alert.getDialogPane().getScene().getWindow();
    stage.getIcons().add(image);
}

}
