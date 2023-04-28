package org.algorithms.search.twopointers.twopointer;

import java.util.ArrayList;
import java.util.Scanner;

public class Inflearn03_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 =new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 =new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=in.nextInt();
        }
        Inflearn03_01 main= new Inflearn03_01();
        for(int x: main.solution(arr1, arr2))
            System.out.print(x+" ");
    }
    public ArrayList<Integer> solution(int[] arr1, int[]arr2){
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(p1!=arr1.length && p2!=arr2.length){
            if(arr1[p1]<=arr2[p2]){
                list.add(arr1[p1++]);
            }else{
                list.add(arr2[p2++]);
            }
        }
        while(p1!=arr1.length) list.add(arr1[p1++]);
        while(p2!=arr2.length) list.add(arr2[p2++]);
        return list;
    }
}