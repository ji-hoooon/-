package org.algorithms.strategy.greedyandknapsack;

import java.util.*;

public class Inflearn09_03_Hard {
    static class Wedding{
        int in;
        int out;
        Wedding(int in, int out){
            this.in=in;
            this.out=out;
        }

    }


        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            Wedding[] arr= new Wedding[n];
            ArrayList<Wedding2> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                int s=in.nextInt();
                int e=in.nextInt();
                arr[i]=new Wedding(s,e);
                list.add(new Wedding2('s', s));
                list.add(new Wedding2('e', e));
            }
            Inflearn09_03_Hard main = new Inflearn09_03_Hard();
            System.out.println(main.solution(arr));
            System.out.println(main.solution2(list));
        }

        public int solution(Wedding[] arr){
            int answer=0;
            int result=0;
            Arrays.sort(arr, (o1, o2) -> (o1.in==o2.in)?o1.out-o2.out:o1.in-o2.in);
            PriorityQueue<Wedding> pq = new PriorityQueue<>((o1, o2) -> (o1.out-o2.out));
//            for(Wedding w : arr){
//                System.out.print("w.in = " + w.in+" "+w.out);
//                System.out.println();
//            }

            //5, 14
            //12, 15
            //14, 18
            //15, 20
            //20, 30
//            for(Wedding w : arr){
//                pq.offer(w);
////                System.out.println("offer :" + w.in+" "+w.out);
//                while(!pq.isEmpty()){
//                    if(pq.peek().out<=w.in){
//                        Wedding w2=pq.poll();
////                        System.out.println("poll : "+w2.in+" "+w2.out);
//                    }else break;
//                }
//                result = Math.max(pq.size(),result);
//            }
            for(Wedding w : arr){
                pq.offer(w);
                while(pq.poll().out<=w.in){
                    pq.poll();
                }
                result = Math.max(pq.size(),result);
            }
            return result;
        }

    static class Wedding2{
        char x;
        int y;
        Wedding2(char x, int y){
            this.x=x;
            this.y=y;
        }
    }


        public int solution2(ArrayList<Wedding2> arr){
            int answer=0;
            Collections.sort(arr, (o1, o2) -> (o1.y==o2.y)?o1.x-o2.x:o1.y-o2.y);

            int cnt=0;
            for(Wedding2 w : arr){
                if(w.x=='s') cnt++;
                else cnt--;
                answer=Math.max(cnt,answer);
            }

            return answer;
        }
    }


