package org.algorithms.graph.shortestpath;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WeightedGraph {
    public HashMap<String, ArrayList<Edge>> graph;
    public WeightedGraph(){
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B", 8),new Edge("C", 1),new Edge("D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge("B", 5),new Edge("D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("F", 4), new Edge("E",3))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge("A", 5))));
        this.graph=graph;
    }
    public static class Edge implements Comparable<Edge>{
        String name;
        Integer value;

        public Edge(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
        public Edge(String name){
            this.name=name;
        }

        @Override
        public int compareTo(Edge o) {
//            return (o.name==this.name)?o.value-this.value:this.value-o.value;
            return this.value-o.value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }


}
