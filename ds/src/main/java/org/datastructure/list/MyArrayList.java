package org.datastructure.list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
    //요약 : 삽입시 배열의 크기가 충분한지 체크, 부족할 경우 현재의 크기보다 *2해서 새로 생성 후, 배열을 복사
    //데이터 중간에 삽입시, 데이터들을 모두 오른쪽으로 이동시키고,
    //중간의 데이터 삭제시, 데이터들을 모두 왼쪽으로 이동시킨다.

    //배열 리스트 구현 순서
    //1. 멤버 변수 생성자
    //(1) 리스트의 기본 사이즈인 전역 상수
    //(2) 데이터 저장 공간 배열
    //(3) 사이즈 저장 변수
    //(4) 기본 생성자 : 기본 사이즈 상수를 이용해 배열 크기 지정

    static final int DEFAULT_SIZE = 50;
    private int size;
    private T[] elements;

    public MyArrayList() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }


    //2-1. 데이터 삽입 메서드
    //(1) 삽입시 배열 크기 체크 : 부족시 배열 크기*2로 생성자를 이용해 객체 생성
    //(2) 배열에 해당 데이터 추가
    @Override
    public void add(T t) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        this.elements[size++] = t;
    }
    //2-2. 중간에 데이터 삽입 메서드
    //(1) 삽입시 배열 크기 체크 : 부족시 배열 크기*2로 생성자를 이용해 객체 생성
    //(2) 중간에 배열에 해당 데이터 추가시, 배열을 오른쪽으로 이동 후 원하는 인덱스에 삽입

    @Override
    public void insert(int index, T t) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        for (int i = index; i < this.size; i++) {
            this.elements[i+1] = this.elements[i];
        }
        this.elements[index] = t;
        this.size++;
    }

    //2-3. 초기화 메서드 : 사이즈를 0으로 만든다. -> 자동 덮어쓰기
    @Override
    public void clear() {
        this.size = 0;
    }

    //2-4. boolean 반환하는 데이터 삭제 메서드
    //(1) 원하는 데이터 존재여부 체크 -> 0번 인덱스부터 사이즈까지 순서대로 찾는다
    //(2) 찾았으면, 해당 인덱스부터 사이즈까지 모든 데이터를 왼쪽으로 이동

    @Override
    public boolean delete(T t) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(t)) {
                for (int j = i; j < this.size -1; j++) {
                    this.elements[j] = this.elements[j+1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }
    //2-5. boolean 반환하는 인덱스에 해당하는 데이터 삭제 메서드
    //(1) 해당 인덱스가 유효한 인덱스 체크
    //(2) 해당 인덱스부터 사이즈까지 모든 데이터를 왼쪽으로 이동
    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            return false;
        }
        for (int i = index; i < this.size-1; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
        return true;
    }

    //2-6. 해당 인덱스에 해당하는 요소를 반환하는 메서드
    //(1) 해당 인덱스가 유효한지 체크해서 예외처리
    //(2) 유효한 인덱스가 아니면, IndexOutOfBoundsException 예외 반환
    //(3) 유효한 인덱스인 경우, 해당 인덱스에 해당하는 데이터 반환
    @Override
    public T get(int index) {
        if (this.size <= index) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    //2-7. 원하는 데이터가 존재하면 해당 인덱스를 반환하는 메서드
    //(1) 인덱스 0부터 끝까지 일치하는 요소가 있는지 체크
    //(2) 존재하면 해당 인덱스 반환, 존재하지 않으면 -1 반환
    @Override
    public int indexOf(T t) {
        for(int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //2-8. 비었는지 확인하는 메서드
    //(1) size==0이 맞으면 true, 아니면 false
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //2-9. 해당 데이터가 존재하는지 확인하는 메서드
    //(1) 해당 데이터가 존재하는지 for문을 돌면서 같은지 확인하고, 같은게 존재하면 true 반환
    @Override
    public boolean contains(T t) {
        for(T elem : this.elements) {
            if (elem.equals(t)) {
                return true;
            }
        }
        return false;
    }

    //2-10. 사이즈 반환하는 메서드
    //(1) size 변수를 반환
    @Override
    public int size() {
        return this.size;
    }
}
