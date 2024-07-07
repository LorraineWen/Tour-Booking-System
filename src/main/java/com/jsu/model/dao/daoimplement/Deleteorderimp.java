package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Delete;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Deleteorderimp implements Delete<Order> {
    public Order delete(Order order)
    {
        if(order==null){return order;}
        String sql1="delete from tourbookingsystem.orders where id=?";
        String sql2="select *from tourbookingsystem.orders where id=?";
        Order o=null;
        try
        {
            PreparedStatement pstat2=JDBCutil.getPreparedStatement(sql2);
            pstat2.setString(1,order.getId());
            ResultSet re=pstat2.executeQuery();
            while(re.next()){ o=new Order(re.getString("id"),re.getString("userid"),re.getString("routeid"),re.getString("date"));}
            PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
            pstat1.setString(1,order.getId());
            pstat1.executeUpdate();
            re.close();
            pstat2.close();
            pstat1.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return o;
    }
}
