package org.algorithms.ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn02_10 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        Inflearn02_10 main = new Inflearn02_10();
        for(int x : main.solution(str, c)){
            System.out.print(x+" ");
        }
    }
    public int[] solution(String str, char c){
        int[] arr = new int[str.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int tmp=0;
        char[] charArr = str.toCharArray();
        for(int i=0;i <arr.length;i++){
            if(charArr[i]==c) {
                tmp=0;
                arr[i]=tmp++;
                int j=i+1;
                while(j<arr.length&&charArr[j]!=c){
                    arr[j]=Math.min(arr[j], tmp++);
                    j++;
                }
                tmp=1;
                j=i-1;
                while(j>=0&&charArr[j]!=c){
                    arr[j]=Math.min(arr[j], tmp++);
                    j--;
                }
            }
        }
        return arr;
    }
}
