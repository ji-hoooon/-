package org.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn05_06 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Inflearn05_06 main = new Inflearn05_06();
        System.out.println(main.solution(n,m));
    }
    public int solution(int n, int m){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n;i++){
            q.offer(i);
        }
        int cnt=0;
        while(q.size()!=1){
            int tmp=q.poll();
            cnt++;
            if(cnt==m) {
                cnt=0;
            }else q.offer(tmp);
        }
        return q.poll();
    }
}
