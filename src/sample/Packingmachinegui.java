package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
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
    private Label threadnumbers ;

    Packingmachinegui packingmachinegui;

   public Packingmachinegui()
    {


//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("packingmachinegui.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }



    }



    Treat treat = Treat.getTreat_Instance();





    private void showLable()  {



        threadnumbers.setText(String.valueOf(treat.getNumber_of_treats()));
    }



    @Override
    public void update(Observable o, Object arg)
    {





        System.out.println("working");


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {



        showLable();


    }
}
