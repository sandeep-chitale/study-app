package com.admin.pharma.misc.ds_algo.list;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode(T data,ListNode<T> next) {
		this.data=data;
		this.next=next;
	}
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		ListNode<T> temp=this;
		StringBuffer sb=new StringBuffer();
		while(temp!=null){
			System.out.print(temp.data); System.out.print("->");
			sb.append(temp.data+"->");
			temp=temp.next;
			
		}
		return sb.toString();
	}
}
