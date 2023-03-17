package org.algorithms.strategy.dpanddivideconquer.dc;

import java.util.ArrayList;

public class MergeSort {
    //병합 정렬
    //: 상위의 문제 해결을 위해 분할 가능한 작은 단위까지 분할 후, 합친다.
    //(1) split
    //: 더이상 분리가 불가능할 때까지 분리
    //(2) merge(left, right)
    //: 각각의 포인터를 비교하기 시작하는데 넣어진 인덱스에는 +1하면서 끝까지 비교

    // 4, 1, 2, 5, 7, 5

    /*
    *두 개의 리스트로 분할하는 메서드
     */
    public void splitFunc(ArrayList<Integer> dataList){

        //예외처리
        if(dataList.size()<=1) return;

        //중간 지점 변수
        int mid= dataList.size()/2;

        ArrayList<Integer> leftArr= new ArrayList<>(dataList.subList(0, mid));
        ArrayList<Integer> rightArr= new ArrayList<>(dataList.subList(mid, dataList.size()));
        System.out.println("leftArr = " + leftArr);
        System.out.println("rightArr = " + rightArr);
    }

    /*
    *배열 개수가 1개가 될때까지 분할하고 -> 각각 splitFunc으로 분할해
    * 1개가 되면 합치는 메서드 -> 합치는 메서드인 mergeFunc의 인자로 전달한다.
    * 합치는 메서드 -> 비교 후, 작은 경우 넣고 작은 쪽의 포인터를 이동하면서 하나의 배열로 만든다.
     */
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
        if(dataList.size()<=1){
            return dataList;
        }
        int mid= dataList.size()/2;
        ArrayList<Integer> leftArr=mergeSplitFunc(new ArrayList<>(dataList.subList(0, mid)));
        ArrayList<Integer> rightArr=mergeSplitFunc(new ArrayList<>(dataList.subList(mid, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr){
        ArrayList<Integer> result = new ArrayList<>();
        int lt=0;
        int rt=0;
        while(lt!= leftArr.size() && rt!=rightArr.size()){
            if(leftArr.get(lt)<=rightArr.get(rt)){
                result.add(leftArr.get(lt++));
            }else{
                result.add(rightArr.get(rt++));
            }
        }
        while(lt!=leftArr.size()){
            result.add(leftArr.get(lt++));
        }
        while(rt!=rightArr.size()){
            result.add(rightArr.get(rt++));
        }
        return result;
    }


    /*
    *랜덤 테스트 데이터 추가
     */
    public static void main(String[] args) {
        MergeSort mergesort = new MergeSort();
//        ArrayList<Integer> dataList= (new ArrayList<>(Arrays.asList(4, 1, 2, 5, 7, 5)));
//        mergesort.splitFunc(dataList);
        ArrayList<Integer> dataList= new ArrayList<>();
        for(int i=0;i<100;i++){
            dataList.add((int) (Math.random()*100));
        }

        System.out.println("mergesort.mergeSplitFunc(dataList) = " + mergesort.mergeSplitFunc(dataList));
    }
}
