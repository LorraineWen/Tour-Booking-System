package main.java.com.jsu.view.manager.ordermanage.addorder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.add.Addcontroller;
import main.java.com.jsu.controller.add.Addcontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.UUID;
public class Addorderviewcontroller {
    @FXML private TextField AUid;
    @FXML private TextField ARid;
    @FXML private DatePicker Adate;
    @FXML private Label error;
    @FXML
    public void addorder()
    {
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
        if(AUid.getText().isEmpty()){error.setText("用户id不能为空");error.setOpacity(1.0);}
        else if(ARid.getText().isEmpty()){error.setText("路线id不能为空");error.setOpacity(1.0);}
        else if(Adate.getValue()==null){error.setText("请选择日期");error.setOpacity(1.0);}
        else
        {
            Addcontroller a = new Addcontrollerimp();
            a.addorder(new Order(UUID.randomUUID().toString(), AUid.getText(), ARid.getText(),Adate.getValue().toString()));
            new Scenes().ordermanagescene();
        }
        timeline.setCycleCount(1);
        timeline.play();
    }
    @FXML
    public  void backtosystem()
    {
        new Scenes().ordermanagescene();
    }
}
