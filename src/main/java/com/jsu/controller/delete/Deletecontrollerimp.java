package main.java.com.jsu.controller.delete;
import main.java.com.jsu.model.dao.daoimplement.Deleteorderimp;
import main.java.com.jsu.model.dao.daoimplement.Deleterouteimp;
import main.java.com.jsu.model.dao.daoimplement.Deleteuserimp;
import main.java.com.jsu.model.dao.daointerface.Delete;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;
public class Deletecontrollerimp implements Deletecontroller {
    private Delete d;
    public Order deleteorder(Order order)
    {
        d=new Deleteorderimp();
        return (Order)d.delete(order);
    }
    public User deleteuser(User user)
    {
        d=new Deleteuserimp();
        return (User)d.delete(user);
    }
    public Route deleteroute(Route route)
    {
        d=new Deleterouteimp();
        return (Route)d.delete(route);
    }
}
