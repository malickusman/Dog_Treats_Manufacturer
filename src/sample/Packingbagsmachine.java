package sample;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Packingbagsmachine implements Observer ,Runnable
{

    public  Boolean tentreat=false;

    public  Boolean twentytreat = false;

    public  Boolean fiftytreat= false;

    public Boolean startbags=false;

    private Boolean timerstarted = false;

    private int minimumInterval = 15000;


    private Thread packingbags_thread;



    private int treats=0;

    private final ArrayList<Integer> bagoftreats = new ArrayList<Integer>();

    private Packingbagsmachine()
    {

    }


    private void startPackingbags()
    {
        if(packingbags_thread==null)
        {
            packingbags_thread = new Thread(packingbagsmachine);

        }
        else
        {

        }
    }

    private static  Packingbagsmachine packingbagsmachine = new Packingbagsmachine();

    public static Packingbagsmachine getPackingbagsmachine ()
    {
        return packingbagsmachine;
    }


    @Override
    public void update(Observable o, Object arg)
    {

        System.out.println("Packing bags");
        System.out.println(arg);



    }


    @Override
    public void run()
    {
        try {

            while (tentreat || twentytreat || fiftytreat)
            {

                TimeUnit.SECONDS.sleep(minimumInterval);
//                System.out.println("Sleep");

                if(tentreat)
                    add10_threadinbags();
                else if(twentytreat)
                    add20_threadinbags();
                else if(fiftytreat)
                    add50_threadinbags();

                if(!timerstarted)
                timerStart();

            }

        } catch (Exception e)
        {

            System.out.println(String.valueOf(e));
        }

    }

    private void add10_threadinbags()
    {
        if(treats>10)
        bagoftreats.add(10);

    }

    private void add20_threadinbags()
    {
        if(treats>20)
            bagoftreats.add(20);
    }

    private void add50_threadinbags()
    {
        if(treats>50)
            bagoftreats.add(50);
    }

    private void timerStart()
    {
        System.out.println("Timer started hua");
        Timer timer = new Timer ();
        TimerTask hourlyTask = new TimerTask () {
            @Override
            public void run ()
            {
                System.out.println("Timer started?");

                timerstarted = true;
            }
        };

        timer.schedule (hourlyTask, 1000*60*60, 1000);
    }

}
