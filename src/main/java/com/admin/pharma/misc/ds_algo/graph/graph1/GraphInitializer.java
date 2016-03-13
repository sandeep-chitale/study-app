package com.admin.pharma.misc.ds_algo.graph.graph1;

import java.util.ArrayList;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class GraphInitializer {
    public static void main(String[] args) {
        createGraph();
    }

    public static Graph createGraph(){
        //vertex String, weight Int
        Graph<String,Integer> graph = new Graph<String,Integer>();

        Node<String> a = new Node(); a.setData("A");
        Node<String> b = new Node(); b.setData("B");
        Node<String> c = new Node(); c.setData("C");
        Node<String> e = new Node(); e.setData("E");
        Node<String> g = new Node(); g.setData("G");
        Node<String> f = new Node(); f.setData("F");
        Node<String> i = new Node(); i.setData("I");

        graph.adjList.put(a,new ArrayList<>());

        graph.getAdjList().get(a).add(new Edge<String,Integer>(b,new Integer(1)));
        graph.getAdjList().get(a).add(new Edge<String,Integer>(c,new Integer(2)));
        graph.getAdjList().get(a).add(new Edge<String,Integer>(f,new Integer(1)));

        graph.adjList.put(b, new ArrayList<>());

        graph.getAdjList().get(b).add(new Edge<String, Integer>(g, new Integer(7)));

        graph.adjList.put(c,new ArrayList<>());
        graph.getAdjList().get(c).add(new Edge<String, Integer>(e, new Integer(4)));
        graph.getAdjList().get(c).add(new Edge<String, Integer>(f, new Integer(3)));

        graph.adjList.put(e,new ArrayList<>());
        graph.getAdjList().get(e).add(new Edge<String, Integer>(g, new Integer(3)));
        graph.getAdjList().get(e).add(new Edge<String, Integer>(i, new Integer(4)));

        graph.adjList.put(f,new ArrayList<>());
        graph.getAdjList().get(f).add(new Edge<String, Integer>(b, new Integer(4)));
        graph.getAdjList().get(f).add(new Edge<String, Integer>(e, new Integer(2)));

        graph.adjList.put(g,new ArrayList<>());

        graph.adjList.put(i,new ArrayList<>());
        graph.getAdjList().get(i).add(new Edge<String, Integer>(b, new Integer(1)));

        //root node
        graph.setRoot(a);

        return graph;
    }
}