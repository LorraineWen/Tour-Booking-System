package main.java.com.jsu.controller.update;

import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;

public interface Updatecontroller {
    void updateorder(Order order,Order oldorder);
    void updateuser(User user,User olduser);
    void updateroute(Route route,Route oldroute);
}
