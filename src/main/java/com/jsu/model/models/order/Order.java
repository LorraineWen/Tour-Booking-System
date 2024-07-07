package main.java.com.jsu.model.models.order;

public class Order {
    private String id;
    private String routeid;
    private  String userid;
    private String date;
    public Order(){}

    public Order(String id,String userid, String routeid, String date) {
        this.id = id;
        this.routeid = routeid;
        this.userid = userid;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteid() {
        return routeid;
    }

    public void setRouteid(String routeid) {
        this.routeid = routeid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
