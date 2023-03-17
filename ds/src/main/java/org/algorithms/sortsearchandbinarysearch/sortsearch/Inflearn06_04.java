package org.algorithms.sortsearchandbinarysearch.sortsearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Inflearn06_04 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[m];
            for(int i=0;i<m;i++){
                arr[i]= in.nextInt();
            }
            Inflearn06_04 main = new Inflearn06_04();
            for(int x: main.solution(arr,n)){
                System.out.print(x+" ");
            }
        }
        public ArrayList<Integer> solution(int[] arr, int n){
            ArrayList<Integer> list = new ArrayList<>();

            for(int x: arr){
                if(list.contains(x)){
                    list.remove(new Integer(x));
                    list.add(0,x);
                }
                else{
                    if(list.size()==n) list.remove(n-1);
                    list.add(0,x);
                }
            }
            return list;
        }
    }
