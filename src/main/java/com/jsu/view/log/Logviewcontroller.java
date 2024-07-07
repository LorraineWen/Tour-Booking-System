package main.java.com.jsu.view.log;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.authentication.Identifycontroller;
import main.java.com.jsu.controller.authentication.Identifycontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.Exitalert;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.view.scenes.Scenes;
public class Logviewcontroller {
    @FXML private TextField password;
    @FXML private TextField account;
    @FXML private Label error;
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
    @FXML public void log(ActionEvent event)
    {
        Monitor monitor=new Monitor();
        Identifycontroller a=new Identifycontrollerimp();
        if(account.getText().isEmpty()){error.setText("账号不能为空");error.setOpacity(1.0);}
        else if(password.getText().isEmpty()){error.setText("密码不能为空");error.setOpacity(1.0);}
        else
        {
            User user=a.log(new User("default","default",account.getText(),password.getText(),"default"));
            if(user==null)
            {
                error.setText("您的账号或密码错误请重新输入");
                error.setOpacity(1.0);
                password.clear();
                account.clear();
            }
            else if(user.getPower().equals("traveler"))
            {
                monitor.createtable();
                monitor.record(user);
               new Scenes().travelerscene();
            }
            else if(user.getPower().equals("manager"))
            {
                monitor.createtable();
                monitor.record(user);
               new Scenes().managerscene();
            }
        }
        timeline.setCycleCount(1);
        timeline.play();
    }
    @FXML public void toregister(ActionEvent event)
    {
        new Scenes().registerscene();
    }
    @FXML public void exitsystem()
    {
        new Exitalert().alertexit();
    }
}
