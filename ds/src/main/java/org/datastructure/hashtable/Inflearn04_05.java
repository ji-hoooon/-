package org.datastructure.hashtable;

import java.util.*;

public class Inflearn04_05 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn04_05 main = new Inflearn04_05();
        System.out.println(main.solution(arr,n,m));
    }
    public int solution(int[] arr, int n, int m){
        int answer=-1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1; k<n;k++){
                    set.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int cnt=1;
        for(int x:set){
            if(cnt==m)answer=x;
            cnt++;
        }

        return answer;
//        List<Integer> setList = new ArrayList<>(set);
//
//        return (setList.size() < M ) ? -1 : setList.get(M-1);
    }
}
