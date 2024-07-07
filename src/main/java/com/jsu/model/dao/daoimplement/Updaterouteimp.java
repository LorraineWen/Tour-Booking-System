package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Update;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Updaterouteimp implements Update<Route> {
    public void update(Route newroute,Route oldroute)
    {
        String sql1="select*from tourbookingsystem.route where id=?;";
        String sql2="update tourbookingsystem.route set name=?,ways=?,depiction=?,price=?,time=? where id=?";
        try
        {
            if(oldroute==null){return;}
            PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
            pstat1.setString(1,oldroute.getId());
            ResultSet re=pstat1.executeQuery();
            while(re.next())
            {
                if(newroute.getName().isEmpty()){newroute.setName(re.getString("name"));}
                if(newroute.getWays().isEmpty()){newroute.setWays(re.getString("ways"));}
                if(newroute.getPrice()==null){newroute.setPrice(re.getInt("price"));}
                if(newroute.getTime().isEmpty()){newroute.setTime(re.getString("time"));}
                if(newroute.getDepiction().isEmpty()){newroute.setDepiction(re.getString("depiction"));}
            }
            PreparedStatement pstat2=JDBCutil.getPreparedStatement(sql2);
            pstat2.setString(1,newroute.getName());
            pstat2.setString(2,newroute.getWays());
            pstat2.setString(3,newroute.getDepiction());
            pstat2.setInt(4,newroute.getPrice());
            pstat2.setString(5,newroute.getTime());
            pstat2.setString(6,oldroute.getId());
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
