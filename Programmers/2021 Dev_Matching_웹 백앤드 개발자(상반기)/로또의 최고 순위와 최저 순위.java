import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int maxCnt = 0;
        int minCnt = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num : win_nums) {
            hs.add(num);
        }
        
        for(int num : lottos) {
            if(num == 0) {
                maxCnt++;
            } else if(hs.contains(num)) {
                maxCnt++;
                minCnt++;
            }
        }
        answer[0] = getRank(maxCnt);
        answer[1] = getRank(minCnt);
        return answer;
    }
    
    public int getRank(int cnt) {
        switch(cnt) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;            
        }
    } 
}