package org.algorithms.strategy.dpanddivideconquer.dc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    //퀵 정렬
    //1. 기준점을 정하기
    //2. left, right 리스트로 분류하기
    //3. 데이터 수가 1개가 될때까지 분류한 리스트에서 다시 기준점 잡고 분류하는 작업 수행

    static ArrayList<Integer> result = new ArrayList<>();

    public void splitFunc(ArrayList<Integer> dataList){
        if(dataList.size()<=1) return;
        int pivot=dataList.get(0);
        dataList.remove(0);

        int mid=dataList.size()/2;
        ArrayList<Integer> leftArr =new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int index=1; index<dataList.size();index++){
            if(dataList.get(index)>pivot){
                rightArr.add(dataList.get(index));
            }else{
                leftArr.add(dataList.get(index));
            }
        }
        System.out.println(leftArr);
        System.out.println(pivot);
        System.out.println(rightArr);

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(leftArr);
        mergedArr.add(pivot);
        mergedArr.addAll(rightArr);
        System.out.println(mergedArr);
    }
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        if(dataList.size()<=1) return dataList;
        int pivot=dataList.get(0);

        ArrayList<Integer> leftArr =new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int index=1; index<dataList.size();index++){
            if(dataList.get(index)>pivot){
                rightArr.add(dataList.get(index));
            }else{
                leftArr.add(dataList.get(index));
            }
        }
//        System.out.println("분류");
//        System.out.println(leftArr);
//        System.out.println(pivot);
//        System.out.println(rightArr);

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(this.sort(leftArr));
//        mergedArr.add(pivot);
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));
//        System.out.println(mergedArr);

        return mergedArr;
    }

    public static void main(String[] args) {
//        Integer[] dataList= {9,4,1,2,5,7,8};
//        QuickSort sort = new QuickSort();
//        System.out.println("sort.sort(new ArrayList<>( Arrays.asList(dataList))) = " + sort.sort(new ArrayList<>(Arrays.asList(dataList))));

        //테스트 데이터 생성
        ArrayList<Integer> testData=new ArrayList<>();
        for(int index=0;index<100;index++) testData.add((int)(Math.random()*100));;
        QuickSort quickSort = new QuickSort();
        System.out.println("quickSort.sort(testData) = " + quickSort.sort(testData));
    }
}
