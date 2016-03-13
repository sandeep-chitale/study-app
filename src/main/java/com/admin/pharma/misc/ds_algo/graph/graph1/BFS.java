package com.admin.pharma.misc.ds_algo.graph.graph1;

import ds_algo.util.Queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class BFS {

    public static void main(String[] args) {
//        bfs(GraphInitializer.createGraph());
        bfsUsingList(GraphInitializer.createGraph());
    }

    public static void bfs(Graph graph){
        //Queue for traversing nodes
        Queue<Node<String>> queue = new Queue();
        //Set for visited nodes
        Set<Node<String>> visited = new HashSet<>();

        queue.enQueue(graph.getRoot());

        while(!queue.isEmptyQueue()){
            Node v = queue.deQueue();
            System.out.println(v.getData() +" Adjacent Nodes ");

//            Map t = graph.getAdjList();

            //enqueue successors
            for(Edge node :  (List<Edge>)graph.getAdjList().get(v)){
                System.out.print(node.getTarget().getData() + " ");

                //is already visited
                if(! visited.contains(node.getTarget()) && !queue.contains(node.getTarget())){
                    queue.enQueue(node.getTarget());
                }
            }
            System.out.println();

            visited.add(v);


        }
    }

    public static void bfsUsingList(Graph graph){
        //Queue for traversing nodes
        List<Node<String>> queue = new ArrayList<>();
        //Set for visited nodes
        Set<Node<String>> visited = new HashSet<>();

        queue.add(graph.getRoot());

        while(!queue.isEmpty()){
            Node v = queue.remove(0);
            System.out.println(v.getData() +" Adjacent Nodes ");

//            Map t = graph.getAdjList();

            //visit successors
            for(Edge node :  (List<Edge>)graph.getAdjList().get(v)){
                System.out.print(node.getTarget().getData() + " ");

                //is already visited
                if(! visited.contains(node.getTarget()) && !queue.contains(node.getTarget())){
                    queue.add(node.getTarget());
                }
            }
            System.out.println();

            visited.add(v);


        }
    }
}
