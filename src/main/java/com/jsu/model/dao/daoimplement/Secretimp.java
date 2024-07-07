package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.util.JDBCutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
public class Secretimp implements main.java.com.jsu.model.dao.daointerface.Secret {
    public boolean judge(String key)
    {
        String sql="select*from tourbookingsystem.secretkey";
        Statement stat= JDBCutil.getStatement(sql);
        try
        {
            ResultSet re=stat.executeQuery(sql);
            while(re.next())
            {
                if(re.getString("skey").equals(key))
                {
                    return  true;
                }
            }
            stat.close();
            re.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public  void createkey()
    {
        String sql="insert into tourbookingsystem.secretkey (skey)values(?)";
        PreparedStatement pstat=JDBCutil.getPreparedStatement(sql);
        try
        {
            pstat.setString(1, UUID.randomUUID().toString());
            pstat.execute();
            pstat.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
