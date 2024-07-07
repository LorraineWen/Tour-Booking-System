package main.java.com.jsu.controller.add;

import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;

public interface Addcontroller{
    void addorder(Order order);
     void adduser(User user);
     void addroute(Route route);
}
