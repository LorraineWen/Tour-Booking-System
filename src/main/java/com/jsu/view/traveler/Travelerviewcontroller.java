package main.java.com.jsu.view.traveler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.Exitalert;
import main.java.com.jsu.view.scenes.Scenes;
import main.java.com.jsu.view.traveler.choseroute.Choserouteviewcontroller;
import java.util.HashMap;
public class Travelerviewcontroller
{
    @FXML TableView tableView;
    @FXML TableColumn<Route,String> Tid;
    @FXML TableColumn<Route,String> Tname;
    @FXML TableColumn<Route,String> Tways;
    @FXML TableColumn<Route,String> Tdepiction;
    @FXML TableColumn<Route,String> Tprice;
    @FXML TableColumn<Route,String> Ttime;
    @FXML TextField Qname;
    Querycontroller q=new Querycontrollerimp();
public void initialize()
{
    Tid.setCellValueFactory(new PropertyValueFactory<>("id"));
    Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
    Tways.setCellValueFactory(new PropertyValueFactory<>("ways"));
    Tdepiction.setCellValueFactory(new PropertyValueFactory<>("depiction"));
    Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
    Ttime.setCellValueFactory(new PropertyValueFactory<>("time"));
    tableView.getItems().clear();
    HashMap<String,Route> route=q.queryallroute();
    for(String key:route.keySet())
    {
        tableView.getItems().add(route.get(key));
    }
    tableView.setOnMouseClicked(event1->{
        if(event1.getClickCount()==1&&!tableView.getSelectionModel().isEmpty())
        {
            Route r=(Route)tableView.getSelectionModel().getSelectedItem();
              Choserouteviewcontroller  controller=new Scenes().choseroutescene();
                controller.routescene(r);
        }
    });
}
@FXML
public void searchroute(ActionEvent event)
{
    tableView.getItems().clear();
    HashMap<String,Route> r=q.queryrelevantroute(Qname.getText());
    for(String key:r.keySet())
    {
        tableView.getItems().add(r.get(key));
    }
}
@FXML
public void orderscene(ActionEvent event)
{
new Scenes().orderdisplayview();
}
@FXML
    public void display(ActionEvent event)
{
    new Scenes().travelerscene();
}
@FXML public void exitsystem(ActionEvent event){new Exitalert().alertexit();}
}
