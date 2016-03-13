package com.admin.pharma.misc.ds_algo.tree;

import ds_algo.util.Queue;
import ds_algo.util.Stack;


public class BinaryTree<T> {

	BinaryTreeNode<T> root;
	
	BinaryTreeNode insert(T data,BinaryTreeNode node,boolean isLeft){
		BinaryTreeNode<T> newNode=new BinaryTreeNode<T>();
		
		newNode.data=data;
		if(root==null){
			root=newNode;
		}else{
			if(isLeft){
				node.left=newNode;
			}else{
				node.right=newNode;
			}
		}
		return newNode;
	}
	
	void preOrder(BinaryTreeNode root){
		
		if(root==null) return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	void preOrderNonRec(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		
		while(true){
			
			while(root!=null){
				System.out.print(root.data+" ");
				stack.push(root);
				root=root.left;
			}
			
			//
			if(stack.isEmptyStack()) break;
			
			root=stack.pop();
			root=root.right;
			
		}
	}
	void inOrder(BinaryTreeNode root){
		if(root==null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	void postOrder(BinaryTreeNode root){
		if(root==null) return;
		postOrder(root.left);
		
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	void postOrderNonRec(BinaryTreeNode node){
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		
		while(true){
			
			if(root!=null){
				
				stack.push(root);
				root=root.left;
			}else{
				if(stack.isEmptyStack()) break;
				
				if(((BinaryTreeNode)stack.top.data).right==null){
					root=stack.pop();
					System.out.print(root.data+" ");
					if(root==((BinaryTreeNode)stack.top.data).right){
						root=stack.pop();
						System.out.print(root.data+" ");
					}
					
				}
				
				if(!stack.isEmptyStack()){
					root=((BinaryTreeNode)stack.top.data).right;
				}else
					root=null;
				
			}
			
			
		}
	}
	
	int findMax(BinaryTreeNode<Integer> root){
		int root_val,left,right,max=0;
		if(root!=null) {
			
			root_val=root.data;
			
			left=findMax(root.left);
			right=findMax(root.right);
			
			if(left>right) max=left;
			else max=right;
			
			if(root_val>max) max=root_val;
		
		
				
		}
		return max;
	}
	int findMaxByNonRec(BinaryTreeNode<Integer> root){
		int max=-1;
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		BinaryTreeNode<Integer> temp=null;
		while(!q.isEmptyQueue()){
			temp=q.deQueue();
			
			if(temp.data>max) max=temp.data;
			
			if(temp.left!=null) q.enQueue(temp.left);
			if(temp.right!=null) q.enQueue(temp.right);
		}
		return max;
	}
	
	boolean SearchNode(BinaryTreeNode<Integer> root, Integer data){
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		while(!(q.isEmptyQueue())){
			BinaryTreeNode<Integer> temp=q.deQueue();
			if(temp.data==data)
				return true;
			if(temp.left!=null)
				q.enQueue(temp.left);
			if(temp.right!=null)
				q.enQueue(temp.right);
		}
		return false;
	}

	
	int heightOfBinaryTree(BinaryTreeNode<Integer> root){
		int height=0;
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		while(!(q.isEmptyQueue())){
			BinaryTreeNode<Integer> temp=q.deQueue();
			if((temp.left!=null)||(temp.right!=null))
				height++;
			if(temp.left!=null)
				q.enQueue(temp.left);
			if(temp.right!=null)
				q.enQueue(temp.right);
				
		}
		
		return height;
	}
	int heightRec(BinaryTreeNode<Integer> root){
		
		int h=0,l=0,r=0;
		if(root==null) return 0;
		if(root.left!=null) l=1+heightRec(root.left);
		if(root.right!=null) r=1+heightRec(root.right);
		
		if(l>r) h=l;
		else h=r;
		
		return h;
		
	}
	
	
	int LeafNode(BinaryTreeNode<Integer> root){
		int cnt=0;
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		while(!(q.isEmptyQueue())){
			
			BinaryTreeNode<Integer> temp=q.deQueue();
			if(temp.left==null&&temp.right==null)
			{
				System.out.println(temp.data); cnt++;
			}
			if(temp.left!=null)
				q.enQueue(temp.left);
			if(temp.right!=null)
				q.enQueue(temp.right);
			
		}
		return cnt++;
		
	}
	
	/*int  LeafNodeRec(BinaryTreeNode<Integer> root){
		int h=0;
		if(root==null) return 0;
		
		if(root.left==null&&root.right==null)
			return 1;
		if(root.left!=null) return LeafNodeRec(root.left);
		if(root.right!=null) return LeafNodeRec(root.right);
		}
	*/
	
	int MaxLevelSum(BinaryTreeNode<Integer> root){
		int level=0;int maxlevel=0;int sum=0;int max=0;
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		q.enQueue(null);
		while(!(q.isEmptyQueue())){
			BinaryTreeNode<Integer> temp= q.deQueue();
			if(temp==null){
				if(sum>max){
					max=sum;
				maxlevel=level;
				}
				sum=0;
				if(!(q.isEmptyQueue()))
					q.enQueue(null);
				level++;				
			}			
			else{
				sum=sum+temp.data;
				if(temp.left!=null)
					q.enQueue(temp.left);
				if(temp.right!=null)
					q.enQueue(temp.right);
				}
		}
		return max;
	}
	
	static boolean SumExistInpath(BinaryTreeNode<Integer> root,int sum){
		int remainingSum=0; boolean flag=false;
		if(root==null)
			return (sum==0);
		else{
			remainingSum=sum-root.data;
			if(remainingSum==0){
				return true;
			}			
			/*if((root.left!=null && root.right!=null))
				return (SumExistInpath(root.left, remainingSum)||SumExistInpath(root.right, remainingSum));*/
			 if(root.left!=null)
				 flag= SumExistInpath(root.left, remainingSum);
			 if(root.right!=null)
				 flag= SumExistInpath(root.right, remainingSum);
		}
		return flag;
		
	}
	
	int sumOfNode(BinaryTreeNode<Integer> root){
		int sum=0;
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		if(root==null)
			return 0;
		q.enQueue(root);
		while(!(q.isEmptyQueue())){
			BinaryTreeNode<Integer> temp=q.deQueue();
			sum=sum+temp.data;
			if(temp.left!=null)
				q.enQueue(temp.left);
			if(temp.right!=null)
				q.enQueue(temp.right);
		}
		return sum;
	}
	
	BinaryTreeNode<Integer> MirrorImageTree(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> temp;
		if(root!=null){
			MirrorImageTree(root.left);
			MirrorImageTree(root.right);
			temp=root.left;
			root.left=root.right;
			root.right=temp;
		}
		root.toString();
		return root;
	}
	public String toString(BinaryTreeNode<Integer> root){
		
		Queue<BinaryTreeNode<Integer>> q=new Queue<BinaryTreeNode<Integer>>();
		q.enQueue(root);
		q.enQueue(null);
		boolean isLeft=true;
		int k=20 ,j=20;
		for(int i=0;i<(k+3);i++)System.out.print("#");
		k-=3;
		while(!q.isEmptyQueue()){
			BinaryTreeNode<Integer> temp=q.deQueue();
			if(temp==null){
				System.out.println();
				j=j/2;
				for(int i=0;i<k;i++)System.out.print("#");
				k-=3;
				
				
				if(!q.isEmptyQueue())
					q.enQueue(null);
				
			}else{
				
				System.out.print(temp.data); 
				for(int i=0;i<j;i++)
					{System.out.print("#");  } 
				
				if(temp.left!=null)
					q.enQueue(temp.left);
				if(temp.right!=null)
					q.enQueue(temp.right);
				
			}
			
			
			
			
		}
		
		
		return "";
			
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		BinaryTreeNode<Integer> n=tree.insert(1, null, true);
		BinaryTreeNode<Integer> n1=tree.insert(2, n, true);
		n=tree.insert(3, n, false);
		tree.insert(8, n, true);
		n=tree.insert(4, n1, true);
		n=tree.insert(5, n1, false);
		n=tree.insert(10, n, false);
		System.out.println("Preorder");
		tree.preOrder(tree.root);
		System.out.println("Inorder");
		tree.inOrder(tree.root);
		System.out.println("PostOrder");
		tree.postOrder(tree.root);
		
		System.out.println("PreOrer non rec");
		tree.preOrderNonRec(tree.root);
		
		System.out.println("Post Order no rec");
		//tree.postOrderNonRec(tree.root);
		Integer a=-1;
		
		/*System.out.println(tree.findMax(tree.root));
		System.out.println(tree.findMaxByNonRec(tree.root));
		System.out.println(tree.SearchNode(tree.root, 8));
		System.out.println(tree.heightRec(tree.root));
		System.out.println(tree.heightOfBinaryTree(tree.root));
		System.out.println("No. of leaves:"+
		tree.LeafNode(tree.root));
		System.out.println("Leaf Node\n");
		//tree.LeafNodeRec(tree.root);
		System.out.println("Max Sum is:");
		System.out.println(tree.MaxLevelSum(tree.root));
		System.out.print("Sum of all nodes in tree is:"+ " ");
		System.out.println(tree.sumOfNode(tree.root));
		tree.root.toString();
		System.out.println(tree.MirrorImageTree(tree.root));
		
		AreMirrorTree amt=new AreMirrorTree();
		BinaryTree<Integer> tree1=new BinaryTree<Integer>();
		BinaryTreeNode<Integer> m=tree1.insert(1, null, true);
		BinaryTreeNode<Integer> m1=tree1.insert(3, m, true);
		BinaryTreeNode<Integer>m2=tree1.insert(2, m, false);
		BinaryTreeNode<Integer>m3=tree1.insert(5, m2, true);
		BinaryTreeNode<Integer>m4=tree1.insert(4, m2, false);
		BinaryTreeNode<Integer>m5=tree1.insert(15, m3, true);
		System.out.println("Tree is:");
		tree.preOrder(tree1.root);
		System.out.println(amt.areMirrorTree(tree.root, tree1.root));
		
		System.out.print("Sum is exist:"+ " ");
		System.out.println(tree.SumExistInpath(tree.root, 19));
		*/
		int [] path=new int[15];
		int pathLen=0;
		tree.toString(tree.root);
		printPathRec(tree.root,path,pathLen);
		System.out.println(SumExistInpath(tree.root, 12));
		System.out.println(subtractEvenOddLevel(tree.root,true,0));
		Integer maxSum=new Integer(0);
		Integer currSum=new Integer(0);
		BinaryTreeNode<Integer> target=null;
		printMaxSumFromLeaftoRoot(tree.root, maxSum, currSum, target);
		System.out.println(target);
	}

	private static void printPathRec(BinaryTreeNode<Integer> root2, int[] path,int pathLen) {
			
		if(root2==null) return;
		
		path[pathLen++]=root2.data;
		
		if(root2.left==null&&root2.right==null) printPath(path,pathLen);
		else {
			if (root2.left!=null) printPathRec(root2.left,path,pathLen);
			if (root2.right!=null) printPathRec(root2.right,path,pathLen);
		}
	}

	private static void printPath(int[] path, int pathLen) {
		System.out.println();
		for(int i=0;i<pathLen;i++) System.out.print(path[i]+"->");
		
	}
	
	public static int subtractEvenOddLevel(BinaryTreeNode<Integer> root,boolean even,int sum){
		
		if(root==null) return 0;

		return root.data-subtractEvenOddLevel(root.left,!even,sum)-subtractEvenOddLevel(root.right,!even,sum);
				
	}
	
	public static void printMaxSumFromLeaftoRoot(BinaryTreeNode<Integer> root,Integer maxSum,Integer currSum,BinaryTreeNode<Integer> target){
		
		if(root==null) return ;
		currSum=currSum+root.data;
			if(root.left==null && root.right==null){
			
				if(currSum>maxSum) 
					{
						maxSum=currSum;
						target=root;
					}
		}
		printMaxSumFromLeaftoRoot(root.left, maxSum, currSum, target);
		printMaxSumFromLeaftoRoot(root.right, maxSum, currSum, target);
		
	}
}
