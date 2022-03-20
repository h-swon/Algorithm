import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> hs = new HashSet<>();
        int[] answer = new int[2];

        hs.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            char end = words[i-1].charAt(words[i-1].length()-1);
            if(words[i].charAt(0) != end || hs.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            hs.add(words[i]);
        }
      
        return answer;
    }
}