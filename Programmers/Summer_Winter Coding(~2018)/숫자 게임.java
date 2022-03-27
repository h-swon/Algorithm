import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        
        for(int num : B) {
            if(num > A[aIdx]){
                aIdx++;
                answer++;
            }
        }
        return answer;
    }
}