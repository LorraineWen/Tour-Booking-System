package main.java.com.jsu.view.manager.usermanage.adduser;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.add.Addcontroller;
import main.java.com.jsu.controller.add.Addcontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.UUID;
public class Adduserviewcontroller {
    @FXML
    private TextField Aname;
    @FXML
    private TextField Aaccount;
    @FXML
    private TextField Apassword;
    @FXML
    private RadioButton Apower1;
    @FXML
    private RadioButton Apower2;
    @FXML
    private Label error;
    @FXML
    public void adduser(ActionEvent event) {
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
        if(Aname.getText().isEmpty()){error.setText("名称不能为空");error.setOpacity(1.0);}
       else if(Aaccount.getText().isEmpty()){error.setText("账号不能为空");error.setOpacity(1.0);}
       else if(Apassword.getText().isEmpty()){error.setText("密码不能为空");error.setOpacity(1.0);}
      else
        {
            Addcontroller a = new Addcontrollerimp();
            String power = "traveler";
            if (Apower1.isSelected()) {
                power = "manager";
            }
            if (Apower2.isSelected()) {
                power = "traveler";
            }
            a.adduser(new User(UUID.randomUUID().toString(), Aname.getText(), Aaccount.getText(), Apassword.getText(), power));
            new Scenes().usermanagescene();
        }
        timeline.setCycleCount(1);
      timeline.play();
    }
    @FXML public void backtosystem(ActionEvent event)
    {
        new Scenes().usermanagescene();
    }
}