package main.java.com.jsu.controller.delete;

import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;

public interface Deletecontroller {
    Order deleteorder(Order order);
    User deleteuser(User user);
    Route deleteroute(Route route);
}
