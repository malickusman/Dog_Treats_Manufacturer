package sample;

import java.util.Observable;
import java.util.Observer;

public class Hopper extends Observable implements Observer
{

    private int maximumHopperCount = 250;

    private int checktreats=0;





    private static  Hopper hopper_instance = new Hopper();

    public static Hopper getHopper_instance ()
    {
        return hopper_instance;
    }



    private Hopper()
    {


    }



    Packingbagsmachine packingbagsmachine = Packingbagsmachine.getPackingbagsmachine();



    private void new_Hopper()
    {

    }




    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println("Hopper");
        hopper_instance.addObserver(packingbagsmachine);

        if(checktreats<=maximumHopperCount)
        {

            checktreats = (int) arg;
            System.out.println(checktreats);


            setChanged();
            notifyObservers(arg);


        }

    }


}
