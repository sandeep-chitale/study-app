package com.admin.pharma.misc.threading;

/**
 * Created by DELL on 12/4/2015.
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t=new Thread(new Thread2());
        t.start();
        //Interrupt thread
        t.interrupt();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("InterruptTest Thread2 Status "+t.isInterrupted());
    }
}
