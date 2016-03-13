package com.admin.pharma.misc.threading;

public class Sync {
	public static void main(String[] args) {
		Task t = new Task();
		T2 th1 = new T2(t);
		T3 th2 = new T3(t);
		
		th1.start();
		th2.start();
	}
}

class Task {
	synchronized public void show() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread() + " " + i);
		}

	}

}

class T2 extends Thread {
	Task t;

	public T2(Task t) {
		this.t = t;
	}

	@Override
	public void run() {
		int i = 0;
		while (i++ < 100) {
			t.show();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

class T3 extends Thread {
	Task t;

	public T3(Task t) {
		this.t = t;
	}

	@Override
	public void run() {
		int i = 0;
		while (i++ < 100) {
			t.show();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
