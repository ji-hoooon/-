package org.algorithms.search.bruteforce.bruteforce_base;
import org.io.FastReader;

//N과 M (1) - 중복 없이, 순서 존재
//: 순열
public class BackJoon_15651_solved {
    static int N, M;
    static int[] selected;
    static StringBuilder sb= new StringBuilder();

    static void input(){
        //N개중에 M개를 중복 없이, 순서를 생각하며 뽑는다.
        //: 순서가 다르면 다른것
        FastReader scan = new FastReader();
        N=scan.nextInt();
        M=scan.nextInt();
        selected=new int[M+1];
    }
    public static void main(String[] args){
        input();
        //1개부터 M개를 고르기 시작한다.
        rec_func(1);
        System.out.println(sb);
    }
    static void rec_func(int k){
        //M개가 되었다.
        if(k==M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        //M개가 아직 안됨
        }else{
            //i=1부터 N까지 고른다.
            //K번째에 고른 숫자를 넣는다. -> M개를 고를때까지
            for(int i=1;i<=N;i++){
                selected[k]=i;
                rec_func(k+1);
                //그리고 고른 숫자를 초기화 해야 다음에 더 고를 수 있다.
                selected[k]=0;
            }
        }
    }
}