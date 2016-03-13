package com.admin.pharma.misc.threading;

public class Threads {
	public static void main(String[] args) {
		T t = new T();
		Thread t1 = new Thread(new T1());

		t.start();

		t1.start();
		
		t.interrupt();
		
		try {
			t.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<100;i++){
			System.out.println("MAIN");
		}
	}
}

class T extends Thread {
	@Override
	public void run() {
		int i=0;
		while (i++<100) {
			System.out.println("T");
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	
}

class T1 implements Runnable {
	@Override
	public void run() {
		int i=0;
		while (i++<100) {
			System.out.println("T1");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}