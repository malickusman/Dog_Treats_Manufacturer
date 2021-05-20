package sample;

import javax.swing.*;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class Treat implements Runnable
{

    private int minimumInterval = 3; // 3 seconds by default, can be changed later

    private static int number_of_treats=0;



    private static Treat treat_instance = new Treat();

    //make the constructor private so that this class cannot be
    //instantiated
    private Treat(){}

    //Get the only object available
    public static Treat getInstance(){
        return treat_instance;
    }

    private void add_treat()
    {
        number_of_treats++;

        System.out.println(number_of_treats);
    }

   private Thread treat_thread;

    public void start_Producing_Treat()
    {


        cancelled = true;
        treat_thread = new Thread(treat_instance);
        treat_thread.start();
    }

    public Boolean stop_Producing_Treat()
    {

        if(treat_thread!=null)
        {
            cancelled = false;
            treat_thread.stop();
            return true;
        }

        else
            return false;
    }




    private volatile boolean cancelled;






    @Override
    public void run()
    {
        try {

            while (cancelled)
            {
                add_treat();
                TimeUnit.SECONDS.sleep(minimumInterval);
                System.out.println("Sleep");

            }

        } catch (Exception e)
        {

        }

    }
}
