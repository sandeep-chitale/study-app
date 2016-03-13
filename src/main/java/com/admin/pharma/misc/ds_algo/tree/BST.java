package com.admin.pharma.misc.ds_algo.tree;


public class BST {
	static BinaryTreeNode<Integer> head=null;
	public static void main(String[] args) {
		
		insertNode(5);
		insertNode(3);
		insertNode(6);
		insertNode(1);
		insertNode(2);
		insertNode(80);
		head.toString();
		System.out.println(srearchKey(head,20));
		head.inOrder(head);
		System.out.println();
		head.revInOrder(head);
		
	}
	
	private static Boolean srearchKey(BinaryTreeNode<Integer> head2,Integer key) {
		
		while(head2!=null){
			if(head2.data.compareTo(key)==0) return true;
			if(head2.data.compareTo(key)==1) head2=head2.left;
			else head2=head2.right;
		}
		return false;
	}

	public static  void insertNode(Integer data){
		BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>(data),temp=head,prev=null;
		
		if(head==null){
			head=new BinaryTreeNode<Integer>(data);
			return ;
		}
		
		while(temp!=null){
			prev=temp;
			if(temp.data.compareTo(data)==1){
				temp=temp.left;
			}else{
				temp=temp.right;
			}
		}
		// add new node 
		
		if(prev.data.compareTo(data)==1){
			prev.left=newNode;
		}else{
			prev.right=newNode;
		}
	}
	
	
}
