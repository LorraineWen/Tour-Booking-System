package main.java.com.jsu.controller.query;

import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;

import java.sql.ResultSet;
import java.util.HashMap;

public interface Querycontroller<T> {
    Order queryorder(T object);
    HashMap<String,Order>queryallorder();
    User queryuser(T object);
    HashMap<String,User> queryalluser();
    Route queryroute(T object);
    HashMap<String,Route>queryallroute();
    HashMap<String,Route>queryrelevantroute(String key);
}
