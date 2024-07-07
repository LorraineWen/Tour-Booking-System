package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Delete;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Deleteuserimp implements Delete<User> {
    public User delete(User user) {
        if(user==null){return user;}
        String sql1="select *from tourbookingsystem.user where id=?";
        String sql2="delete from tourbookingsystem.user where id=?";
        User u=null;
        try
        {
            PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
            pstat1.setString(1,user.getId());
            ResultSet re=pstat1.executeQuery();
            while(re.next()){ u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),re.getString("power"));}
            PreparedStatement pstat2= JDBCutil.getPreparedStatement(sql2);
            pstat2.setString(1,user.getId());
            pstat2.executeUpdate();
            re.close();
            pstat2.close();
            pstat1.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
}
