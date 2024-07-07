package main.java.com.jsu.view.manager.ordermanage.updateorder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.java.com.jsu.controller.query.Querycontroller;
import main.java.com.jsu.controller.query.Querycontrollerimp;
import main.java.com.jsu.controller.update.Updatecontroller;
import main.java.com.jsu.controller.update.Updatecontrollerimp;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.view.scenes.Scenes;

public class Updateorderviewcontroller {
        @FXML private TextField UUid;
        @FXML private TextField URid;
        @FXML private TextField UOid;
        @FXML private DatePicker Udate;
        private String date;
        @FXML
        public void updateorder()
        {
            if(UOid.getText().isEmpty()){return;}
            Updatecontroller u=new Updatecontrollerimp();
            Querycontroller q=new Querycontrollerimp();
            if(Udate.getValue()==null)
            {
                date="";
            }
            else
            {
                date=Udate.getValue().toString();
            }
            u.updateorder(new Order(UOid.getText(),UUid.getText(),URid.getText(),date),q.queryorder(UOid.getText()));
            new Scenes().ordermanagescene();
        }
        @FXML public void backtosystem(ActionEvent event)
        {
            new Scenes().usermanagescene();
        }
    }
