import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable) {
            String[] times = time.split(":");
            int minutes = Integer.parseInt(times[0]) * 60 
                + Integer.parseInt(times[1]);
            pq.offer(minutes);
        }
        
        int departureTime = 60 * 9;
        int lastArriveTime = 0;
        int total = 0;
        
        for(int i=0; i<n; i++) {
            total = 0;
            while(!pq.isEmpty()) {
                int currentWaitingTime = pq.peek();
                if(currentWaitingTime <= departureTime && total < m) {
                    pq.poll();
                    total++;
                } else {
                    break;
                }
                
                lastArriveTime = currentWaitingTime - 1;
            }
            departureTime += t;
        }
        
        if(m > total) {
            lastArriveTime = departureTime - t;    
        }
        answer = String.format("%02d:%02d", lastArriveTime/60, lastArriveTime%60);
        return answer;
    }
}