package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class mainmenu
{


    private static javafx.scene.control.Button pauseBtn;

    Treat treat = Treat.getInstance();

    public void startMachine(ActionEvent actionEvent)
    {
        treat.start_Producing_Treat();
    }

    public void stopMachine(ActionEvent actionEvent)
    {
        treat.stop_Producing_Treat();
        if(pauseBtn!=null)
        pauseBtn.setText("Pause");
    }

    Alert alert = new Alert(Alert.AlertType.NONE);

    public void pauseButtonclicked(ActionEvent actionEvent)
    {
        pauseBtn = (Button) actionEvent.getSource();




            if(pauseBtn.getText().equals("Pause"))
            {
                if(treat.treat_thread!=null)
                {
                    treat.thread_Pause();
                    pauseBtn.setText("Resume");
                }
                else
                {
                    alert.setAlertType(Alert.AlertType.WARNING);

                    alert.setTitle("Warning");
                    alert.setContentText("Programming is not started");
                    // show the dialog
                    alert.show();
                }





            }
            else if(pauseBtn.getText().equals("Resume"))
            {
                treat.start_Producing_Treat();
                pauseBtn.setText("Pause");

            }





    }



}