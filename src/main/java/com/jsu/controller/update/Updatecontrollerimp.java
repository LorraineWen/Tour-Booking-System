package main.java.com.jsu.controller.update;

import main.java.com.jsu.model.dao.daoimplement.Updateorderimp;
import main.java.com.jsu.model.dao.daoimplement.Updaterouteimp;
import main.java.com.jsu.model.dao.daoimplement.Updateuserimp;
import main.java.com.jsu.model.dao.daointerface.Update;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;

public class Updatecontrollerimp implements Updatecontroller{
    private Update u;
    public void updateorder(Order order, Order oldorder)
    {
     u=new Updateorderimp();
     u.update(order,oldorder);
    }
    public void updateuser(User user,User olduser)
    {
        u=new Updateuserimp();
        u.update(user,olduser);
    }
    public void updateroute(Route route,Route oldroute)
    {
        u=new Updaterouteimp();
        u.update(route,oldroute);
    }
}
