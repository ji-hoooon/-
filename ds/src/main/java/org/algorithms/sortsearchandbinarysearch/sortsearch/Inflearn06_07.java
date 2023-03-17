package org.algorithms.sortsearchandbinarysearch.sortsearch;

import java.util.PriorityQueue;
import java.util.Scanner;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Inflearn06_07 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> (o1.x==o2.x?o1.y-o2.y:o1.x-o2.x));
        for(int i=0;i<n;i++){
            pq.offer(new Point(in.nextInt(), in.nextInt()));
        }
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            System.out.println(p.x+" "+p.y);
        }
    }
}
