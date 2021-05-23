package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class mainmenu
{


    private static javafx.scene.control.Button pauseBtn;

    Treat treat = Treat.getTreat_Instance();

    Parent secondPane;

    //Start
    public void startMachine(ActionEvent actionEvent) throws IOException {




        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("packingmachinegui.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();



        treat.start_Producing_Treat();
    }


    //Stop
    public void stopMachine(ActionEvent actionEvent)
    {
        treat.stop_Producing_Treat();
        if(pauseBtn!=null)
        pauseBtn.setText("Pause");
    }

    Alert alert = new Alert(Alert.AlertType.NONE);


    //Pause
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
