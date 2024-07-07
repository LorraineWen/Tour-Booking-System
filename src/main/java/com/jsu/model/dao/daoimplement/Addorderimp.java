package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Add;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Addorderimp implements Add<Order> {
public void add(Order order)
{
    String sql="insert into tourbookingsystem.orders (id,userid,routeid,date) values(?,?,?,?)";
    PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
   try
   {
       pstat.setString(1,order.getId());
       pstat.setString(2,order.getUserid());
       pstat.setString(3,order.getRouteid());
       pstat.setString(4,order.getDate());
       pstat.executeUpdate();
       pstat.close();
   }
   catch (SQLException e)
   {
       e.printStackTrace();
   }
   }
}
