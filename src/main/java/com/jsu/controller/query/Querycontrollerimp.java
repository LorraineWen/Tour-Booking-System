package main.java.com.jsu.controller.query;
import main.java.com.jsu.model.dao.daoimplement.Queryorderimp;
import main.java.com.jsu.model.dao.daoimplement.Queryrouteimp;
import main.java.com.jsu.model.dao.daoimplement.Queryuserimp;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.models.order.Order;
import main.java.com.jsu.model.models.route.Route;
import main.java.com.jsu.model.models.user.User;
import java.util.HashMap;

public class Querycontrollerimp<T> implements Querycontroller<T>{
    private Query q;
    public Order  queryorder(T object)
    {
        q=new Queryorderimp();
        if(object instanceof String){return (Order)q.query(object.toString());}
        //在调用query前强制将object转化为Order类型，会报字符串不能转化的错误
        return (Order)q.query(object);
    }
    public HashMap<String,Order> queryallorder()
    {
        q=new Queryorderimp();
        return q.queryall();
    }
    public User queryuser(T object) {
        q = new Queryuserimp();
        if(object instanceof String){return  (User)q.query(object.toString());}
        return (User) q.query(object);
    }
    public HashMap<String,User> queryalluser()
    {
        q=new Queryuserimp();
        return q.queryall();
    }
    public Route queryroute(T object)
    {
        q=new Queryrouteimp();
        if(object instanceof String){return (Route)q.query(object.toString());}
        else{return  (Route)q.query(object);}
    }
    public HashMap<String,Route> queryallroute()
    {
        q=new Queryrouteimp();
        return q.queryall();
    }
    public HashMap<String,Route> queryrelevantroute(String key)
    {
        return new Queryrouteimp().queryrelevant(key);
    }
}
