package main.java.com.jsu.view.manager.usermanage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.jsu.controller.delete.Deletecontroller;
import main.java.com.jsu.controller.delete.Deletecontrollerimp;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.view.scenes.Scenes;
import java.util.HashMap;
public class Usermanageviewcontroller {
    @FXML private TableView<User> tableView;
    @FXML private TableColumn<User,String> Tid;
    @FXML private TableColumn<User,String> Tname;
    @FXML private TableColumn<User,String> Taccount;
    @FXML private TableColumn<User,String> Tpassword;
    @FXML private TableColumn<User,String> Tpower;
    @FXML private TextField Qid;
    @FXML private TextField Did;
    Querycontroller q=new Querycontrollerimp();
    public void initialize()
    {
        Tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Taccount.setCellValueFactory(new PropertyValueFactory<>("account"));
        Tpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        Tpower.setCellValueFactory(new PropertyValueFactory<>("power"));
        tableView.getItems().clear();
        Querycontroller q=new Querycontrollerimp();
        HashMap<String,User> elements=q.queryalluser();
        for(String key:elements.keySet())
        {
            tableView.getItems().add(elements.get(key));
        }
    }
    @FXML
    public void queryuser(ActionEvent event)
    {

        User user=q.queryuser(Qid.getText());
        tableView.getItems().clear();
        if(user!=null)
        {
            tableView.getItems().add(user);
        }
    }
    @FXML
    public void deleteuser(ActionEvent event)
        {
            Deletecontroller d=new Deletecontrollerimp();
            d.deleteuser(q.queryuser(Did.getText()));
            initialize();
        }
        @FXML
    public void updateuser(ActionEvent event)
        {
            new Scenes().updateuserscene();
        }
        @FXML
    public void adduserscene(ActionEvent event)
        {
            new Scenes().adduserscene();
        }
}
