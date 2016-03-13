package com.admin.pharma.misc.concurent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by DELL on 12/5/2015.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new Service("setup", 1000, latch));
        Thread t2 = new Thread(new Service("memory", 500, latch));
        Thread t3 = new Thread(new Service("network", 1500, latch));

        t1.start();
        t2.start();
        t3.start();

        latch.await();
        System.out.println("All services are ready, application is started");

    }


}

class Service implements Runnable{
    CountDownLatch latch;
   private final String name;
   private final int time;

    public Service(String name, int time, CountDownLatch latch){
        this.name = name;
        this.time = time;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" service is ready");

        latch.countDown();
    }

}
