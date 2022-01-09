import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    boolean[] visited;
   
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        String[] answer = {};
        
        dfs(0 ,"ICN", "ICN", tickets);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }
    
    public void dfs(int cnt,String begin,String route, String[][] tickets){
        if(cnt == tickets.length){
            list.add(route);
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(begin)){
                visited[i] = true;
                dfs(cnt+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
             }
        }
    }
    
    
}