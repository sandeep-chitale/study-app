package com.admin.pharma.misc.ds_algo.graph.graph1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sachin.chitale on 09/03/16.
 */
public class Node<V> {
    private V data;
    List<Node<V>> successors = new ArrayList<>();
    List<Node<V>> predessors = new ArrayList<>();

    public V getData() {
        return data;
    }

    public List<Node<V>> getSuccessors() {
        return successors;
    }

    public List<Node<V>> getPredessors() {
        return predessors;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void setSuccessors(List<Node<V>> successors) {
        this.successors = successors;
    }

    public void setPredessors(List<Node<V>> predessors) {
        this.predessors = predessors;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Node<?> node = (Node<?>) o;
//        return Objects.equals(getData(), node.getData()) &&
//                Objects.equals(getSuccessors(), node.getSuccessors());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getData(), getSuccessors());
//    }
}
