package main.java.com.jsu.view.traveler.choseroute;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.java.com.jsu.controller.add.Addcontroller;
import main.java.com.jsu.controller.add.Addcontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.view.scenes.Scenes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
public class Choserouteviewcontroller {
    @FXML private Label id;
    @FXML private Label name;
    @FXML private Label ways;
    @FXML private TextArea depiction;
    @FXML private  Label time;
    @FXML private Label price;
    private String rid;
    Monitor m=new Monitor();
    Date date=new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strTime = sdf.format(date.getTime());
    public void routescene(Route r)
    {
        this.name.setText(r.getName());
        this.ways .setText(r.getWays());
        this.depiction .setText(r.getDepiction());
        this.time.setText(r.getTime());
        this.price.setText(r.getPrice().toString());
        this.rid=r.getId();
        this.id.setText(r.getId());
    }
    @FXML
    public void backtosystem(ActionEvent event)
    {
        new Scenes().travelerscene();
    }
    @FXML
    public void placeorder(ActionEvent event)
    {
        Addcontroller a=new Addcontrollerimp();
        a.addorder(new Order(UUID.randomUUID().toString(),m.getuser().getId(),rid,strTime));
        new Scenes().travelerscene();
    }
}
