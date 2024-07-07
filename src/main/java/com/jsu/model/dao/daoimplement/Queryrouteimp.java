package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
public class Queryrouteimp implements Query<Route> {
    public Route query(Route route)
    {
        Route r=null;
        String sql="select*from tourbookingsystem.route where id=?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,route.getId());
            ResultSet re=pstat.executeQuery();
            while(re.next())
            {
                r=new Route(re.getString("id"),re.getString("name"),re.getString("ways"),re.getString("depiction"),re.getInt("price"),re.getString("time"));
            }
            re.close();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return r;
    }
    public Route query(String routeid)
    {
        Route r=null;
        String sql="select*from tourbookingsystem.route where id=?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,routeid);
            ResultSet re=pstat.executeQuery();
            while(re.next())
            {
                r=new Route(re.getString("id"),re.getString("name"),re.getString("ways"),re.getString("depiction"),re.getInt("price"),re.getString("time"));
            }
            re.close();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return r;
    }
    public HashMap<String,Route> queryall()
    {
        HashMap<String,Route> route=null;
        String sql="select*from tourbookingsystem.route";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
            ResultSet re=stat.executeQuery(sql);
            if(re!=null)
            {
                route=new HashMap<String,Route>();
                while(re.next())
                {
                    route.put(re.getString("id"),new Route(re.getString("id"),re.getString("name"),re.getString("ways"),re.getString("depiction"),re.getInt("price"),re.getString("time")));

                }
            }
            re.close();
            stat.close();
        }
        catch (SQLException e)
        {

            e.printStackTrace();

        }
        return route;
    }
    public HashMap<String,Route> queryrelevant(String key)
    {
        HashMap<String,Route >route=null;
        String sql="select*from tourbookingsystem.route where name like ?";
        PreparedStatement pstat=JDBCutil.getPreparedStatement(sql);
        try
        {
            pstat.setString(1,"%"+key+"%");
            ResultSet re=pstat.executeQuery();
            if(re!=null)
            {
                route=new HashMap<>();
                while(re.next())
                {
                    route.put(re.getString("id"),new Route(re.getString("id"),re.getString("name"),re.getString("ways"),re.getString("depiction"),re.getInt("price"),re.getString("time")));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return route;
    }
}
