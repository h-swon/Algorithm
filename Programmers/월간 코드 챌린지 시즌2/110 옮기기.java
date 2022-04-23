import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        
        for(int i=0; i<s.length; i++) {
            List<Character> list = new ArrayList<>();
            int len = s[i].length();
            int cnt = 0;
            
            for(int j=0; j<len; j++) {
                
                list.add(s[i].charAt(j));
                int idx = list.size()-1;
                
                if(list.size()>=3 
                   && list.get(idx)=='0' 
                   && list.get(idx-1)=='1' 
                   && list.get(idx-2)=='1') {
                    cnt++;
                    list.remove(idx);
                    list.remove(idx-1);
                    list.remove(idx-2);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            int lastZeroIdx = -1;
            int listSize = list.size();
            for(int j=0; j<listSize; j++) {
                char c= list.get(j);
                sb.append(c);
                
                if(c=='0') {
                    lastZeroIdx = j;
                }
            }
            
            lastZeroIdx = (lastZeroIdx == -1 ? 0 : lastZeroIdx+1);
            
            while(cnt-- > 0) {
                sb.insert(lastZeroIdx, "110");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}