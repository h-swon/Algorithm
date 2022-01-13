import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        List<Integer>[] graph = new ArrayList[n];
        Result[] result = new Result[n];
        int answer = 0;

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
            result[i] = new Result();
        }
        
        for(int i=0; i<results.length; i++){
            int winner = results[i][0]-1;
            int loser = results[i][1]-1;
            graph[winner].add(loser);
        }
        
        for(int i=0; i<n; i++){
            boolean[] visited= new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            
            queue.offer(i);
            visited[i] = true;
            while(!queue.isEmpty()){
                int winner = queue.poll();
                
                for(int loser : graph[winner]){
                    if(!visited[loser]){
                        visited[loser] = true;
                        result[i].win++;
                        result[loser].lose++;
                        queue.offer(loser);
                    }
                }
            }
        }
        
        for(Result r : result){
            if(r.win + r.lose == n-1){
                answer++;
            }
        }
        
        return answer;
    }
    
    class Result{
        int win;
        int lose;
    }
}