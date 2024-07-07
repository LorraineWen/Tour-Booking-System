package main.java.com.jsu.controller.authentication;

import main.java.com.jsu.model.models.user.User;

public interface Identifycontroller {
    User log(User user);
    boolean register(User user);
    boolean judgekey(String key);
    void createkey();
}
