package com.admin.pharma.misc.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQ {

	public static void main(String[] args) {
		final ArrayBlockingQ<String> a = new ArrayBlockingQ<>(2);
		// Producer
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {

					try {
						a.put(i + "");
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
		// Producer1
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < 5; i++) {

							try {
								a.put(i + "$$");
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
					try {
						System.out.println(a.take());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}).start();
	}
}

// Custom array blocking queue

class ArrayBlockingQ<E> {
	private final Object[] data;
	private final ReentrantLock lock;
	private final Condition notFull, notEmpty;
	private volatile int takePtr, putPtr, count;

	public ArrayBlockingQ(int initialCapacity) {
		data = new Object[initialCapacity];
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
		
	}

	public void put(E ele) {
		lock.lock();
		try {
			// Check if array is full, Yes: then call await
			while (count == data.length)
				notEmpty.await();

			data[putPtr] = ele;
			count++;
			// If it reaches full size then make it 0

			putPtr = (1 + putPtr) % data.length;

			notFull.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public E take() {
		E e = null;
		lock.lock();
		// Check if queue is not empty
		
			try {
				while (count == 0){
					
					notFull.await();
				}
				
				e=(E)data[takePtr];
				
				takePtr=(1+takePtr)%data.length;
				count--;
				notEmpty.signalAll();
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				lock.unlock();
			}

		return e;
	}
}