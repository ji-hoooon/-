package org.algorithms.search.sortsearch.sort_inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn06_10_retry {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[]= new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Inflearn06_10_retry main = new Inflearn06_10_retry();
            System.out.println(main.solution(n,m,arr));
        }
        public int solution(int n,int m, int[] arr){
            int answer=0;
            Arrays.sort(arr);
            int tmp=arr[0];
            int lt=1;
            int rt=arr[n-1];
            while(lt<=rt){
                int mid=(lt+rt)/2;
                if(check(arr, n, m , mid, tmp)){
                    answer=mid;
                    lt=mid+1;
                }else
                    rt=mid-1;

            }

            return answer;
        }
        public boolean check(int[] arr, int n,int m, int mid, int tmp){
            int cnt=1;
            for(int i=1;i<n;i++){
                if(arr[i]-tmp>=mid){
                    cnt++;
                    tmp=arr[i];
                    if(cnt==m) return true;
                }
            }
            return false;
        }
    }
