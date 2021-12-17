import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] element : clothes){
            hm.put(element[1], hm.getOrDefault(element[1],0)+1);
        }
        
        int answer = 1;
        for(int count: hm.values()){
            answer *= (count+1);
        }
        return answer-1;
    }
}