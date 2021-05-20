package sample;

public class Bags
{

    private static int numberofBags = 0;

    private static Bags instance = new Bags();

    //make the constructor private so that this class cannot be
    //instantiated
    private Bags(){}

    //Get the only object available
    public static Bags getInstance(){
        return instance;
    }

    public int Bags(){

        return numberofBags;
    }






}
