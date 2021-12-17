import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2)->o2-o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String operation: operations){
            StringTokenizer st = new StringTokenizer(operation);
            
            switch(st.nextToken()){
                case "D":
                    if(maxPQ.isEmpty()) break;
                    
                    if(st.nextToken().equals("1")){
                        int max = maxPQ.poll();
                        minPQ.remove(max);
                    } else{
                        int min = minPQ.poll();
                        maxPQ.remove(min);
                    }
                    break;
                case "I":
                    int num = Integer.parseInt(st.nextToken());
                    maxPQ.offer(num);
                    minPQ.offer(num);
                    break;
            }
        }
        
        int[] answer = new int[2];
        
        if(!maxPQ.isEmpty()){
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        
        return answer;
    }
}