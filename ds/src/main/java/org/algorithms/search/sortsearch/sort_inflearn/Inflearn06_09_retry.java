package org.algorithms.search.sortsearch.sort_inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn06_09_retry {
        static int m;
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            m = in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Inflearn06_09_retry main = new Inflearn06_09_retry();
            System.out.println(main.solution(arr));
        }
//  9 3
//  1 2 3 4 5 6 7 8 9
        public boolean check(int mid, int[] arr){
            int cnt=1;
            int sum=0;
            for(int i=0;i<arr.length;i++){

                if(sum+arr[i]>mid) {
                    sum=arr[i];
                    cnt++;
                }else{
                    sum+=arr[i];
                }
                if(cnt>m) return false;
            }
            return true;
        }
        public int solution(int[] arr){
            int answer=0;
            int lt = Arrays.stream(arr).max().getAsInt();
            int rt = Arrays.stream(arr).sum();

            while(lt<=rt){
                int mid= (lt+rt)/2;

                if(check(mid, arr)) {
                    answer= mid;
                    rt=mid-1;
                }
                else{
                    lt=mid+1;

                }

            }

            return answer;
        }
    }