package main.java.com.jsu.model.models.route;

public class Route {
    private String id;
    private String name;
    private String depiction;
    private String time;
    private Integer price;
    private String ways;
    public Route(){}

    public Route(String id, String name,  String ways,String depiction,  Integer price,String time) {
        this.id = id;
        this.name = name;
        this.depiction = depiction;
        this.time = time;
        this.price = price;
        this.ways = ways;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepiction() {
        return depiction;
    }

    public void setDepiction(String depiction) {
        this.depiction = depiction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getWays() {
        return ways;
    }

    public void setWays(String ways) {
        this.ways = ways;
    }
}
