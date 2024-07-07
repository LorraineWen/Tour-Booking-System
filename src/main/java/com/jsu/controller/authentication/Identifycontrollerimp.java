package main.java.com.jsu.controller.authentication;
import main.java.com.jsu.model.dao.daoimplement.Logimp;
import main.java.com.jsu.model.dao.daoimplement.Registerimp;
import main.java.com.jsu.model.dao.daoimplement.Secretimp;
import main.java.com.jsu.model.dao.daointerface.Log;
import main.java.com.jsu.model.dao.daointerface.Register;
import main.java.com.jsu.model.dao.daointerface.Secret;
import main.java.com.jsu.model.models.user.User;
public class Identifycontrollerimp implements Identifycontroller {
    Log l;
    Register r;
   Secret s;
    public User log(User user)
    {
        l=new Logimp();
        return l.log(user);
    }
    public boolean register(User user)
    {
        r=new Registerimp();
        return r.register(user);
    }
    public boolean judgekey(String key)
    {
        s=new Secretimp();
        return s.judge(key);
    }
    public void createkey()
    {
        s=new Secretimp();
        s.createkey();
    }
}
