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
        rec_func(1);
        System.out.println(sb);
    }
    static void rec_func(int k){
        if(k==M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=1;i<=N;i++){
                selected[k]=i;
                rec_func(k+1);
                selected[k]=0;
            }
        }
    }
}