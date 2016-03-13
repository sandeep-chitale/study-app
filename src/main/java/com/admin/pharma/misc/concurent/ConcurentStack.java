package com.admin.pharma.misc.concurent;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurentStack<T> {

	AtomicReference<Node<T>> top = new AtomicReference<>();

	public void push(T data) {
		Node<T> newNode = new Node(data);
		Node<T> old;
		do {
			old = top.get();
			newNode.next = old;
		} while (!top.compareAndSet(old, newNode));

	}

	public Node<T> pop() {
		Node<T> old = null;
		do {
			old = top.get();
		} while (top.compareAndSet(old, old.next));
		return old;
	}

	public void display() {
		Node<T> temp = top.get();
		int c = 0;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			c++;
		}
		System.out.println("Count " + c);
	}

	public static void main(String[] args) {
		final ConcurentStack<String> stack = new ConcurentStack<String>();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					stack.push(i + "");
				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 100; i < 200; i++) {
					stack.push(i + "");
				}

			}
		}).start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stack.display();

	}

}

class Node<T> {
	T data;
	Node<T> next;

	public Node(T t) {
		data = t;
	}
}