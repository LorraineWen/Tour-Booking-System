package main.java.com.jsu.view.manager.routemanage;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.jsu.controller.delete.Deletecontroller;
import main.java.com.jsu.controller.delete.Deletecontrollerimp;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.HashMap;
public class Routemanageviewcontroller {
    @FXML private TableView tableView;
    @FXML private TableColumn<Route,String> Tid;
    @FXML private TableColumn<Route,String> Tname;
    @FXML private TableColumn<Route,String> Tways;
    @FXML private TableColumn<Route,String> Tdepiction;
    @FXML private TableColumn<Route,String > Ttime;
    @FXML private TableColumn<Route,String> Tprice;
    @FXML private TextField Qid;
    @FXML private TextField Did;
    Querycontroller q=new Querycontrollerimp();
    public void initialize()
    {
        Tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tways.setCellValueFactory(new PropertyValueFactory<>("ways"));
        Tdepiction.setCellValueFactory(new PropertyValueFactory<>("depiction"));
        Ttime.setCellValueFactory(new PropertyValueFactory<>("time"));
        Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView.getItems().clear();
        HashMap<String,Route>r=q.queryallroute();
        for(String key:r.keySet())
        {
            tableView.getItems().add(r.get(key));
        }
    }
    @FXML public void queryroute()
    {
        tableView.getItems().clear();
        Route r=q.queryroute(Qid.getText());
        tableView.getItems().add(r);
    }
    @FXML public void deleteroute() {
        Deletecontroller d=new Deletecontrollerimp();
        d.deleteroute(q.queryroute(Did.getText()));
        initialize();
    }
    @FXML public void addroutescene()
    {
        new Scenes().addroutescene();
    }
    @FXML public void updateroutescene()
    {
        new Scenes().updateroutescene();
    }
}
