package org.algorithms.graph.search;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph {
    public HashMap<String, ArrayList<String>> graph;
    public Graph(){
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A","G","H","I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));
        this.graph=graph;
    }
}
