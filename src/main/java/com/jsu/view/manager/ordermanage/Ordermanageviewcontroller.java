package main.java.com.jsu.view.manager.ordermanage;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.jsu.controller.delete.Deletecontroller;
import main.java.com.jsu.controller.delete.Deletecontrollerimp;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.HashMap;
public class Ordermanageviewcontroller {
    @FXML private TableView tableView;
    @FXML private TableColumn<Order,String> TOid;
    @FXML private TableColumn<Order,String> TUid;
    @FXML private TableColumn<Order,String> TRid;
    @FXML private TableColumn<Order,String> Tdate;
    @FXML private TextField QOid;
    @FXML private TextField DOid;
    Querycontroller q=new Querycontrollerimp();
    public void initialize()
    {
        TOid.setCellValueFactory(new PropertyValueFactory<>("id"));
        TUid.setCellValueFactory(new PropertyValueFactory<>("userid"));
        TRid.setCellValueFactory(new PropertyValueFactory<>("routeid"));
        Tdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        HashMap<String,Order> o=q.queryallorder();
        tableView.getItems().clear();
        for(String key:o.keySet())
        {
            tableView.getItems().add(o.get(key));
        }
    }
    @FXML public void addorderscene()
    {
        new Scenes().addorderscene();
    }
    @FXML public void queryorder()
    {
        tableView.getItems().clear();
        Order o=q.queryorder(QOid.getText());
        tableView.getItems().add(o);
    }
    @FXML public void updateorderscene()
    {
        new Scenes().updateorderscene();
    }
    @FXML public void deleteorder()
    {
        Deletecontroller d=new Deletecontrollerimp();
        d.deleteorder(q.queryorder(DOid.getText()));
        initialize();
    }

}
