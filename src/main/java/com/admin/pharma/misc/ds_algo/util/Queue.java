package com.admin.pharma.misc.ds_algo.util;


class ListNode<T>{
	T data;
	ListNode next;
}

public class Queue<T> {
	ListNode front;
	ListNode rear;
	
	 Queue createQueue(){
		Queue q=new Queue();
		ListNode temp=new ListNode();
		q.front=null;
		q.rear=null;
		return q;
	}
	
	public boolean isEmptyQueue(){
		if(this.front==null)
		return true;
		else
			return false;
	}
	public void enQueue(T data){
		ListNode newNode=new ListNode();
		newNode.data=data;
		if(front==null&&rear==null){
			front=rear=newNode;
		}else{
			rear.next=newNode;
			rear=newNode;
		}
		
		
	}
	public T deQueue(){
		T data=null;
		ListNode temp;
		if(isEmptyQueue()){
			System.out.println("Queue is empty");
			return null;
		}
		else{
			temp=this.front;
			data=(T) this.front.data;
			this.front=this.front.next;
			if(front==null) rear=front;
		}	
		return data;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q=new Queue<Integer>();
		q.createQueue();
		q.enQueue(1);q.enQueue(2);q.enQueue(3);q.enQueue(4);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

	public boolean contains(T target) {
		ListNode tmp = front;

		while(tmp!=null){
			if(target == tmp.data) return true;
			tmp = tmp.next;
		}
		return false;
	}
}
