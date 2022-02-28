import java.util.*;

class Solution {
    
    String[] regex;
    HashSet<Integer> hs;
    
    public int solution(String[] user_id, String[] banned_id) {
        regex = new String[banned_id.length];
        hs = new HashSet<>();
        
        for(int i=0; i<banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*",".");
        }
        
        dfs(0, 0, user_id);
        
        return hs.size();
    }
    
    public void dfs(int idx, int bit, String[] user_id) {
        if(idx == regex.length) {
            hs.add(bit);
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(((bit>>i) & 1) != 1 && user_id[i].matches(regex[idx])) {
                dfs(idx+1, bit | (1<<i), user_id);
            }
        }
    }
    
}