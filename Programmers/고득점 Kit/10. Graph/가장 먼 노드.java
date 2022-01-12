import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            answer = queue.size();
            int size = answer;
            while(size-- > 0){
                int num = queue.poll();
                for(int node : graph[num]){
                    if(!visited[node]){
                        visited[node] = true;
                        queue.offer(node);
                    }        
                }
                
            }
        }
        
        return answer;
    }
}