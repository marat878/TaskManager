package ProgIO;

import InnerArch.TaskManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    @FXML
    TextArea txs;
    @FXML
    Button bx;

    TaskManager taskManager = new TaskManager();


    public void initialize(URL location, ResourceBundle resources)
    {
        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Work();
            }
        };
        timer.schedule(timerTask, 0, 100);
    }

    @FXML
    public void Refresh()
    {
        taskManager.Refresh();
    }

    public void Work()
    {
        taskManager.Update();
        String[] strings = StringStorage.Get();
        if( strings != null )
        {
            for (int i = 0; i < strings.length; i++)
            {
                txs.appendText(strings[i]);
            }
            StringStorage.Clear();
        }
    }
}
