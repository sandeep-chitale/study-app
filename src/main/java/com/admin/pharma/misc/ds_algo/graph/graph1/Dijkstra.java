package com.admin.pharma.misc.ds_algo.graph.graph1;

import ds_algo.util.Queue;

import java.util.*;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class Dijkstra {

    public static void main(String[] args) {
        dijkstra(GraphInitializer.createGraph());
    }

    public static void  dijkstra(Graph graph){
        //BFS traversal of a graph
        Map<Node,Integer> shortestDistances = new HashMap<>();

        //BFS traversal

        //Queue for traversing nodes
        Queue<Node<String>> queue = new Queue();
        //Set for visited nodes
        Set<Node<String>> visited = new HashSet<>();

        queue.enQueue(graph.getRoot());

        shortestDistances.put(graph.getRoot(),0);

        while(!queue.isEmptyQueue()){
            Node v = queue.deQueue();
            System.out.println(v.getData());

//            Map t = graph.getAdjList();

            //enq successors
            for(Edge<String,Integer> edge :  (List<Edge>)graph.getAdjList().get(v)){

                //check vertex added if not add
                if(!shortestDistances.containsKey(edge.getTarget())){
                    //A-->B-->G
                    int currentDist = (shortestDistances.get(v) == null) ? 0 : shortestDistances.get(v);

                    shortestDistances.put(edge.getTarget(), edge.getWeight()+currentDist);
                }
                else{ // multiple path for a node
                    int currentDist =  shortestDistances.get(v) + edge.getWeight();

                    if(shortestDistances.get(edge.getTarget()) > currentDist)
                        shortestDistances.put(edge.getTarget(),currentDist);
                }

                //is already visited
                if(! visited.contains(edge.getTarget()) && !queue.contains(edge.getTarget())){
                    queue.enQueue(edge.getTarget());
                }
            }

            visited.add(v);


        }
        for(Map.Entry<Node,Integer> nodeEntry: shortestDistances.entrySet()){

            System.out.println(nodeEntry.getKey().getData() + " : "+nodeEntry.getValue());
        }
    }

}
