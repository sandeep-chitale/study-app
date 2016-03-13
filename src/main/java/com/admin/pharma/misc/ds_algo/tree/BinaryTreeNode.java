package com.admin.pharma.misc.ds_algo.tree;


import ds_algo.util.Queue;

public class BinaryTreeNode<T> {
	public BinaryTreeNode(T data2) {
		data=data2;
	}
	public BinaryTreeNode() {
	}
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	
public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
@Override	
public  String toString(){
		
		Queue<BinaryTreeNode<T>> q=new Queue<BinaryTreeNode<T>>();
		q.enQueue(this);
		q.enQueue(null);
		boolean isLeft=true;
		
		while(!q.isEmptyQueue()){
			BinaryTreeNode<T> temp=q.deQueue();
		    if(temp!=null)
		    	System.out.print(temp.data);
			
		    if(temp==null){
		    	if(!q.isEmptyQueue())
		    		q.enQueue(null);
		    	System.out.println();
		    	continue;
		    }
		    if(temp.left!=null) q.enQueue(temp.left);
		    if(temp.right!=null) q.enQueue(temp.right);
		    System.out.print("##");
		}
		
		return "";
	}
public void inOrder(BinaryTreeNode root){
	if(root==null) return;
	inOrder(root.left);
	System.out.print(root.data+" ");
	inOrder(root.right);
}
public void revInOrder(BinaryTreeNode root){
	if(root==null) return;
	revInOrder(root.right);
	System.out.print(root.data+" ");
	revInOrder(root.left);
}
}
