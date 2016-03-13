package com.admin.pharma.misc.ds_algo.util;

 

public class Stack<T> {

	public class Node<T>{
		public T data;
		public Node next; public Node prev;
	}
	public Node top;
	
	public boolean isEmptyStack(){
		return top==null?true:false;
	}
	
	public void push(T data){
		Node<T> newNode=new Node<T>();
		newNode.data=data;
		if(top==null){
			top=newNode;
		}else{
			top.next=newNode;
			newNode.prev=top;
			top=newNode;
			
		}
	}
	
	public T pop(){
		if(isEmptyStack()){
			System.out.println("Empty Stack");
			return null;
		}else{
			T data;
			data=(T) top.data;
			top=top.prev;
			return data;
		}
		
	}
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		s.pop();
		s.push(1);s.push(2);s.push(3);s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
	}
}
