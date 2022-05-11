import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int len1 = str1.length();
        int len2 = str2.length();
        int total = 0;
        
        for(int i=0; i<len1-1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            if(!isCharacter(a) || !isCharacter(b))
               continue;
            String str = Character.toString(a) + Character.toString(b);
            hm1.put(str, hm1.getOrDefault(str, 0) + 1);
            total++;
        }
        for(int i=0; i<len2-1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            if(!isCharacter(a) || !isCharacter(b)) 
               continue;
            String str = Character.toString(a) + Character.toString(b);
            hm2.put(str, hm2.getOrDefault(str, 0) + 1);
            total++;
        }
        
        int unionCnt = 0;
        int interCnt = 0;
        
        for(String key : hm1.keySet()) {
            if(hm2.containsKey(key)) {
                interCnt += Math.min(hm1.get(key), hm2.get(key));
            }
        }
        unionCnt = total - interCnt;
        double answer = (double)interCnt / unionCnt;
        if(unionCnt == 0)
            answer = 1;
        return (int)(answer * 65536);
    }
    
    public boolean isCharacter(char ch) {
        return ch >= 'A' && ch<='Z';
    }
}