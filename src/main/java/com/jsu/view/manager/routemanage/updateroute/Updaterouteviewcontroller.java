package main.java.com.jsu.view.manager.routemanage.updateroute;
import com.mysql.cj.util.StringUtils;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.controller.update.Updatecontroller;
import main.java.com.jsu.controller.update.Updatecontrollerimp;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.view.scenes.Scenes;
public class Updaterouteviewcontroller {
    @FXML private TextField Uname;
    @FXML private TextField Uways;
    @FXML private TextArea Udepiction;
    @FXML private TextField Uprice;
    @FXML private TextField Utime;
    @FXML private TextField Uid;
    @FXML private Label error;
    @FXML
    public void updateroute()
    {
        if(Uid.getText().isEmpty()){return;}
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
            if(!StringUtils.isStrictlyNumeric(Uprice.getText())&&!Uprice.getText().isEmpty()){error.setText("价格需要输入数字");error.setOpacity(1.0);}
    else if(!StringUtils.isStrictlyNumeric(Utime.getText())&&!Utime.getText().isEmpty()){error.setText("时间需要输入数字");error.setOpacity(1.0);}
       else
            {
                Querycontroller q=new Querycontrollerimp();
                Integer price=null;
                String time="";
                if(!Uprice.getText().isEmpty()){price=Integer.valueOf(Uprice.getText()).intValue();}
                if(!Utime.getText().isEmpty()){time=Utime.getText();}
                Updatecontroller u=new Updatecontrollerimp();
                u.updateroute(new Route(Uid.getText(),Uname.getText(),Uways.getText(),Udepiction.getText(),price,time),q.queryroute(Uid.getText()));
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
