package main.java.com.jsu.util;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Exitalert {
    public void alertexit()
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);//使用 Alert 类来创建一个对话框对象，并通过传递 AlertType.CONFIRMATION 作为参数来指定对话框的类型为确认对话框
        Stage stage=(Stage)alert.getDialogPane().getScene().getWindow();
        Image image=new Image("main/java/com/jsu/view/picture/Jiugui Liquor.jpg");
        stage.getIcons().add(image);
        alert.setTitle("吉首大学旅游预订系统");
        alert.setHeaderText("你确定要退出系统吗?");
        alert.setContentText("请在退出前完成你所有的业务哦~");
        alert.getButtonTypes().setAll(ButtonType.OK,ButtonType.CANCEL);
        //通过调用 getButtonTypes() 方法获取对话框中的按钮选项列表，并使用 setAll() 方法将按钮选项设置为指定的按钮类型列表，即 ButtonType.OK 和 ButtonType.CANCEL
        alert.showAndWait().ifPresent(response->{
            if(response==ButtonType.OK)
            {
                System.exit(0);
            }
        });
    }
}
