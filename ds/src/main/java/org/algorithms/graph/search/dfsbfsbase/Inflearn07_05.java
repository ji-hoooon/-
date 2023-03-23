package org.algorithms.graph.search.dfsbfsbase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Node{
    Node lt;
    Node rt;
    Integer value;
    Node(int value){
        this.value=value;
    }

    Node(Node lt, Node rt, int value){
        this.lt=lt;
        this.rt=rt;
        this.value=value;
    }
}
public class Inflearn07_05 {
    Node root;

    public static void main(String[] args) {
        Inflearn07_05 main = new Inflearn07_05();
        main.root=new Node(1);
        main.root.lt=new Node(2);
        main.root.rt=new Node(3);
        main.root.lt.lt=new Node(4);
        main.root.lt.rt=new Node(5);
        main.root.rt.lt=new Node(6);
        main.root.rt.rt=new Node(7);

        main.DFS(main.root);

        System.out.println();
        System.out.println(main.preOrder());
        System.out.println(main.inOrder());
        System.out.println(main.postOrder());
    }
    public void DFS(Node root){
        if(root==null) return;
        else {
            //전위 탐색
            System.out.print(root.value + " ");
            DFS(root.lt);
            //중위 탐색
            System.out.print(root.value + " ");
            DFS(root.rt);
            //후위 탐색
            System.out.print(root.value + " ");
        }
    }
    public void insert(int val){
        this.root=insertNode(root, val);
    }
    public Node insertNode(Node node, int val){
        if(node==null) return new Node(val);

        if(node.value>val){
            node.lt=insertNode(node.lt,val);
        }else{
            node.rt=insertNode(node.rt,val);
        }
        return node;
    }

//    public Node insertNode(Node node, int val){
//        if(node==null) return new Node(val);
//
//        if(node.lt==null){
//            node.lt=insertNode(node.lt,val);
//        }else if(node.rt==null){
//            node.rt=insertNode(node.rt,val);
//        }else if(node.lt!=null && node.rt!=null){
//            insertNode(node.lt,val);
//        }
//
//        return node;
//    }
    public List<Integer> inOrder(){
        return this.inOrderNode(root, new ArrayList<>());
    }
    public List<Integer> inOrderNode(Node node, List<Integer> visited){
        //종료조건
        if(node==null) return visited;

        inOrderNode(node.lt, visited);
        visited.add(node.value);
        inOrderNode(node.rt, visited);

        return visited;
    }
    public List<Integer> preOrder(){
        return this.preOrderNode(root, new ArrayList<>());
    }
    public List<Integer> preOrderNode(Node node, List<Integer> visited){
        //종료조건
        if(node==null) return visited;

        visited.add(node.value);
        preOrderNode(node.lt, visited);
        preOrderNode(node.rt, visited);

        return visited;
    }
    public List<Integer> postOrder(){
        return this.postOrderNode(root, new ArrayList<>());
    }
    public List<Integer> postOrderNode(Node node, List<Integer> visited){
        //종료조건
        if(node==null) return visited;

        postOrderNode(node.lt, visited);
        postOrderNode(node.rt, visited);
        visited.add(node.value);

        return visited;
    }
}
