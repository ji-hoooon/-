package org.datastructure.stack;

public class MyStack<T> implements IStack<T> {

    private int size;
    private Node head;

    public MyStack(){
        this.size = size();
        this.head = new Node(null); //코드의 간결성을 위해 더미노드를 가지도록 생성
    };


    @Override
    public void push(T data) {
        //파라미터로 받은 Node가 this.head.next를 가리키도록 새로운 노드 생성
        Node newNode = new Node(data, this.head.next);
        this.head.next = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node curr = head.next;
        head.next = curr.next;
        curr.next=null;
        this.size--;
        return curr.data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private class Node {
        Node next;
        T data;

        Node(T data) {
            this.data=data;
        }
        public Node(T data,Node next) {
            this.data=data;
            this.next = next;
        }
    }
}
