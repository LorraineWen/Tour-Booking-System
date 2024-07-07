package main.java.com.jsu.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class JDBCutil {
    private static String driver;
    private static String url;//static属性是属于类本身的而非类产生的对象
    private static String username;//static属性在类加载时进行初始化，并且只会初始化一次
    private static String password;// 使用static属性可以避免每个实例对象都保存一份相同的连接信息，从而节省了内存空间
    static//静态语句块在类加载时执行，且在整个应用程序生命周期中只执行一次，静态语句块可以在数据库连接之前运行
    {
       try
       {
           InputStream ins=JDBCutil.class.getClassLoader().getResourceAsStream("main\\java\\com\\jsu\\util\\JDBCutil.properties");
           Properties prop=new Properties();
           prop.load(ins);
           driver=prop.getProperty("driver");
           url=prop.getProperty("url");
           username=prop.getProperty("username");
           password=prop.getProperty("password");
           Class.forName(driver);
       }
       catch (ClassNotFoundException e)
       {
           e.printStackTrace();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            con=DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public static PreparedStatement getPreparedStatement(String sql)
    {
        PreparedStatement pstat=null;
        try
        {
            pstat=DriverManager.getConnection(url,username,password).prepareStatement(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pstat;
    }
    public static Statement getStatement(String sql)
    {
        Statement stat=null;
        try
        {
            Connection con=DriverManager.getConnection(url,username,password);
            stat=con.prepareStatement(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return stat;
    }
}
