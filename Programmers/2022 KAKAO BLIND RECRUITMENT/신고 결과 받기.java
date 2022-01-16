import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> result = new HashMap<>();
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        
        for(String id: report){
            StringTokenizer st = new StringTokenizer(id);
            String userId = st.nextToken();
            String reportId = st.nextToken();
            
            if(!hm.containsKey(reportId)){
                hm.put(reportId, new HashSet<>());
            } 
            hm.get(reportId).add(userId);
        }
        for(String reportId : hm.keySet()){
            if(hm.get(reportId).size() >= k){
                for(String userId : hm.get(reportId)){
                    result.put(userId, result.getOrDefault(userId, 0) + 1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}