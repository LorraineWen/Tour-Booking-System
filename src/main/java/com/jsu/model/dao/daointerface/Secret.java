package main.java.com.jsu.model.dao.daointerface;

public interface Secret {
    boolean judge(String key);
    void createkey();
}
