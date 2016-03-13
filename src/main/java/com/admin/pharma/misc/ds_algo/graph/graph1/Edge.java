package com.admin.pharma.misc.ds_algo.graph.graph1;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class Edge<V,W> {
    W weight;

    public Edge( Node<V> target,W weight) {
        this.weight = weight;
        this.target = target;
    }

    private Node<V> target;

    public Node<V> getTarget() {
        return target;
    }

    public void setTarget(Node<V> target) {
        this.target = target;
    }

    public W getWeight() {
        return weight;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }
}
