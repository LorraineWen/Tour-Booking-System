package main.java.com.jsu.view.traveler.orderscene;
import com.mysql.cj.util.StringUtils;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.java.com.jsu.controller.delete.Deletecontroller;
import main.java.com.jsu.controller.delete.Deletecontrollerimp;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.controller.update.Updatecontroller;
import main.java.com.jsu.controller.update.Updatecontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.model.models.order.Orderdisplay;
import main.java.com.jsu.view.scenes.Scenes;
public class Orderviewcontroller {
    @FXML Label id;
    @FXML Label user;
    @FXML TextField name;
    @FXML TextField ways;
    @FXML TextArea depiction;
    @FXML Label time;
    @FXML Label price;
    @FXML Label date;
    @FXML Label error;
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> error.setOpacity(0.0)));
    Monitor m=new Monitor();
    Querycontroller q=new Querycontrollerimp();
    Deletecontroller d=new Deletecontrollerimp();
    Updatecontroller u=new Updatecontrollerimp();
    @FXML
    public void setorderscene(Orderdisplay o)
    {
        id.setText(o.getId());
        user.setText(o.getUser());
        name.setText(o.getName());
        ways.setText(o.getWays());
        depiction.setText(o.getDepiction());
        price.setText(o.getPrice());
        time.setText(o.getTime());
        date.setText(o.getDate());
    }
    @FXML
    public void cancelorder()
    {
        d.deleteorder(q.queryorder(id.getText()));
        new Scenes().orderdisplayview();
    }
    @FXML
    public void updateorder()
    {
        error.setStyle("-fx-background-color: hotpink;-fx-alignment: center;-fx-font:15px bolder");
        if(!StringUtils.isStrictlyNumeric(time.getText())){error.setText("时间必须为数字");error.setOpacity(1.0);}
        else if(!StringUtils.isStrictlyNumeric(price.getText())){error.setText("价格必须为数字");error.setOpacity(1.0);}
       else
            {
                Order neworder=q.queryorder(id.getText());
                Route oldroute=q.queryroute(neworder.getRouteid());
                Route newroute=new Route(oldroute.getId(),name.getText(),ways.getText(),depiction.getText(),Integer.valueOf(price.getText()).intValue(),time.getText());
                u.updateroute(newroute,oldroute);
                new Scenes().orderdisplayview();
            }
       timeline.setCycleCount(1);
       timeline.play();
    }
    public void backtosystem()
    {
        new Scenes().travelerscene();
    }
}
