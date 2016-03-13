package com.admin.pharma.misc.threading;

public class ProducerConsumer {

	public static void main(String[] args) {
		final Counter c = new Counter(); //Shared data
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
		
		/*ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] ti = bean.getThreadInfo(bean.getAllThreadIds(), true, true);
		
		for(ThreadInfo t:ti){
			System.out.println(t.getThreadName()+t.getLockInfo());
		}*/
		
	}

}

class Counter {

	volatile boolean isSet;
	volatile  int counter;

	public void set(int c) {
		synchronized (this) { //Try to acquire lock on object

			try {
				while (isSet)
					wait(); // Synchronize , wait since previous data is not yet
							// red

				counter = c;
				isSet = true;
				notifyAll(); // Notify consumer that data is available
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void get() {
		synchronized (this) {

			try {
				while (!isSet)
					wait(); // Synchronize , wait since data is not available and give up lock

				System.out.println(Thread.currentThread().getName()+"->"+counter);

				isSet = false;
				notifyAll(); // Notify consumer that data is available

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}