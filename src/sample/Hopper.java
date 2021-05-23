package sample;

import javafx.fxml.FXML;

import java.util.Observable;
import java.util.Observer;

public class Hopper implements Observer
{

    private int maximumHopperCount = 250;

    private int checktreats=0;






    private static final Hopper hopper_instance = new Hopper();

    public static Hopper getHopper_instance ()
    {
        return hopper_instance;
    }



    private Hopper()
    {

    }






    private void new_Hopper()
    {

    }


    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println("Hopper");


        if(checktreats<=maximumHopperCount)
        {

            checktreats = (int) arg;
            System.out.println(checktreats);



        }

    }
}
