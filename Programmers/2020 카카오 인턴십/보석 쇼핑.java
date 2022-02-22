import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String gem : gems) {
            if(!hs.contains(gem)) {
                hs.add(gem);
            } 
        }
        int start = 0;
        int end = 0;
        int dist = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(true) {
            if(hm.size() == hs.size()) {
                hm.put(gems[start], hm.get(gems[start])-1);
                if(hm.get(gems[start]) == 0) {
                    hm.remove(gems[start]);
                }
                start++;     
                
            } else if(end == gems.length) {
                break;
            } else {
                hm.put(gems[end], hm.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            
            if(hm.size() == hs.size()) {
                if(end - start < dist) {
                    dist = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                } 
            }
        }
        
        return answer;
    }
}