import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int value = numbers[i] + numbers[j];
                hs.add(value);
            }
        }
        int[] answer = new int[hs.size()];
        int i=0;
        for(int num : hs) {
            answer[i++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}