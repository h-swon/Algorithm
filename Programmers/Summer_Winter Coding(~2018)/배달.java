import java.util.*;

class Solution {
    
    class Node implements Comparable<Node>{
        int num;
        int cost;
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    int[] dist;
    int answer = 0;
    
    public int solution(int N, int[][] road, int K) {
        
        dist = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int[] info : road) {
            graph.get(info[0]).add(new Node(info[1], info[2]));
            graph.get(info[1]).add(new Node(info[0], info[2]));
        }
        dijkstra();
        
        for(int cost : dist) {
            if(cost <= K) {
                answer++;
            }
        }
        
        
        return answer;
    }    
    
    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.num]) {
                continue;
            }
            
            for(Node next : graph.get(cur.num)) {
                if(cur.cost + next.cost < dist[next.num]) {
                    dist[next.num] = cur.cost + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
        
    }
}