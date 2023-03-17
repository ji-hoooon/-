package org.datastructure.list;

public class MyDoubleLinkedList<T> implements IList<T> {
    //요약 : 더미노드인 헤드노드, 테일노드를 이용해 구현하는데, 인덱스가 size/2의 이전인지 이후인지에 따라
    //이전이면 헤드노드부터 오른쪽으로 탐색을 수행하고, 이후면 테일노드부터 왼쪽으로 탐색을 수행한다.

    //더블 링크드 리스트
    //특징 :
    //1. 데이터 추가 :
    // 단일 연결 리스트의 경우 가장 마지막 노드를 찾기 위해 헤드부터 찾는다. : O(n)
    // 더블 연결 리스트의 경우 가장 마지막 노드를 찾기 위해 tail 노드의 prev 포인터가 마지막 노드가 된다. :O(1)

    //2. 인덱스를 통한 데이터 조회 :
    // 단일 연결 리스트의 경우 index에 해당하는 노드를 찾기 위해 헤드노드부터 찾아야 한다. : O(n)
    // 더블 연결 리스트의 경우 index에 해당하는 노드를 찾기 위해 사이즈의 중간을 기준으로 가까운 곳에서 찾는다. : O(n) [O(n/2)]
    // head 노드의 next부터 찾는 방법, tail 노드의 prev부터 찾는 방법

    //3. 인덱스를 통한 데이터 삽입 :
    //(1) 삽입할 인덱스의 노드 찾기
    //사이즈의 중간을 기준으로 가까운 곳에서 찾는다. : O(n) [O(n/2)]
    //head 노드의 next부터 찾는 방법, tail 노드의 prev부터 찾는 방법
    //(2) 새로 삽입할 노드의 prev 노드에 current 노드의 prev 포인터를 대입하고, next 노드에 current 노드를 대입한다.
    //-> index에 해당하는 current 노드에 노드를 추가하고 이전의 연결관계에  새로운 노드를 추가한 연결 관계 성립

    //4. 인덱스를 통한 데이터 삭제 :
    //삭제할 노드를 가리키는 연결 관계를 변경하는 작업
    //(1) 삭제할 인덱스의 노드 찾기
    //(2) 해당 인덱스의 노드를 연결을 끊는다. = 노드의 삭제
    //(3) current 노드의 prev 노드의 next 포인터가 가리키는 대상을 현재 노드에서 현재 노드의 next 노드를 가리키도록 연결 관계 변경
    //(4) current 노드의 next 노드의 prev 포인터가 가리키는 대상을 현재 노드에서 현재 노드의 prev 노드를 가리키도록 연결 관계 변경


    //더블 연결 리스트 구현 순서
    //1. 멤버변수 선언
    //: 헤드 노드를 가리키는 변수, 테일 노드를 가리키는 변수, 사이즈를 저장하는 변수
    //2. 생성자 작성
    //: 사이즈를 0으로, 헤드 노드와 테일 노드를 더미노드로 초기화
    //: 헤드 노드의 다음 포인터에는 테일 노드를 대입하고, 테일 노드의 이전 포인터에는 헤드 노드를 대입해 초기화
    //3. 메서드 구현

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        // size()
        // clear()
        // add()
    }

    //3-1. 데이터 삽입 메서드
    //(1) 추가할 노드인 newNode를 생성하기 위해, 노드 참조변수 last 선언
    //-> last에는 테일 노드의 이전 노드를 가리키도록 대입
    //: 새로운 노드를 초기화는
    // (T data, Node prev, Node next) 생성자를 이용해 (t, last, tail)를 인자로 전달해 초기화
    // 즉, 추가된 새로운 노드는
    // : t 데이터를 가지고, 이전 노드로는 last인 테일 노드의 이전노드를 가리키고, 다음 노드로는 테일 노드를 가리키는 노드
    //(2) 테일 노드를 가리키던 연관관계의 변경
    //tail 노드의 prev 노드를 가리키는 last 노드의 next 포인터에 tail 노드를 가리키는 연결을 새로운 노드를 가리키도록 변경
    //tail 노드의 prev 포인터에 tail 노드를 가리키는 연결을 새로운 노드를 가리키도록 변경

    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node newNode = new Node(t, last, tail);
        last.next = newNode;
        this.tail.prev = newNode;
        this.size++;
        // 그 다음 get(index)
    }

    @Override
    public void insert(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = null;
        Node current = null;
        int i = 0;

        if (index < this.size / 2) {
            prev = this.head;
            current = this.head.next;
            while (i++ < index) {
                prev = prev.next;
                current = current.next;
            }
        } else {
            current = this.tail;
            prev = this.tail.prev;
            while (i++ < (this.size - index)) {
                current = current.prev;
                prev = prev.prev;
            }
        }
        Node newNode = new Node(t, prev, current);
        current.prev = newNode;
        prev.next = newNode;
        this.size++;
        // 그 다음 delete by index
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node current = prev.next;
        while (current != null) {
            if (current.data.equals(t)) {
                prev.next = current.next;
                current.next.prev = prev;
                current.next = null;
                current.prev = null;
                this.size--;
                return true;
            }
            prev = prev.next;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = null;
        Node current = null;
        Node next = null;

        int i = 0;
        if (index < this.size / 2) {
            prev = this.head;
            current = this.head.next;
            while (i++ < index) {
                prev = prev.next;
                current = current.next;
            }
            prev.next = current.next;
            current.next.prev = prev;
            current.next = null;
            current.prev = null;
        } else {
            current = this.tail.prev;
            next = this.tail;
            while (i++ < (this.size - index - 1)) {
                next = next.prev;
                current = current.prev;
            }
            next.prev = current.prev;
            current.prev.next = next;
            current.next = null;
            current.prev = null;
        }
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Node current = null;
        if (index < this.size / 2) {
            current = this.head.next;
            while (i++ < index) {
                current = current.next;
            }
        } else {
            current = this.tail.prev;
            while (i++ < (this.size - index - 1)) {
                current = current.prev;
            }
        }
        return current.data;
        // 그 다음 insert(index)
    }

    @Override
    public int indexOf(T t) {
        Node currentHead = this.head.next;
        Node currentTail = this.tail.prev;
        int index = 0;
        while (currentHead != null || currentTail!=null) {
            if (currentHead.data != null && currentHead.data.equals(t)) {
                return index;
            }
            if (currentTail.data != null && currentTail.data.equals(t)) {
                return size-index-1;
            }
            currentHead = currentHead.next;
            currentTail = currentTail.prev;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    @Override
    public boolean contains(T t) {
        Node currentHead = this.head.next;
        Node currentTail = this.tail.prev;

        while (currentHead != null||currentTail!=null) {
            if (currentHead.data != null && currentHead.data.equals(t)) {
                return true;
            }
            if (currentTail.data != null && currentTail.data.equals(t)) {
                return true;
            }
            currentHead = currentHead.next;
            currentTail = currentTail.prev;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
