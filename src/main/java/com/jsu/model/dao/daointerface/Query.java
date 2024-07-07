package main.java.com.jsu.model.dao.daointerface;
import main.java.com.jsu.model.models.user.User;
import java.util.HashMap;

public interface Query<T> {
    T query(T object);
    T query(String objectid);
    HashMap<String, T> queryall();
}
