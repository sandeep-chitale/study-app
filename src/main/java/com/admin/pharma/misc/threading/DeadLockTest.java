package com.admin.pharma.misc.threading;

/**
 * Created by DELL on 12/4/2015.
 */
public class DeadLockTest {
    Object lock1=new Object();
    Object lock2=new Object();

    public static void main(String[] args) {

        DeadLockTest dead = new DeadLockTest();
        Thread t1 = new Thread(dead.new T1());
        Thread t2 = new Thread(dead.new T2());
        Thread t3 = new Thread(dead.new T3());

        t1.start();t2.start();t3.start();
    }


    class T1 implements  Runnable{

        @Override
        public void run() {
            synchronized (lock1){
                for(int i=0;i<10000;i++){
                    System.out.println(i);
                }
                synchronized (lock2){
                    System.out.println("T1");
                }
            }
        }
    }

    class T2 implements  Runnable{

        @Override
        public void run() {
            synchronized (lock1){
                synchronized (lock2){
                    System.out.println("T2");
                }
            }
        }
    }

    class T3 implements  Runnable{

        @Override
        public void run() {
            synchronized (lock2){
                synchronized (lock1){
                    System.out.println("T3");
                }
            }
        }
    }
}

