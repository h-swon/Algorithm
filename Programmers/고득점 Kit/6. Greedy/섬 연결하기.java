import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        parents = new int[n];
        Arrays.sort(costs, (o1, o2)-> o1[2] - o2[2]);
        
        make(n);
        int cnt = 0;
        for(int[] node: costs){
            if(union(node[0],node[1])){
                answer += node[2];
                if(++cnt == n-1) break;
            }
        }
        return answer;
    }
    
    private void make(int n){
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
    }
    
    private int find(int n){
        if(n==parents[n])
            return n;
        return parents[n] = find(parents[n]);
    }
    
    private boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
    
        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}