package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Delete;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Deleterouteimp implements Delete<Route> {
    public Route delete(Route route) {
        if (route == null) {
            return route;
        }
        String sql1="select *from tourbookingsystem.route where id=?";
        String sql2="delete from tourbookingsystem.route where id=?";
        Route r=null;
        try
        {
            PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
            pstat1.setString(1,route.getId());
            ResultSet re=pstat1.executeQuery();
            while(re.next()){ r=new Route(re.getString("id"),re.getString("name"),re.getString("ways"),re.getString("depiction"),re.getInt("price"),re.getString("time"));}
            PreparedStatement pstat2= JDBCutil.getPreparedStatement(sql2);
            pstat2.setString(1,route.getId());
            pstat2.executeUpdate();
            re.close();
            re.close();
            pstat2.close();
            pstat1.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return r;
    }
}
