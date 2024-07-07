package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Update;
import main.java.com.jsu.model.models.user.User;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Updateuserimp implements Update<User> {
    public void update(User newuser,User olduser)
    {
    String sql1="select*from tourbookingsystem.user where id=?;";
    String sql2="update tourbookingsystem.user set name=?,account=?,password=?,power=? where id=?";
   try
    {
        if(olduser==null){return;}
        PreparedStatement pstat1= JDBCutil.getPreparedStatement(sql1);
        pstat1.setString(1,olduser.getId());
        ResultSet re=pstat1.executeQuery();
        while(re.next())
        {
            if(newuser.getName().isEmpty()){newuser.setName(re.getString("name"));}
            if(newuser.getAccount().isEmpty()){newuser.setAccount(re.getString("account"));}
            if(newuser.getPassword().isEmpty()){newuser.setPassword(re.getString("password"));}
            if(newuser.getPower().isEmpty()){newuser.setPower(re.getString("power"));}
        }
        PreparedStatement pstat2=JDBCutil.getPreparedStatement(sql2);
        pstat2.setString(1,newuser.getName());
        pstat2.setString(2,newuser.getAccount());
        pstat2.setString(3,newuser.getPassword());
        pstat2.setString(4,newuser.getPower());
        pstat2.setString(5,olduser.getId());
        pstat2.execute();
        re.close();
        pstat1.close();
        pstat2.close();
    }
   catch (
           SQLException e)
   {
       e.printStackTrace();
   }
}
}
