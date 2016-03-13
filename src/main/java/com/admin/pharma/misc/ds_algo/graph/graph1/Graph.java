package com.admin.pharma.misc.ds_algo.graph.graph1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class Graph<V,W> {
    Node<V> root;
    //Adj List
    Map<Node<V>,ArrayList<Edge<V,W>>> adjList  = new HashMap<>();

    public Node<V> getRoot() {
        return root;
    }

    public Map<Node<V>, ArrayList<Edge<V, W>>> getAdjList() {
        return adjList;
    }

    public void setRoot(Node<V> root) {
        this.root = root;
    }

    public void setAdjList(Map<Node<V>, ArrayList<Edge<V, W>>> adjList) {
        this.adjList = adjList;
    }
}
