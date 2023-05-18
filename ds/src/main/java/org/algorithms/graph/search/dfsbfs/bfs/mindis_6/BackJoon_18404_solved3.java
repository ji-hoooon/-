package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;
import java.util.*;
//현명한 나이트
public class BackJoon_18404_solved3 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] start;
    static ArrayList<int[]> end;
    static int[][] dis;
    static boolean[][] visited;
    //    (X-2,Y-1), (X-2,Y+1), (X-1,Y-2), (X-1,Y+2), (X+1,Y-2), (X+1,Y+2), (X+2,Y-1), (X+2,Y+1)
    static int[][] dir = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    static void bfs(int[] start){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(start);
        visited[start[0]][start[1]]=true;
        dis[start[0]][start[1]]=0;

        while(!Q.isEmpty()){
            int[] tmp = Q.poll();

            for(int k=0;k<8;k++) {
                int nx = tmp[0] + dir[k][0];
                int ny = tmp[1] + dir[k][1];
                if (nx < 1 || ny < 1 || nx >N || ny > N) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dis[nx][ny] = dis[tmp[0]][tmp[1]] + 1;
                Q.offer(new int[]{nx,ny});
            }
        }

    }
    static void input(){
        Scanner scan= new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        int x=scan.nextInt();
        int y=scan.nextInt();
        end=new ArrayList<>();
        start=new int[]{x,y};
        visited=new boolean[N+1][N+1];
        dis=new int[N+1][N+1];
        for(int i=0;i<M;i++){
            x=scan.nextInt();
            y=scan.nextInt();
            end.add(new int[]{x,y});
        }
    }
    static void pro(){

        bfs(start);
        for(int i=0;i<M;i++)
            sb.append(dis[end.get(i)[0]][end.get(i)[1]]+" ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}