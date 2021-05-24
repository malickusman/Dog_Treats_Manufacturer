package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;

public class Treat extends java.util.Observable implements Runnable {

    private int minimumInterval = 3; // 3 seconds by default, can be changed later

    public static   int number_of_treats=0;

    private static Boolean thread_stopped=false;


    private static Treat treat_instance = new Treat();

    public static boolean cancelled=false;
    public Thread treat_thread;

    Hopper hopper = Hopper.getHopper_instance();

    //make the constructor private so that this class cannot be
    //instantiated
    private Treat()
    {




    }

    //Get the only object available
    public static Treat getTreat_Instance(){
        return treat_instance;
    }

    private void add_treat()
    {
        number_of_treats++;

//        System.out.println(number_of_treats);
        setChanged();
        notifyObservers(number_of_treats);


    }


    public void start_Producing_Treat()
    {

        Hopper hopper = Hopper.getHopper_instance();
        treat_instance.addObserver(hopper);



        if(treat_thread==null)
        {
            treat_thread = new Thread(treat_instance);

        }

        try
        {
            if(!thread_stopped )
            {
                if(!treat_thread.isAlive()  )
                {
                    cancelled = true;
                    treat_thread.start();

                }
                else
                {
                    a.setAlertType(Alert.AlertType.WARNING);

                    a.setTitle("Warning");
                    a.setContentText("Programming is already started");
                    // show the dialog
                    a.show();

                }
            }
            else
            {
                thread_stopped=false;

                treat_thread = new Thread(treat_instance);
                cancelled = true;
                treat_thread.start();

            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

            }

    public void stop_Producing_Treat()
    {

        if(treat_thread!=null)
        {
            number_of_treats=0;
            cancelled = false;
            treat_thread.interrupt();
            thread_stopped=true;
            treat_thread=null;

        }

    }







    Alert a = new Alert(Alert.AlertType.NONE);

    public void thread_Pause()
    {
        if(treat_thread!=null)
        {
            cancelled = false;
            treat_thread.interrupt();
            thread_stopped=true;

        }
        else
        {
            a.setAlertType(Alert.AlertType.WARNING);

            a.setTitle("Warning");
            a.setContentText("Programming is not started");
            // show the dialog
            a.show();
        }

    }



    @Override
    public void run()
    {





        try {

            while (cancelled)
            {

                TimeUnit.SECONDS.sleep(minimumInterval);
//                System.out.println("Sleep");

                add_treat();

            }

        } catch (Exception e)
        {

            System.out.println(String.valueOf(e));
        }

    }





}
