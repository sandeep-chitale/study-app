package com.admin.pharma.misc.ds_algo.graph.graph1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class DFS {

    public static void main(String[] args) {
        dfs(GraphInitializer.createGraph());

    }

    public static void dfs(Graph graph){
        //Queue for traversing nodes
        List<Node<String>> stack = new ArrayList<>();
        //Set for visited nodes
        Set<Node<String>> visited = new HashSet<>();

        stack.add(graph.getRoot());

        while(!stack.isEmpty()){
            Node v = stack.remove(stack.size()-1); // Get top
            System.out.println(v.getData() +" Adjacent Nodes ");


            //visit successors
            for(Edge node :  (List<Edge>)graph.getAdjList().get(v)){
                System.out.print(node.getTarget().getData() + " ");

                //is already visited
                if(! visited.contains(node.getTarget()) && !stack.contains(node.getTarget())){
                    stack.add(node.getTarget());
                }
            }
            System.out.println();

            visited.add(v);


        }

    }
}
