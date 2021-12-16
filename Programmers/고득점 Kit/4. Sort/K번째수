import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            int[] tmpArr = 
                Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); 
            Arrays.sort(tmpArr);
            answer[i] = tmpArr[commands[i][2]-1];
        }
        return answer;
    }
}