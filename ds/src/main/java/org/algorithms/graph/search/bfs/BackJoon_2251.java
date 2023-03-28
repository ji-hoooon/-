package org.algorithms.graph.search.bfs;

import org.io.FastReader;

import java.util.LinkedList;
import java.util.Queue;

//물통


public class BackJoon_2251 {
    static class State{
        int[] X;
        State(int[] X){
            this.X=new int[3];
            for(int i=0;i<3;i++){
                this.X[i]=X[i];
            }
        }
        State move(int from, int to){
            int[] nX=new int[]{X[0],X[1], X[2]};
            if(X[from]+X[to]>=Limit[to]){
                nX[from]-=Limit[to]-X[to];
                nX[to]=Limit[to];
            }else {
                nX[to]+=nX[from];
                nX[from]=0;
            }

            return new State(nX);
        }
    }
    static int[] Limit= new int[3];
    static boolean[][][] visited;
    static boolean[] possible;
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static void input(){
        visited=new boolean[205][205][205];
        possible=new boolean[205];

        for(int i=0;i<3;i++){
            Limit[i]=sc.nextInt();
        }
    }
    static void bfs(int x1, int x2, int x3){
        Queue<State> Q = new LinkedList<>();
        visited[x1][x2][x3]=true;

        Q.offer(new State(new int[] {x1,x2,x3}));
        while(!Q.isEmpty()) {
            State state=Q.poll();
            if(state.X[0]==0) possible[state.X[2]]=true;
            for(int from=0;from<3;from++){
                for(int to=0;to<3;to++) {
                    if(from==to) continue;
                    State tmp = state.move(from, to);

                    if(!visited[tmp.X[0]][tmp.X[1]][tmp.X[2]]) {
                        visited[tmp.X[0]][tmp.X[1]][tmp.X[2]]=true;
                        Q.offer(tmp);
                    }
                }
            }
        }
    }
    static void pro(){
        bfs(0,0,Limit[2]);
        for(int i=0;i<=Limit[2];i++)
            if(possible[i])sb.append(i).append(' ');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
