package main.java.com.jsu.controller.add;
import main.java.com.jsu.model.dao.daoimplement.Addorderimp;
import main.java.com.jsu.model.dao.daoimplement.Addrouteimp;
import main.java.com.jsu.model.dao.daoimplement.Adduserimp;
import main.java.com.jsu.model.dao.daointerface.Add;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;
public class Addcontrollerimp implements Addcontroller
{
    private Add a;
   public void addorder(Order order)
    {
        a=new Addorderimp();
        a.add(order);
    }
    public void adduser(User user)
    {
        a=new Adduserimp();
        a.add(user);
    }
    public void addroute(Route route)
    {
        a=new Addrouteimp();
        a.add(route);
    }
}
