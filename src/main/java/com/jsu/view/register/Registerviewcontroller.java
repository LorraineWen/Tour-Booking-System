package main.java.com.jsu.view.register;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.authentication.Identifycontroller;
import main.java.com.jsu.controller.authentication.Identifycontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.Exitalert;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.UUID;
public class Registerviewcontroller {
 @FXML private TextField name;
    @FXML private TextField account;
    @FXML private TextField password;
    @FXML private TextField secretkey;
    @FXML private Label error;
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
    @FXML public void backtolog() {
        new Scenes().logscene();
    }
    @FXML public void registermanager() {
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");//将提醒信息样式归原来
        if (name.getText().isEmpty()) { error.setText("名称不能为空"); error.setOpacity(1.0);}
        else if (account.getText().isEmpty()) { error.setText("手机号不能为空");error.setOpacity(1.0); }
        else if (password.getText().isEmpty()) { error.setText("密码不能为空");error.setOpacity(1.0);}
        else if(secretkey.getText().isEmpty()){error.setText("密钥不能为空");error.setOpacity(1.0);}
          else {
            Identifycontroller a = new Identifycontrollerimp();
            a.createkey();
            if(a.judgekey(secretkey.getText()))
            {
                boolean judge = a.register(new User(UUID.randomUUID().toString(), name.getText(), account.getText(), password.getText(), "manager"));
                if (judge == false) {
                    error.setText("您输入的账号已存在请重新输入");
                    error.setOpacity(1.0);
                } else {
                    error.setText("注册成功");
                    error.setStyle("-fx-background-color: lime;-fx-alignment: center;-fx-font:15px bolder");
                    error.setOpacity(1.0);
                }
            }
            else {
                error.setText("您输入的密钥不正确");
                error.setOpacity(1.0);
            }
        }
        timeline.setCycleCount(1);
        timeline.play();
        }
        @FXML public void register ()
        {
            if (name.getText().isEmpty()) { error.setText("名称不能为空"); error.setOpacity(1.0);}
            else if (account.getText().isEmpty()) { error.setText("手机号不能为空"); error.setOpacity(1.0);}
            else if (password.getText().isEmpty()) { error.setText("密码不能为空");error.setOpacity(1.0);}
            else {
                Identifycontroller a = new Identifycontrollerimp();
                boolean judge = a.register(new User(UUID.randomUUID().toString(), name.getText(), account.getText(), password.getText(), "traveler"));
                if (judge == false) {
                    error.setText("您输入的账号已存在请重新输入");
                    error.setOpacity(1.0);
                } else {
                    error.setText("注册成功");
                    error.setStyle("-fx-background-color: lime;-fx-alignment: center;-fx-font:15px bolder");
                    error.setOpacity(1.0);
                }
            }
            timeline.setCycleCount(1);
            timeline.play();
            }
    @FXML public void exitsystem()
    {
        new Exitalert().alertexit();
    }
        }
