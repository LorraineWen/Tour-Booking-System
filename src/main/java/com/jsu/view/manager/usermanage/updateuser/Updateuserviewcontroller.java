package main.java.com.jsu.view.manager.usermanage.updateuser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.controller.update.Updatecontroller;
import main.java.com.jsu.controller.update.Updatecontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.view.scenes.Scenes;
public class Updateuserviewcontroller {
    @FXML private TextField Uid;
    @FXML private TextField Uname;
    @FXML private TextField Uaccount;
    @FXML private TextField Upassword;
    @FXML private RadioButton Upower1;
    @FXML private RadioButton Upower2;
    @FXML
    public void updateuser()
    {
        Querycontroller q=new Querycontrollerimp();
        Updatecontroller u=new Updatecontrollerimp();
        String power="traveler";
        if(Upower1.isSelected()){power="manager";}
        u.updateuser(new User(Uid.getText(),Uname.getText(),Uaccount.getText(),Upassword.getText(),power),q.queryuser(Uid.getText()));
        new Scenes().usermanagescene();
    }
    @FXML public void backtosystem(ActionEvent event)
    {
        new Scenes().usermanagescene();
    }
}
