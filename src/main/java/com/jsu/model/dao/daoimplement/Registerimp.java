package main.java.com.jsu.model.dao.daoimplement;
import main.java.com.jsu.model.dao.daointerface.Add;
import main.java.com.jsu.model.dao.daointerface.Query;
import main.java.com.jsu.model.dao.daointerface.Register;
import main.java.com.jsu.model.models.user.User;
public class Registerimp implements Register {
    public boolean register(User user)
    {
        Query<User> q=new Queryuserimp();
        if(q.query(user)!=null){return false;}
        Add<User> a=new Adduserimp();
        a.add(user);
        return true;
    }
}
