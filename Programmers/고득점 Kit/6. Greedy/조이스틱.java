import java.util.*;

class Solution {
    public int solution(String name) {
        
        int len = name.length();
        int answer = 0;
        int min = len-1;
        
        for(int i=0; i<len; i++){
            // 상하 이동
            char c = name.charAt(i);
            answer += Math.min(c-'A', 'Z'-c+1);
            
            // 좌우 이동
            int next = i+1;
            while(next<len && name.charAt(next)=='A'){
                next++;
            }
            min = Math.min(min, i*2 + len - next);
        }
        answer += min;
        return answer;
    }
}