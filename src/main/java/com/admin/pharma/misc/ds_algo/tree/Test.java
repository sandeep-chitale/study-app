package com.admin.pharma.misc.ds_algo.tree;

import ds_algo.util.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int number_of_test=sc.nextInt();
		
}
	static String isBST(int numberOfNodes, ArrayList<Integer> preorderList){
		
		Stack<Integer> stack=new Stack<Integer>();
		if(preorderList==null||preorderList!=null&&preorderList.size()==0) return "YES";
		if(preorderList.size()==1) return "YES";
		int root=preorderList.get(0);
		int left=root;
		int right=root;
		int prevRoot=root;
		for(int i=1;i<preorderList.size();i++){
			int node=preorderList.get(i);
			
			
			if(node>=root) right=node;
			if(node<root) left=node;
			
			
		}
		return "NO";
	}
	
}
 