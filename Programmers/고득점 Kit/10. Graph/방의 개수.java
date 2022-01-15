import java.util.*;

class Solution {
    
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
        
        @Override
        public boolean equals(Object obj){
            return this.x == ((Pair)obj).x 
                && this.y == ((Pair)obj).y;
        }
    }
    
    public int solution(int[] arrows) {
        
        int answer = 0;
        HashMap<Pair, HashSet<Pair>> hm = new HashMap<>();
        Pair cur = new Pair(0,0); 
        hm.put(cur, new HashSet<>());
        
        for(int i=0; i<arrows.length; i++){
            for(int j=0; j<2; j++){
                Pair next = new Pair(cur.x + dx[arrows[i]], cur.y + dy[arrows[i]]);
                
                if(!hm.containsKey(next)){  // 방문한 적 없는 정점
                    hm.put(next, new HashSet<>());
                    hm.get(next).add(cur);  // 경로 add
                    hm.get(cur).add(next);  // 출발 정점에도 경로 add
                } else{                     // 방문한 적 있는 정점
                    if(!hm.get(next).contains(cur)){ // 처음 방문한 경로
                        hm.get(next).add(cur);
                        hm.get(cur).add(next);
                        answer ++;
                    }
                }
                cur = next;
            }     
        }
        return answer;
    }

}