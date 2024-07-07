package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Add;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Addrouteimp implements Add<Route> {
    public void add(Route route)
    {
        String sql="insert into tourbookingsystem.route (id,name,ways,depiction,price,time) values(?,?,?,?,?,?)";
        PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
        try
        {
            pstat.setString(1,route.getId());
            pstat.setString(2,route.getName());
            pstat.setString(3,route.getWays());
            pstat.setString(4,route.getDepiction());
            pstat.setInt(5,route.getPrice());
            pstat.setString(6,route.getTime());
            pstat.executeUpdate();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
