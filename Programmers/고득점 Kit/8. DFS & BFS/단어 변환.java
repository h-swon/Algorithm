// DFS
class Solution {
    
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(int cnt, String begin, String target, String[] words){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i=0; i<words.length; i++){
            if(canConvert(begin, words[i]) && !visited[i]){
                visited[i] = true;
                dfs(cnt+1, words[i], target, words);
                visited[i] = false;
            }
        }
    
    }
    
    public boolean canConvert(String word1, String word2){
        int len = word1.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt++;
            }
        }
        if(cnt>1)
            return false;
        
        return true;
    }
}

// BFS
import java.util.*;
class Node{
    String word;
    int move;
    
    Node(String word, int move){
        this.word = word;
        this.move = move;
    }
}
class Solution {    
    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        int answer = 0;
        
        queue.offer(new Node(begin, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.word.equals(target)){
                answer = node.move;
                break;
            }
            for(int i=0; i<words.length; i++){
                if(!visited[i] && canConvert(node.word, words[i])){
                    visited[i] = true;
                    queue.offer(new Node(words[i], node.move + 1));
                }
            }
        }
        
        return answer;
    }
    
    public boolean canConvert(String word1, String word2){
        int len = word1.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt++;
            }
        }
        if(cnt>1)
            return false;
        
        return true;
    }
}