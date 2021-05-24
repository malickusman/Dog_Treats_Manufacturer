package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class mainmenu
{

    @FXML
    private Label treatnolable;


    Packingbagsmachine packingbagsmachine = Packingbagsmachine.getPackingbagsmachine();

    private static javafx.scene.control.Button pauseBtn;

    Treat treat = Treat.getTreat_Instance();

    Parent secondPane;

    //Start
    public void startMachine(ActionEvent actionEvent) throws IOException {




//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("packingmachinegui.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root1));
//        stage.show();

//        lableTreat();


        if(packingbagsmachine.tentreat || packingbagsmachine.twentytreat || packingbagsmachine.fiftytreat)
            treat.start_Producing_Treat();
        else
        {
            alert.setAlertType(Alert.AlertType.WARNING);

            alert.setTitle("Warning");
            alert.setContentText("Select packing bags first");
            // show the dialog
            alert.show();
        }

    }


    //Stop
    public void stopMachine(ActionEvent actionEvent)
    {


            if(treat.treat_thread!=null)
            {
                treat.stop_Producing_Treat();
                if(pauseBtn!=null)
                    pauseBtn.setText("Pause");


            }
            else
            {
                alert.setAlertType(Alert.AlertType.WARNING);

                alert.setTitle("Warning");
                alert.setContentText("Machine is not started");
                // show the dialog
                alert.show();
            }










    }

    Alert alert = new Alert(Alert.AlertType.NONE);



    public void tentreatsbutton(ActionEvent actionEvent)
    {


        packingbagsmachine.tentreat=true;
        packingbagsmachine.twentytreat=false;
        packingbagsmachine.fiftytreat=false;
        alert.setAlertType(Alert.AlertType.CONFIRMATION);

        alert.setTitle("SELECTED");
        alert.setContentText("Ten Treats per bag selected");
        // show the dialog
        alert.show();

    }


    public void twentytreatsbutton(ActionEvent actionEvent)
    {

        packingbagsmachine.twentytreat=true;
        packingbagsmachine.tentreat=false;
        packingbagsmachine.fiftytreat=false;
        alert.setAlertType(Alert.AlertType.CONFIRMATION);

        alert.setTitle("SELECTED");
        alert.setContentText("Twenty Treats per bag selected");
        // show the dialog
        alert.show();
    }

    public void fiftytreatbutton (ActionEvent actionEvent)
    {

        packingbagsmachine.fiftytreat=true;
        packingbagsmachine.tentreat=false;
        packingbagsmachine.twentytreat=false;
        alert.setAlertType(Alert.AlertType.CONFIRMATION);

        alert.setTitle("SELECTED");
        alert.setContentText("Fifty Treats per bag selected");
        // show the dialog
        alert.show();
    }

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
                    alert.setContentText("Machine is not started");
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



//    private void lableTreat()
//    {
//        while (iscancelwhileloop)
//        {
//            if(treatnolable!=null)
//            treatnolable.setText(String.valueOf(treat.getNumber_of_treats()));
//
//        }
//
//
//    }




}
