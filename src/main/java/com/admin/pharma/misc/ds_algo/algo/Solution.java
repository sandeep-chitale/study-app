package com.admin.pharma.misc.ds_algo.algo;
import java.util.ArrayList;
import java.util.Scanner;
 
 class Node<T> {
 
    public int value;
    public Node left;
    public Node right;
 
    public Node(int value) {
        this.value = value;
    }
 
}
 
class BinarySearchTree {
 
    public Node root;
    public ArrayList traverseList = new ArrayList();
    public BinarySearchTree insert(int value) {
        Node node = new Node(value);
 
        if (root == null) {
            root = node;
            return this;
        }
 
        insertNode(root, node);
        return this;
    }
 
    private void insertNode(Node latestRoot, Node node) {
 
        if (latestRoot.value > node.value) {
 
            if (latestRoot.left == null) {
                latestRoot.left = node;
                return;
            } else {
                insertNode(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
                return;
            } else {
                insertNode(latestRoot.right, node);
            }
        }
    }
 
    public String printPreorder() {
        printPreOrder(root);
        return traverseList.toString();
    }
 
    private void printPreOrder(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        traverseList.add(currRoot.value);
        printPreOrder(currRoot.left);
        printPreOrder(currRoot.right);
    }
}
 
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            String sp[] = s.split(" ");
            BinarySearchTree bst = new BinarySearchTree();
            ArrayList currentList = new ArrayList();
            for(String m : sp){
                bst.insert(Integer.parseInt(m));
                currentList.add(Integer.parseInt(m));
            }
            if(currentList.toString().equalsIgnoreCase(bst.printPreorder())){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}