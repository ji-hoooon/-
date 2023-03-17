package org.algorithms.graph.minimumspanning.prim;

import java.util.Scanner;
import java.util.*;
class Room{
    public int s;
    public int e;
    Room(int s, int e){
        this.s=s;
        this.e=e;
    }
    @Override
    public String toString() {
        return "Person{" +
                "height=" + s +
                ", weight=" + e +
                '}';
    }
}
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Room[] arr = new Room[n];

        for(int i=0;i<n;i++){
            arr[i]=new Room(in.nextInt(), in.nextInt());
        }
        Main main = new Main();
        System.out.println(main.solution(arr));
    }

    public int solution(Room[] arr){
        int answer=0;
        Arrays.sort(arr, (o1,o2)-> (o1.s==o2.s?o1.e-o2.e:o1.s-o2.s));
        for(Room r : arr){
            System.out.print("r.s = " + r.s);
            System.out.print("r.e = " + r.e);
            System.out.println();
        }
        int tmp=arr[0].e;
        for(int j=1;j<arr.length;j++){
            if(tmp<=arr[j].s) answer++;
            else tmp=arr[j].e;
        }

        return answer;
    }
}