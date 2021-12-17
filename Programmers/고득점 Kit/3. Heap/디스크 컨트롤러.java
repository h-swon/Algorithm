import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        int answer = 0;
        int endTime = 0;
        int i = 0;          // 인덱스
        int cnt = 0;        // 작업 완료한 개수
        
        while(cnt < jobs.length){
            
            while(i < jobs.length && jobs[i][0] <= endTime){
                pq.offer(jobs[i++]);
            }
            if(pq.isEmpty()){
                endTime = jobs[i][0];
            } else{
                int[] job = pq.poll();
                answer += (endTime - job[0] + job[1]);
                endTime += job[1];
                cnt++;
            }
        }
        
        return answer / jobs.length;
    }
}