package main.java.com.jsu.view.traveler.orderdisplay;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.model.models.order.Orderdisplay;
import main.java.com.jsu.view.scenes.Scenes;
import main.java.com.jsu.view.traveler.orderscene.Orderviewcontroller;
import java.util.HashMap;
public class Orderdisplayviewcontroller {
    @FXML TableView<Orderdisplay> tableView;
    @FXML TableColumn<Orderdisplay,String> Tid;
    @FXML TableColumn<Orderdisplay,String> Tuser;
    @FXML TableColumn<Orderdisplay,String> Tname;
    @FXML TableColumn<Orderdisplay,String> Tways;
    @FXML TableColumn<Orderdisplay,String> Tdepiction;
    @FXML TableColumn<Orderdisplay,String> Ttime;
    @FXML TableColumn<Orderdisplay,String> Tprice;
    @FXML TableColumn<Orderdisplay,String> Tdate;
    Monitor m=new Monitor();
    Querycontroller q=new Querycontrollerimp();
    @FXML
    public void initialize()
    {
        Tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Tuser.setCellValueFactory(new PropertyValueFactory<>("user"));
        Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tways.setCellValueFactory(new PropertyValueFactory<>("ways"));
        Tdepiction.setCellValueFactory(new PropertyValueFactory<>("depiction"));
        Ttime.setCellValueFactory(new PropertyValueFactory<>("time"));
        Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.getItems().clear();
        User u=m.getuser();
        HashMap<String, Order> order=q.queryallorder();
        for(String key:order.keySet())
        {
            if(order.get(key).getUserid().equals(u.getId()))
            {
                Route r=q.queryroute(order.get(key).getRouteid());
                if(r!=null)
                {
                    Orderdisplay o=new Orderdisplay(key,u.getName()+"     "+u.getAccount(),r.getName(),r.getWays(),r.getDepiction(),r.getPrice().toString(),r.getTime(),order.get(key).getDate());
                    tableView.getItems().add(o);

                }
            }
        }
        tableView.setOnMouseClicked(event1->{
            if(event1.getClickCount()==1&&!tableView.getSelectionModel().isEmpty())
            {
                Orderviewcontroller o=new Scenes().orderscene();
                Orderdisplay orderdisplay=tableView.getSelectionModel().getSelectedItem();
                o.setorderscene(orderdisplay);
            }
        });
    }
    public void backtosystem()
    {
        new Scenes().travelerscene();
    }
}
