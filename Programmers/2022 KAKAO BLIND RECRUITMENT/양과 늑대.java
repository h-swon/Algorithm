import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    int answer;
    public int solution(int[] info, int[][] edges) {
        
        graph = new ArrayList[info.length];
        
        for(int i=0; i<info.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        dfs(0, 0, 0, list, info);
        return answer;
    }
    
    public void dfs(int sheep, int wolf, int num, List<Integer> list, int[] info){
        
        if(info[num] == 0){   // 양
            sheep += 1;
        } else {            // 늑대
            wolf += 1;
        }
        
        if(sheep <= wolf) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        List<Integer> childList = new ArrayList<>();
        childList.addAll(list);
        childList.addAll(graph[num]);
        childList.remove(Integer.valueOf(num));
        
        for(int child : childList){
            dfs(sheep, wolf, child, childList, info);
        }
    }
}