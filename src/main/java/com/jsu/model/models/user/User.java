package main.java.com.jsu.model.models.user;

public class User {
    private String id;
    private String name;
    private String account;
    private String password;
    private String power;

    public User() {
    }
    public User (String id,String name,String account,String password,String power)
    {
        this.id=id;
        this.name=name;
        this.account=account;
        this.password=password;
        this.power=power;
    }
    public String getId()
    {
        return this.id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public  String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
