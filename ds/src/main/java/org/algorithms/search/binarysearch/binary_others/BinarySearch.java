package org.algorithms.search.binarysearch.binary_others;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10; i++){
            list.add((int)(Math.random()*100));
        }
        System.out.println("list = " + list);
        BinarySearch bs = new BinarySearch();
        Collections.sort(list);
        System.out.println("bs.search(list, 45) = " + bs.searchFunc_1(list, 45));
        System.out.println("bs.search(list, 45) = " + bs.searchFunc_2(list, 45));
    }

    //1. while문으로 구현
    private boolean searchFunc_1(ArrayList<Integer> list, int n) {
        System.out.println("sorted list = " + list);

        int lt=0;
        int rt=list.size()-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(list.get(mid)==n){
                return true;
            }
            if(list.get(mid)>n){
                rt=mid-1;
            }else{
                lt=mid+1;
            }
        }
        return false;
    }

    /*
    *재귀함수 호출을 이용한 분할 정복으로 구현
     */
    public boolean searchFunc_2(ArrayList<Integer> dataList, Integer searchItem){
        //(1) 찾을 리스트의 길이에 따른 예외처리
         if(dataList.size()==1 && searchItem==dataList.get(0)) return true;
         else if (dataList.size()==1 && searchItem==dataList.get(0)) return false;
         else if(dataList.size()==0) return false;

         //(2) 재귀함수 호출
         int mid=dataList.size()/2;
         if(searchItem==dataList.get(mid)) return true;
         else {
             if(searchItem<dataList.get(mid)) return searchFunc_2(new ArrayList<>(dataList.subList(0,mid)), searchItem);
             else return searchFunc_2(new ArrayList<>(dataList.subList(mid+1, dataList.size())), searchItem);
         }
    }
}
