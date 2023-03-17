package org.datastructure.list;

import org.w3c.dom.Node;

public class MyLinkedList<T> implements IList<T> {
    //요약 : 헤드 노드를 더미 노드를 이용해 구현하고, 인덱스를 이용할 경우 인덱스 예외처리 필수
    //데이터 요소에 접근하기 위해서는 헤드 노드부터 데이터를 탐색하는 과정 필요

    //연결 리스트 구현 순서
    //1. Node 클래스 작성
    //: T data, Node next, 생성자
    //2. 멤버 변수 선언
    //(1) 사이즈를 저장하는 변수
    //(2) 헤드 노드를 저장하는 변수
    //3. 생성자 작성
    //: size=0으로 만들고, 헤드 노드에 null을 담도록 초기화
    //4. 메서드 구현
    //: 더미 노드를 이용해 메서드를 작성한다.
    // 헤드 노드를 이용해데이터 삽입, 조회, 삭제를 수행한다.
    //따라서 헤드 노드와의 연결이 끊기면 모든 노드의 연결이 끊기게 된다.


    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null);
    }
    //4-1. 데이터 삽입 메서드
    //(1) 마지막에 위치한 데이터의 다음 노드로 지정하기 위해 데이터 탐색 필요
    //(2) 헤드 노드부터 시작해 다음 노드가 null이 될 때까지 탐색한다.
    //(3) 다음 노드가 null인 노드의 next에 데이터를 삽입
    @Override
    public void add(T t) {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        Node n = new Node(t);
        current.next = n;
        this.size++;
    }

    //4-2. 원하는 인덱스에 데이터 삽입 메서드
    //(1) 인덱스 예외처리 필요
    //(2) 인덱스가 사이즈보다 크거나, 인덱스가 0보다 작으면 IndexOutOfBoundException 예외 발생
    //(3) 마지막에 위치한 데이터의 다음 노드로 지정하기 위해 데이터 탐색 필요
    //(4) 헤드 노드부터 시작해 다음 노드가 null이 될 때까지 탐색한다.
    //(5) 다음 노드가 null인 노드의 next에 데이터를 삽입
    @Override
    public void insert(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = this.head;
        Node current = prev.next;

        int i = 0;
        while (i++ < index) {
            prev = prev.next;
            current = current.next;
        }

        Node newNode = new Node(t, current);
        prev.next = newNode;
        this.size++;
    }

    //4-3. 초기화 메서드 -생성자를 이용해 초기화 한 상태로 변경
    //: size=0으로 만들고, 헤드 노드에 null을 담도록 초기화
    @Override
    public void clear() {
        this.size = 0;
        this.head.next = null;
    }

    //4-4. 데이터 삭제 메서드
    //(1) 해당 데이터가 존재하는지 체크하는 과정이 선행되어야 한다. -> 헤드 노드부터 탐색 시작
    //(2) 이전 노드 포인터가 헤드를 가리키도록하고, 현재 노드 포인터가 헤드의 다음 노드를 가리키도록 한다.
    //(3) 현재 노드가 null일 때까지 반복하면서, 현재 노드가 찾는 데이터와 일치하는지 체크한다.
    //->일치하지 않으면, prev에 prev 노드의 다음 포인터를 삽입하고, currnet에 current 노드의 다음 포인터를 삽입해 탐색 수행
    //(4) 일치할 경우 이전 노드 포인터의 다음 노드 포인터에 현재 노드의 다음 포인터를 대입하고, 현재 노드의 다음 포인터에 null을 넣는다.
    //-> 연결관계를 정리하는 과정
    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node current = prev.next;
        while (current != null) {
            if (current.data.equals(t)) {
                prev.next = current.next;
                current.next = null;
                this.size--;
                return true;
            }
            prev = prev.next;
            current = current.next;
        }
        return false;
    }

    //4-5. 인덱스를 이용한 데이터 삭제 메서드
    //(1) 인덱스 예외처리 수행
    //(2) 인덱스가 사이즈보다 크거나, 인덱스가 0보다 작으면 IndexOutOfBoundException 예외 발생
    //(2) 이전 노드 포인터가 헤드를 가리키도록 하고, 현재 노드 포인터가 헤드의 다음 노드를 가리키도록 한다.
    //(3) index 직전까지 반복하면서, 이전 노드는 이전 노드의 다음 포인터를, 현재 노드는 현재 노드의 다음 포인터를 가리키도록 한다,
    //(4) index 전의 노드인 prev노드의 다음 포인터에 현재 노드의 다음 포인터를 대입하고, 현재 노드의 다음 포인터에 null을 대입한다.
    //-> 삭제할 노드의 연결 관계를 끊고, 삭제한 노드 이전 노드와 연결하는 과정
    @Override
    public boolean deleteByIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = this.head;
        Node current = prev.next;
        int i = 0;
        while (i++ < index) {
            prev = prev.next;
            current = current.next;
        }

        prev.next = current.next;
        current.next = null;
        this.size--;
        return true;
    }

    //4-6. 인덱스에 해당하는 데이터를 반환하는 메서드
    //(1) 인덱스 예외처리 수행
    //(2) 인덱스가 사이즈보다 크거나, 인덱스가 0보다 작으면 IndexOutOfBoundException 예외 발생
    //(3) 인덱스에 해당하는 노드전까지 이동한다.
    //-> 현재 노드에 현재 노드의 다음 포인터를 대입해가면서 이동
    //(4) 현재 노드의 데이터를 반환해 인덱스에 해당하는 노드의 데이터를 반환
     @Override
    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node current = this.head.next;
        int i = 0;
        while (i++ < index) {
            current = current.next;
        }
        return current.data;
    }

    //4-7. 해당하는 데이터를 가진 인덱스를 반환하는 메서드
    //(1) 헤드 노드를 시작으로 데이터 탐색 수행
    //(2) 현재 노드가 null이 될때까지 현재 노드에 현재 노드의 다음 포인터를 대입하면서 반복
    //(3) 현재 노드의 데이터가 null이 아니고, 현재 노드의 데이터가 찾는 데이터와 일치한다면, 해당 인덱스를 반환
    //(4) 이러한 경우가 존재하지 않는다면 -1 반환
    @Override
    public int indexOf(T t) {
        Node current = this.head.next;
        int index = 0;
        while (current != null) {
            if (current.data != null && current.data.equals(t)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //4-8. 비었는지 확인하는 메서드
    //: 헤드의 다음 노드에 null이면 true 반환, 아니면 false 반환
    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    //4-9. 해당 데이터가 포함되어있는지 여부를 반환하는 메서드
    //(1) 현재 노드에 헤드 노드의 다음 포인터를 대입한다.
    //(2) current 노드에 current 노드의 다음 포인터를 대입하는데 현재 노드가 null일 때까지 반복한다.
    //(3) 반복하면서 현재 노드의 데이터가 null이 아니고, 현재 노드의 데이터가 찾는 데이터와 일치하면 true를 반환한다.
    @Override
    public boolean contains(T t) {
        Node current = this.head.next;
        while (current != null) {
            if (current.data != null && current.data.equals(t)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //4-10. 사이즈를 반환하는 메서드
    //: 사이즈 변수를 반환한다.

    @Override
    public int size() {
        return this.size;
    }


}
