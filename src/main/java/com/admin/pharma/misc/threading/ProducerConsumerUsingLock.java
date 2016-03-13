package com.admin.pharma.misc.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DELL on 12/4/2015.
 */
public class ProducerConsumerUsingLock {
    public static void main(String[] args) {

        final CounterData c = new CounterData(); //Shared data

        //Producer
        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    c.set(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        // Consumer
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    c.get();

                }

            }
        }).start();

        // Consumer
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    c.get();

                }

            }
        }).start();
    }
}

class CounterData {

    ReentrantLock lock =new ReentrantLock();
    Condition notRead= lock.newCondition();
    Condition notWrite= lock.newCondition();

    volatile  int counter;
    volatile boolean isWrite;

    public void set(int c) {
        lock.lock();
        try {
            while(isWrite)
                notRead.await();

            this.counter = c;
            isWrite = true;

            notWrite.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void get() {
        lock.lock();
        try {
            while(!isWrite)
                notWrite.await();

            System.out.println(Thread.currentThread().getName()+"->"+counter);

            isWrite = false;

            notRead.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}