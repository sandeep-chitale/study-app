package com.admin.pharma.misc.threading;

/**
 * Created by DELL on 12/4/2015.
 */
public class JoinTest {
    public static void main(String[] args) {
        System.out.println("before starting Thread1 and Thread2");

        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start(); t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("after starting Thread1 and Thread2");
    }
}

class Thread1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
                System.out.println("Thraed1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Thread2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<15;i++){
            try {
                Thread.sleep(1000);
                System.out.println("Thraed2");

            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted "+Thread.interrupted());
            }
        }
    }
}