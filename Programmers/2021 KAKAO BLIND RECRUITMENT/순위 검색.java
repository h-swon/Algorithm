import java.util.*;

class Solution {
    
    HashMap<String, ArrayList<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hm = new HashMap<>();
        
        for(String applicant : info){
            String[] s = applicant.split(" ");
            dfs(0, "", s);
        }

        for(String key : hm.keySet()){
            Collections.sort(hm.get(key));
        }
        
        for(int i=0; i<query.length; i++){
            String[] con = query[i].split(" and | ");
            String key = con[0] + con[1] + con[2] + con[3];
            int score = Integer.parseInt(con[4]);
            answer[i] = binarySearch(key, score);
        }
        return answer;
        
    }
    
    public int binarySearch(String key, int score){
        if(!hm.containsKey(key)) 
            return 0;
        
        ArrayList<Integer> list = hm.get(key);
        int left = 0;
        int right = list.size()-1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(list.get(mid) < score){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return list.size() - left;
    }
    
    public void dfs(int i, String comb, String[] applicant){
        if(i == applicant.length-1){
            if(!hm.containsKey(comb)){
                hm.put(comb, new ArrayList<>());
            }
            hm.get(comb).add(Integer.parseInt(applicant[4]));
            return;
        }
        
        dfs(i+1, comb + applicant[i], applicant);
        dfs(i+1, comb + "-", applicant);
    }
}