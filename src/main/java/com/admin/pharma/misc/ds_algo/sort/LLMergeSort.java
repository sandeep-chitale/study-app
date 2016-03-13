package com.admin.pharma.misc.ds_algo.sort;


import ds_algo.list.ListNode;

public class LLMergeSort {
	public static void main(String[] args) {
		
		int[] arr={6,4,5,1,8,2,3};
		ListNode<Integer> head=createLL(arr),left=new ListNode<Integer>(),right=new ListNode<Integer>();
		
		System.out.println(head);
		//ListNode<Integer>[] lr=splitLL(head);
		
		ListNode<Integer> head1=createLL(new int[]{1,2,5});
		ListNode<Integer> head2=createLL(new int[]{3,4,6});
		//System.out.println(sortedMerge(head1, head2));
		System.out.println(mergeSort(head));
	}
	
	public static ListNode<Integer> mergeSort(ListNode<Integer> head){
		ListNode<Integer> result=null,head1,head2;
		
		if(head==null||head.next==null) {
			return head;
			
			
		}
		ListNode<Integer>[] lr=splitLL(head);
		head1=mergeSort(lr[0]);
		head2=mergeSort(lr[1]);
	    result=sortedMerge(head1, head2);
	    
	    return result;
	}
	public static ListNode<Integer> createLL(int[] arr) {
		ListNode<Integer> head=new ListNode<Integer>(),prev,newNode;
		prev=head;
		for(int i=0;i<arr.length;i++){
			newNode=new ListNode<Integer>(arr[i], null);
			if(i==0) head=newNode;
			else{
				prev.next=newNode;
			}
			prev=newNode;
		}
		return head;
	}
	public static ListNode<Integer>[] splitLL(ListNode<Integer> head ){
		ListNode<Integer> slow=head,fast=null,right=null;
		
		if(slow==null||slow.next==null) {
			return new ListNode[]{slow,fast};
		}
		
		fast=slow.next;
		
		while(fast!=null){
			
			fast=fast.next;
			if(fast!=null){
				fast=fast.next;
				slow=slow.next;
			}
		}
		right=slow.next;
		slow.next=null;
		return new ListNode[]{head,right};
	}
	
	public static ListNode<Integer> sortedMerge(ListNode<Integer> head1,ListNode<Integer> head2){
		
		ListNode<Integer> result=null;
		if(head1==null) return head2;
		if(head2==null) return head1;
		
		if(head1.data<head2.data) {
			result=head1;
			result.next=sortedMerge(head1.next, head2);
		}
		else{
			result=head2;
			result.next=sortedMerge(head1, head2.next);
		}
		return result;
	}
}
