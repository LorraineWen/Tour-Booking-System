package main.java.com.jsu.model.dao.daointerface;

public interface Update<T> {
    void update(T newobject,T oldobject);
}
