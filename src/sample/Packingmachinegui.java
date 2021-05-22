package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class Packingmachinegui implements Initializable,java.util.Observer

{
    @FXML
    private Label threadnumbers;



    Treat treat = Treat.getTreat_Instance();



    private void showLable()
    {
        if(threadnumbers!=null)
        threadnumbers.setText(String.valueOf(treat.getNumber_of_treats()));
    }



    @Override
    public void update(Observable o, Object arg)
    {


        showLable();

        System.out.println("working");


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {



        showLable();


    }
}
