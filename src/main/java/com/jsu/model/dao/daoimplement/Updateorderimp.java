package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Update;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Updateorderimp implements Update<Order> {
public void update(Order neworder,Order oldorder)
{
    String sql1="select*from tourbookingsystem.orders where id=?;";
    String sql2="update tourbookingsystem.orders set userid=?,routeid=?,date=? where id=?";
   try
   {
       if(oldorder==null){return;}
       PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
       pstat1.setString(1,oldorder.getId());
       ResultSet re=pstat1.executeQuery();
       while(re.next())
       {
           if(neworder.getUserid().isEmpty()){neworder.setId(re.getString("userid"));}
           if(neworder.getRouteid().isEmpty()){neworder.setId(re.getString("routeid"));}
           if(neworder.getDate().isEmpty()){neworder.setId(re.getString("date"));}
       }
       PreparedStatement pstat2=JDBCutil.getPreparedStatement(sql2);
       pstat2.setString(1,neworder.getUserid());
       pstat2.setString(2,neworder.getRouteid());
       pstat2.setString(3,neworder.getDate());
       pstat2.setString(4,oldorder.getId());
       pstat2.execute();
       re.close();
       pstat1.close();
       pstat2.close();
   }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
}
}
