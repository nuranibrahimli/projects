package springtest;

import springtest.Sim;

public class Airtel implements Sim {

    @Override public void calling()
    {
        System.out.println("Airtel Calling");
    }

    @Override public void data()
    {
        System.out.println("Airtel Data");
    }
}
