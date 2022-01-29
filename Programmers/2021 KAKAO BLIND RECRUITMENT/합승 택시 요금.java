// 플로이드-워셜 알고리즘
import java.util.*;

class Solution {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = 200 * 100000 + 1;
            }
            map[i][i] = 0;
        }
        
        for(int[] fare : fares){
            int r = fare[0] - 1;
            int c = fare[1] - 1;
            int cost = fare[2];
            
            map[r][c] = cost;
            map[c][r] = cost;
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(k == i)  continue;
                
                for(int j=0; j<n; j++){
                    if(i==j || k==j) continue;
                    
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            } 
        }
        
        for(int i=0; i<n; i++){
            answer = Math.min(answer, map[s-1][i] + map[i][a-1] + map[i][b-1]);
        }
        
        
        return answer;
    }
}

// 다익스트라 알고리즘
import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Edge>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares){
            graph.get(fare[0]-1).add(new Edge(fare[1]-1, fare[2]));
            graph.get(fare[1]-1).add(new Edge(fare[0]-1, fare[2]));
        }
        
        int[] costS = new int[n];
        int[] costA = new int[n];
        int[] costB = new int[n];
        
        dikjstra(s-1, costS);
        dikjstra(a-1, costA);        
        dikjstra(b-1, costB);
        
        for(int i=0; i<n; i++){
            answer = Math.min(answer, costS[i] + costA[i] + costB[i]);
        }
        
        return answer;
    }
 
    public int[] dikjstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        Arrays.fill(costs, 200 * 100000 + 1);
        costs[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.cost > costs[cur.node]) 
                continue;
            
            for(Edge next : graph.get(cur.node)){
                int newCost = costs[cur.node] + next.cost;
                
                if(newCost < costs[next.node]){
                    costs[next.node] = newCost;
                    pq.offer(new Edge(next.node, newCost));
                }
            }
        }
        return costs;
    }
    
    class Edge implements Comparable<Edge>{
        int node;
        int cost;
        
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
}