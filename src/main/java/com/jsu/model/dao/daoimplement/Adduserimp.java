package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Add;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Adduserimp implements Add<User> {
    public void add(User user)
    {
        Query<User> q=new Queryuserimp();
        if(q.query(user)!=null){return;}
        String sql="insert into tourbookingsystem.user (id,name,account,password,power) values(?,?,?,?,?)";
        PreparedStatement pstat= JDBCutil.getPreparedStatement(sql);
        try
        {
            pstat.setString(1,user.getId());
            pstat.setString(2,user.getName());
            pstat.setString(3,user.getAccount());
            pstat.setString(4,user.getPassword());
            pstat.setString(5,user.getPower());
            pstat.execute();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
