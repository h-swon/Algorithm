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