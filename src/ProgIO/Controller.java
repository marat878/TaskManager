package ProgIO;

import InnerArch.TaskManager;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    TextArea txs;
    @FXML
    Button bx;

    TaskManager taskManager = new TaskManager();
    AnimationTimer at;

    public void initialize(URL location, ResourceBundle resources)
    {
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Work();
            }
        };

        at.start();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        at.stop();
    }

    @FXML
    public void Refresh() {
        at.stop();
        taskManager.Refresh();
        at.start();
    }

    public void Work()
    {
        try {
            taskManager.Update();
            String[] strings = StringStorage.Get();
            if (strings != null) {
                for (int i = 0; i < strings.length; i++) {
                    txs.appendText(strings[i]);
                }
                StringStorage.Clear();
            }
        }
        catch (NullPointerException e)
        {

        }
    }
}
