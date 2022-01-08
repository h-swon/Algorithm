import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int i=0; i<computers[node].length; i++){
            if(computers[node][i]==1)
                dfs(i,visited,computers);
        }
    }
}