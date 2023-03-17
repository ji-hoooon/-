package org.datastructure.tree;


import java.util.ArrayList;
import java.util.List;

public class BST <T extends Comparable<T>> implements ITree<T>{
    //제네릭 메서드 : 타입을 원하는 타입으로 제한 할 수 있는 T로 지정해 작성한 후, 메서드 호출시 타입을 명시한다.

    //멤버변수
    private Node root;
    private int size;
    //메서드 작성시 항상 루트 노드부터 시작한다.

    //(1) min, max 메서드
    //(2) 순회하는 메서드
    //(3) BST 메서드 : contains, insert, delete

    //(1) min, max 메서드
    public T min(){
        return this.minNode(this.root);
    }

    private T minNode(Node node) {
        //해당 노드의 데이터가 가장 작은 데이터라고 가정 후, 가장 왼쪽에 위치한 노드까지 파고 들어가면서 비교
        T minData = node.data;
        while(node.left!=null){
            minData=node.left.data;
            node=node.left;
        }

        return minData;
    }
    public T max(){
        return this.maxNode(this.root);
    }

    private T maxNode(Node node) {
        //해당 노드의 데이터가 가장 큰 데이터라고 가정 후, 가장 오른쪽에 위치한 노드까지 파고 들어가면서 비교
        T maxData = node.data;
        while(node.right!=null){
            maxData=node.right.data;
            node=node.right;
        }

        return maxData;
    }

    //(2) 순회하는 메서드
    //재귀적 구조로 작성
    //중위 순회
    public List<T> inOrder(){
        return this.inOrderNode(root, new ArrayList<>());
    }

    private List<T> inOrderNode(Node node, List<T> visited) {
        //종료 조건 확인
        if(node ==null) return visited;

        //좌서브트리
        inOrderNode(node.left, visited);
        //루트 노트
        visited.add(node.data);
        //우서브트리
        inOrderNode(node.right, visited);

        return visited;
    }
    //전위 순회
    public List<T> preOrder(){
        return this.preOrderNode(root, new ArrayList<>());
    }

    private List<T> preOrderNode(Node node, List<T> visited) {
        //종료 조건 확인
        if(node ==null) return visited;

        //루트 노트
        visited.add(node.data);
        //좌서브트리
        preOrderNode(node.left, visited);
        //우서브트리
        preOrderNode(node.right, visited);

        return visited;
    }
    //후위 순회
    public List<T> postOrder(){
        return this.postOrderNode(root, new ArrayList<>());
    }

    private List<T> postOrderNode(Node node, List<T> visited) {
        //종료 조건 확인
        if(node ==null) return visited;

        //좌서브트리
        postOrderNode(node.left, visited);
        //우서브트리
        postOrderNode(node.right, visited);
        //루트 노트
        visited.add(node.data);


        return visited;
    }


    //ITree 인터페이스의 추상메서드 구현
    //(1) 탐색 : 루트 노드부터 크기를 비교해 노드값 존재하는지 탐색
    //(2) 삽입 : 루트 노드부터 크기를 비교해 알맞은 위치에 삽입
    //(3) 삭제 : 루트 노드부터 크기를 비교해 해당 노드 삭제 후, 이진탐색트리 특성 유지하도록 수선
    @Override
    public void insert(T val) {
        //노드를 추가해 반환한 노드를 루트에 저장
        this.root=insertNode(root, val);
        //사이즈 늘리기
        size++;
    }

    private Node insertNode(Node node, T val) {
        //종료조건 지정
        if(node==null) return new Node(val);

        //같을 때는 삽입이 불가능 하므로 그대로 반환
        //: 이진탐색트리는 값의 중복이 불가능
        //val < node.data : -1
        //val > node.data : 1
        //val = node.data : 0

        if(val.compareTo(node.data)<0){
            node.left=insertNode(node.left, val);
        }
        if(val.compareTo(node.data)>0){
            node.right=insertNode(node.right, val);
        }

        return node;
    }

    @Override
    public void delete(T val) {
        //노드를 삭제 후 반환한 노드를 루트에 저장
        this.root=deleteNode(root, val);

    }

    private Node deleteNode(Node node, T val) {
        //종료조건 지정
        if(node==null) return null;

        //1. 리프 노드 일 때
        //2. 자식노드가 하나일 때
        //3. 자식노드가 2개일 때 : 우측서브트리의 최솟값과 교체
        if(val.compareTo(node.data)<0){
            node.left=deleteNode(node.left, val);
        }
        else if(val.compareTo(node.data)>0){
            node.right=deleteNode(node.right, val);
        }else{
            //같을 때 삭제
            this.size--;

            //오른쪽 자식 노드 존재
            if(node.left==null){
                return node.right;

            //왼쪽 자식 노드 존재
            }else if(node.right==null){
                return node.left;
            }
            //자식노드가 둘다 있을 때 -> 해당 노드 삭제 후, 우측서브트리의 최솟값을 위치시킨다.
            node.data=minNode(node.right);
            node.right=deleteNode(node.right, node.data);
        }

        return node;
    }

    @Override
    public boolean contains(T val) {
        return containsNode(root, val);
    }

    private boolean containsNode(Node node, T val) {
        //종료조건 지정
        if(node==null) return false;

        //val < node.data : -1
        //val > node.data : 1
        //val = node.data : 0

        //같으면 존재한다고 리턴
        if(val.compareTo(node.data)==0){
            return true;
        }
        //값이 더 작으면 왼쪽으로 파고들기
        if(val.compareTo(node.data)<0){
            return containsNode(node.left, val);
        }
        //값이 더 크면 오른쪽으로 파고들기
        return containsNode(node.right, val);
    }

    @Override
    public int size() {
        return this.size;
    }
    private class Node {
        public Node left;
        public Node right;
        public T data;

        Node(T data){
            this.data=data;
        }

        Node(Node left, Node right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BST bst1 = new BST();
        bst1.insert(1);
        bst1.insert(9);
        bst1.insert(8);
        bst1.insert(6);
        bst1.insert(5);
        bst1.insert(4);
        bst1.insert(7);
        bst1.insert(3);
        bst1.insert(2);
        bst1.delete(7);
        System.out.println("bst1.contains(7) = " + bst1.contains(7));
        System.out.println("bst1.contains(5) = " + bst1.contains(5));
        System.out.println("bst1.inOrder() = " + bst1.inOrder());
        System.out.println("bst1.preOrder() = " + bst1.preOrder());
        System.out.println("bst1.postOrder() = " + bst1.postOrder());
        System.out.println("bst1.size = " + bst1.size);

    }

}
