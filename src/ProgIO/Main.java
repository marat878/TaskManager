package ProgIO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Task Manager SFX");
        primaryStage.setScene(new Scene(root, 525, 395));
        primaryStage.getIcons().add(new Image(getClass().getResource("task.png").toString()));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
