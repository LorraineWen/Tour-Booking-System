package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Log;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Logimp implements Log {
    public User log(User user)
    {
        String sql="select*from tourbookingsystem.user where (account=? or name=?) and password=?";
        User u=null;
        try
        {
            PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
            pstat.setString(1,user.getAccount());
            pstat.setString(2,user.getName());
            pstat.setString(3,user.getPassword());
            ResultSet re=pstat.executeQuery();
                if(re==null)return u;
                while(re.next())
                {
                    if(re.getString("power").equals("manager")){return u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),"manager");}
                    else if(re.getString("power").equals("traveler")){return u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),"traveler");}
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
}
