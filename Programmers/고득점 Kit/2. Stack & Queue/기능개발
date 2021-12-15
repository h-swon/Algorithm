import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int len = progresses.length;
        
        for(int i=0;i<len;i++){
           queue.offer((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
        
        ArrayList<Integer> tmp = new ArrayList<>();
        while(!queue.isEmpty()){
            int workingTime = queue.poll();
            int cnt=1;
            while(queue.peek()!=null && queue.peek()<=workingTime){
               queue.poll();
               cnt++;
            }
            tmp.add(cnt);
        }
        int[] answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    
    }   
}