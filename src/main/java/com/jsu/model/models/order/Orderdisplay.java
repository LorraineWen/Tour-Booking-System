package main.java.com.jsu.model.models.order;

public class Orderdisplay {
    private String id;
    private String user;
   private String name;
    private String ways;
    private String depiction;
   private  String price;
   private String time;
   private String date;

    public Orderdisplay() {
    }

    public Orderdisplay(String id, String user, String name, String ways, String depiction, String price, String time, String date) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.ways = ways;
        this.depiction = depiction;
        this.price = price;
        this.time = time;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWays() {
        return ways;
    }

    public void setWays(String ways) {
        this.ways = ways;
    }

    public String getDepiction() {
        return depiction;
    }

    public void setDepiction(String depiction) {
        this.depiction = depiction;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
