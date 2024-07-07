package main.java.com.jsu.view.manager.routemanage.addroute;
import com.mysql.cj.util.StringUtils;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.add.Addcontroller;
import main.java.com.jsu.controller.add.Addcontrollerimp;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.UUID;
public class Addrouteviewcontroller {
    @FXML private TextField Aname;
    @FXML private TextField Aways;
    @FXML private TextArea Adepiction;
    @FXML private TextField Aprice;
    @FXML private TextField Atime;
    @FXML private Label error;
    @FXML public void addroute(ActionEvent event)
    {
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
        if(Aname.getText().isEmpty()){error.setText("名称不能为空");error.setOpacity(1.0);}
        else if(Aways.getText().isEmpty()){error.setText("交通方式不能为空");error.setOpacity(1.0);}
        else if(Adepiction.getText().isEmpty()){error.setText("路线描述不能为空");error.setOpacity(1.0);}
        else if(Aprice.getText().isEmpty()){error.setText("路线价格不能为空");error.setOpacity(1.0);}
        else if(Atime.getText().isEmpty()){error.setText("所用时间不能为空");error.setOpacity(1.0);}
        else if(!StringUtils.isStrictlyNumeric(Aprice.getText())){error.setText("价格需要输入数字");error.setOpacity(1.0);}
        else if(!StringUtils.isStrictlyNumeric(Atime.getText())){error.setText("时间需要输入数字");error.setOpacity(1.0);}
        else
        {
            Addcontroller a = new Addcontrollerimp();
            a.addroute(new Route(UUID.randomUUID().toString(), Aname.getText(), Aways.getText(), Adepiction.getText(),Integer.valueOf(Aprice.getText()).intValue(),Atime.getText()));
            new Scenes().routemanagescene();
        }
        timeline.setCycleCount(1);
        timeline.play();
    }
    @FXML public void backtosystem(ActionEvent event)
    {
        new Scenes().routemanagescene();
    }
}
