package main.java.com.jsu.view.scenes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.com.jsu.util.Monitor;
import main.java.com.jsu.view.traveler.choseroute.Choserouteviewcontroller;
import main.java.com.jsu.view.traveler.orderscene.Orderviewcontroller;
import java.io.IOException;
public class Scenes extends Application {
    private static Stage stage;
    private static Monitor monitor;
    private static Image image=new Image("main/java/com/jsu/view/picture/Jiugui Liquor.jpg");
    public void start(Stage stage)
    {
        this.stage=stage;
        stage.setOnCloseRequest(event -> {
            this.monitor=new Monitor();
            monitor.droptable();
        });
      logscene();
    }
    public void logscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane) FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/log/Logview.fxml"));
            Scene scene=new Scene(anchorPane,933,642);
            stage.setScene(scene);
            stage.getIcons().add(image);
            stage.setTitle("吉首大学旅游预订系统");
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void registerscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/register/Registerview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.getIcons().add(image);
            stage.setTitle("吉首大学旅游预订系统");
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void managerscene()
    {
           try
           {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/manager/Managerview.fxml"));
               AnchorPane anchorPane=loader.load();
               Scene scene = new Scene(anchorPane);
               stage.setScene(scene);
               stage.getIcons().add(image);
               stage.setTitle("吉首大学旅游预订系统");
               stage.show();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
    }
    public void usermanagescene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/usermanage/Usermanageview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void adduserscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/usermanage/adduser/Adduserview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void updateuserscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/usermanage/updateuser/Updateuserview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void routemanagescene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/routemanage/Routemanageview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void addroutescene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/routemanage/addroute/Addrouteview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void updateroutescene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/routemanage/updateroute/Updaterouteview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void ordermanagescene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/ordermanage/Ordermanageview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void addorderscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/ordermanage/addorder/Addorderview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void updateorderscene()
    {
        try
        {
            AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/manager/ordermanage/updateorder/Updateorderview.fxml"));
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void managercenter()
    {
        try
        {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/manager/personalcenter/Centerview.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void travelerscene()
    {
       try
       {
           AnchorPane anchorPane=(AnchorPane)FXMLLoader.load(getClass().getResource("/main/java/com/jsu/view/traveler/Travelerview.fxml"));
           Scene scene=new Scene(anchorPane);
           stage.setScene(scene);
           stage.setTitle("吉首大学旅游预订系统");
           stage.getIcons().add(image);
           stage.show();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }
    public Choserouteviewcontroller choseroutescene()
    {
        Choserouteviewcontroller choserouteviewcontroller=null;
        try
        {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/traveler/choseroute/Choserouteview.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            choserouteviewcontroller=fxmlLoader.getController();
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return choserouteviewcontroller;
    }
    public void orderdisplayview()
    {
        try
        {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/traveler/orderdisplay/Orderdisplayview.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public Orderviewcontroller orderscene()
    {
        Orderviewcontroller o=null;
        try
        {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/traveler/orderscene/Orderview.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            o=fxmlLoader.getController();
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return o;
    }
    public void travelercenter()
    {
        try
        {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/main/java/com/jsu/view/traveler/personalcenter/Centerview.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            Scene scene=new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("吉首大学旅游预订系统");
            stage.getIcons().add(image);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
