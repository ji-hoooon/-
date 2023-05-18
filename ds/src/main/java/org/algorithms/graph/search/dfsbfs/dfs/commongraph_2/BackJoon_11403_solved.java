package org.algorithms.graph.search.dfsbfs.dfs.commongraph_2;
import org.io.FastReader;

//경로 찾기
public class BackJoon_11403_solved {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] adj;

    static boolean[][] visited;
    static void input(){
        N= scan.nextInt();
        adj= new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                adj[i][j]= scan.nextInt();
            }
        }
    }
    static void pro(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(adj[i][j]==1) dfs(i,j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int k=0;k<N; k++){
            if(adj[y][k]==0) continue;
            if(visited[x][k]) continue;

            adj[x][k]=1;
            dfs(x,k);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
