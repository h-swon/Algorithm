import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int value: scoville){
            pq.offer(value);
        }
        while(pq.peek()<K){
            if(pq.size() == 1){
                answer=-1;
                break;
            }
            pq.offer(pq.poll() + pq.poll()*2);
            answer++;
        }
        
        return answer;
    }
}