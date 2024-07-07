package main.java.com.jsu.view.manager.personalcenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.java.com.jsu.controller.update.Updatecontroller;
import main.java.com.jsu.controller.update.Updatecontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.view.scenes.Scenes;
public class Centerviewcontroller {
    @FXML
    Label account;
    @FXML
    TextField name;
    @FXML TextField password;
    @FXML Label power;
    Monitor monitor=new Monitor();
    Updatecontroller u=new Updatecontrollerimp();
    @FXML
    public void backtosystem()
    {
        new Scenes().managerscene();
    }
    @FXML public void backtolog(ActionEvent event){monitor.droptable();new Scenes().logscene();}
    public void initialize()
    {
        User user=monitor.getuser();
        this.name.setText(user.getName());
        this.account.setText(user.getAccount());
        this.password.setText(user.getPassword());
        this.power.setText(user.getPower());
    }
    @FXML public void updateuser(ActionEvent event)
    {
        User olduser=monitor.getuser();
        User newuser=new User(olduser.getId(),name.getText(),olduser.getAccount(),password.getText(),olduser.getPower());
        u.updateuser(newuser,olduser);
        monitor.updateuser(olduser,newuser);
        new Scenes().managercenter();
    }
}
