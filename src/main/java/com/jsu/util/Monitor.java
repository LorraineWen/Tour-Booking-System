package main.java.com.jsu.util;
import main.java.com.jsu.model.models.user.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Monitor {
    public void createtable()
    {
        String sql="create table if not exists presentuser(id varchar(36),name varchar(100),account varchar(11),password varchar(16),power varchar(20))";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
            stat.execute(sql);
            stat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void droptable()
    {
        createtable();//防止登录前数据库并未创建
        String sql="drop table tourbookingsystem.presentuser";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
            stat.execute(sql);
            stat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void record(User user)
    {
        String sql="insert into tourbookingsystem.presentuser(id,name,account,password,power)values(?,?,?,?,?)";
        PreparedStatement pstat=JDBCutil.getPreparedStatement(sql);
        try
        {
            pstat.setString(1,user.getId());
            pstat.setString(2,user.getName());
            pstat.setString(3,user.getAccount());
            pstat.setString(4,user.getPassword());
            pstat.setString(5,user.getPower());
            pstat.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public User getuser()
    {
        User u=null;
        String sql="select*from tourbookingsystem.presentuser";
        Statement stat=JDBCutil.getStatement(sql);
        try
        {
           ResultSet re= stat.executeQuery(sql);
           while(re.next())
           {
               u=new User(re.getString("id"),re.getString("name"),re.getString("account"),re.getString("password"),re.getString("power"));

           }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return u;
    }
    public void updateuser(User olduser,User newuser)
    {
        String sql1="select*from tourbookingsystem.presentuser where id=?;";
        String sql2="update tourbookingsystem.presentuser set name=?,account=?,password=?,power=? where id=?";
        try
        {
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
