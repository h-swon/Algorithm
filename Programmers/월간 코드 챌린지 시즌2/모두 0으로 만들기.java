import java.util.*;

class Solution {
    
    boolean[] visited;
    List<Integer>[] vertex;
    long[] weight;
    long answer;
    
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        answer = 0;
        vertex = new ArrayList[a.length];
        visited = new boolean[a.length];
        weight = new long[a.length];
        
        for(int i=0; i<a.length; i++) {
            sum += a[i];
            weight[i] = a[i];
            vertex[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edges.length; i++) {
            vertex[edges[i][0]].add(edges[i][1]);
            vertex[edges[i][1]].add(edges[i][0]);
        }
        
        if(sum != 0) 
            return -1;
        
        dfs(0);
        
        return answer;
    }
    
    public long dfs(int v) {
        
        visited[v] = true;
        for(int i=0; i<vertex[v].size(); i++) {
            int next = vertex[v].get(i);
            if(!visited[next]) {
                weight[v] += dfs(next);
            }
        }
        answer += Math.abs(weight[v]);
        return weight[v];
    }
}