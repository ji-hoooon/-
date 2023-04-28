package org.algorithms.sortsearchandbinarysearch.binarysearch.binary_others;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_06_08 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int m= in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Inflearn_06_08 main= new Inflearn_06_08();
            System.out.println(main.solution(arr, n, m));
            System.out.println(main.solution2(arr, n, m));
        }
        public int solution(int[]arr, int n, int m){
            int answer=0;
            Arrays.sort(arr);
            int lt=0;
            int rt=arr.length-1;
            while(lt<=rt){
                int mid=(lt+rt)/2;
                if(arr[mid]==m){
                    answer=mid+1;
                    break;
                }
                if(arr[mid]<m){
                    lt=mid+1;
                }else{
                    rt=mid-1;
                }
            }
            return answer;
        }

        public int solution2(int[]arr, int n, int m){
            int answer=0;
            Arrays.sort(arr);
            int lt=0;
            int rt=Arrays.stream(arr).max().getAsInt();
            //System.out.println(lt+" "+rt);
            int mid=0;
            while(lt<=rt){
                mid=(lt+rt)/2;
                if(check(n, m,arr, mid)){
                    answer=mid;
                    lt=mid+1;
                }else{
                    rt=mid-1;
                }
            }
            return answer;
        }
        private static boolean check(int n, int m,int[]arr, int mid){
            int sum=0;
            for(int i=0;i<n;i++){
                if(arr[i]>mid){
                    sum+=mid;
                }else{
                    sum+=arr[i];
                }

                //System.out.println(mid+" "+i+" "+arr[i]+" "+sum+" "+k);
                if(sum>m) return false;
            }
            return true;
        }
    }

