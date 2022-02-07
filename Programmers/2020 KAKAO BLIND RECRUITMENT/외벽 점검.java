import java.util.*;

class Solution {
    
    int answer;
    int N;
    
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        N = n;
        answer = 9;
        
        for(int i=0; i<weak.length; i++){
            check(1, i, 0, weak, dist);
        }
        return answer == 9 ? -1 : answer;
    }
    
    public void check(int cnt, int pos, int visited, int[] weak, int[] dist){
        if(cnt > dist.length)
            return;
        if(cnt >= answer)
            return;
        
        for(int i=0; i<weak.length; i++){
            int nextPos = (pos+i) % weak.length;
            int diff = weak[nextPos] - weak[pos];
            
            if(diff < 0)
                diff += N;
            
            if(diff > dist[dist.length - cnt])
                break;
            
            visited |= (1 << nextPos);
        }
        if(visited == (1 << weak.length)-1 ){
            answer = cnt;
        }
        
        for(int i=0; i<weak.length; i++){
            if((visited & (1<<i)) == 0){
                check(cnt+1, i, visited, weak, dist);
            }
        }
    }
}