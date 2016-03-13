package com.admin.pharma.misc.ds_algo.tree;

public class AreMirrorTree {

	boolean areMirrorTree(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2){
		if(root1==null&&root2==null) return true;
		if(root1==null||root2!=null) return false;
		if(root1!=null||root2==null) return false;
		else
			return(areMirrorTree(root1.left, root2.right)&&areMirrorTree(root1.right, root2.left));
	}
}
