// 1번째 방법
import java.util.*;

class Solution {
    
    HashSet<String> res = new HashSet<>();
    
    public int solution(String[][] relation) {
        
        int col = relation[0].length;
        for(int d=1; d<=col; d++){
            dfs(0, 0, d, new HashSet<Integer>(), relation);
        }
        int answer = res.size();
        return answer;
    }
    
    public void dfs(int depth, int start, int end, HashSet<Integer> key, String[][] relation){
        
        if(depth == end){
            
            HashSet<String> hs = new HashSet<>();
            String tmpKey="";
            for(int k : key){
                tmpKey += k;
            }
            
            for(int i=0; i<relation.length; i++){
                String s="";
                for(int k : key){
                    s += relation[i][k];
                }
                if(hs.contains(s)){
                    return;
                }
                hs.add(s);
            }
            
            for(String k : res){
                int count = 0;
                for(int i=0; i<k.length(); i++){
                    if(tmpKey.contains(k.charAt(i)+"")){
                        count++;
                    }
                }
                if(count==k.length()){
                    return;
                }
            }
            
            res.add(tmpKey);
            return;
        }
        
        for(int i=start; i<relation[0].length; i++){
            key.add(i);
            dfs(depth+1, i+1, end, key, relation);
            key.remove(i);
        }
    }
}


// 2번째 방법
import java.util.*;

class Solution {
    
    ArrayList<HashSet<Integer>> res = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        int col = relation[0].length;
        for(int d=1; d<=col; d++){
            dfs(0, 0, d, new HashSet<Integer>(), relation);
        }
        int answer = res.size();
        return answer;
    }
    
    public void dfs(int depth, int start, int end, HashSet<Integer> key, String[][] relation){
        
        if(depth == end){
            HashSet<String> hs = new HashSet<>();
            for(HashSet<Integer> r: res){
                if(key.containsAll(r)){
                    return;
                }
            }
            
            for(int i=0; i<relation.length; i++){
                String s="";
                for(int k : key){
                    s += relation[i][k];
                }
                if(hs.contains(s)){
                    return;
                }
                hs.add(s);
            }
            
            res.add(key);
            return;
        }
        
        for(int i=start; i<relation[0].length; i++){
            HashSet<Integer> newKey = new HashSet<>(key);
            newKey.add(i);
            dfs(depth+1, i+1, end, newKey, relation);
        }
    }
}