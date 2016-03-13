package com.admin.pharma.misc.ds_algo.list;

public class ListPairwiseSwap {
	
	public static void main(String[] args) {
		ListNode<Integer> n5=new ListNode<Integer>(5,null);
		ListNode<Integer> n4=new ListNode<Integer>(4,n5);
		
		ListNode<Integer> n3=new ListNode<Integer>(3,n4);
		ListNode<Integer> n2=new ListNode<Integer>(2,n3);
		ListNode<Integer> n1=new ListNode<Integer>(1,n2);
		
		printList(n1);
		//n1=parwiseReverse(n1);
		n1=reverseInBlock(n1, 1);
		System.out.println();
		printList(n1);
	}
	
	private static ListNode<Integer> parwiseReverse(ListNode<Integer> n1) {
		ListNode p,n,curr=n1;
		p=curr; curr=n1.next;
		n1=curr;
		while(true){
			n=curr.next;
			curr.next=p;
			if(n==null||n.next==null){
				p.next=n; break;
			}
			p.next=n.next;
			p=n;
			curr=p.next;
		}
			
		return n1;
		
	}

	public static void printList(ListNode<Integer> list){
		ListNode<Integer> head=list;
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
	}
	
	static ListNode<Integer> reverseInBlock(ListNode<Integer> head,int count){
		int c;
		ListNode<Integer> n=null,p=null,curr=head;
		c=count;
		while(head!=null&&c>0){
			n=curr.next;
			curr.next=p;
			p=curr;
			curr=n;
			--c;
		}
		if(n!=null) 
		head.next=reverseInBlock(n, count);
		
		return p;
	}
}
