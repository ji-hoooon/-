package org.algorithms.sortsearchandbinarysearch.sortsearch;

import java.util.HashSet;
import java.util.Scanner;

public class Inflearn06_05 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++){
                set.add(in.nextInt());
            }
            Inflearn06_05 main = new Inflearn06_05();
            System.out.println(main.solution(n,set));
        }
        public String solution(int n, HashSet<Integer> set){
            return set.size()==n?"U":"D";
        }
    }