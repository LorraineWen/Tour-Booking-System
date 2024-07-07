package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
public class Queryorderimp implements Query<Order> {
    public Order query(Order order)
    {
        Order o=null;
        String sql="select*from tourbookingsystem.orders where id=?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,order.getId());
            ResultSet re=pstat.executeQuery();
            while(re.next())
            {
                o=new Order(re.getString("id"),re.getString("routeid"),re.getString("userid"),re.getString("date"));

            }
            re.close();
            pstat.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return o;
    }
    public Order query(String orderid)
    {
        Order o=null;
        String sql="select*from tourbookingsystem.orders where id=?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,orderid);
            ResultSet re=pstat.executeQuery();
            while(re.next())
            {
                o=new Order(re.getString("id"),re.getString("userid"),re.getString("routeid"),re.getString("date"));

            }
            re.close();
            pstat.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return o;
    }
    public HashMap<String ,Order> queryall()
    {
        HashMap<String,Order> order=null;
        String sql="select*from tourbookingsystem.orders";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
            ResultSet re=stat.executeQuery(sql);
          if(re!=null)
          {
              order=new HashMap<String,Order>();
              while(re.next())
              {
                  order.put(re.getString("id"),new Order(re.getString("id"),re.getString("userid"),re.getString("routeid"),re.getString("date")));

              }
          }
          re.close();
          stat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return order;
    }
}
