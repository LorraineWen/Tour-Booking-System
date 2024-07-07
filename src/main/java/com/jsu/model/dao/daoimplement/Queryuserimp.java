package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
public class Queryuserimp implements Query<User> {
    public User query(User user)
    {
        User u=null;
        String sql="select*from tourbookingsystem.user where id =? or account =?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,user.getId());
            pstat.setString(2,user.getAccount());
            ResultSet re=pstat.executeQuery();
            while(re.next()) {
                u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),re.getString("power"));
            }
            re.close();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
    public User query(String userid)
    {
        User u=null;
        String sql="select*from tourbookingsystem.user where id =? or account =?";
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,userid);
            pstat.setString(2,userid);
            ResultSet re=pstat.executeQuery();
            while(re.next()) {
                u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),re.getString("power"));
            }
            re.close();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
    public HashMap<String,User> queryall()
    {
        HashMap<String,User> user=null;
        String sql="select*from tourbookingsystem.user";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
            ResultSet re=stat.executeQuery(sql);
            if(re!=null)
            {
                user=new HashMap<String,User>();
                while(re.next())
                {
                    user.put(re.getString("id"),new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),re.getString("power")));
                }

            }
            stat.close();
            re.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}
