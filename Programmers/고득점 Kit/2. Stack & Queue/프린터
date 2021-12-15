import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        
        for(int priority: priorities){
            pq.offer(priority);
        }
        
        int order=1;
        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(pq.peek()==priorities[i]){
                    if(location==i){
                        return order;
                    }
                    order++;
                    pq.poll();
                }
            }
        }
        return -1;
    }
    
    class Task{
        int priority;
        int location;
        
        public Task(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
}