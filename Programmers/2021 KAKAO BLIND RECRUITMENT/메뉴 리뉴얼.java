import java.util.*;

class Solution {
    
    HashMap<String, Integer> hm;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        
        for(int num : course){
            hm = new HashMap<>();
            max = 0;
            
            for(String order : orders){
                comb(0, 0, num, order, "");
            }
            
            for(String key : hm.keySet()){
                if(max>1 && (max==hm.get(key))){
                    result.add(key);
                }
            }
        }

        Collections.sort(result);
        answer = result.toArray(new String[result.size()]);
        return answer;
    }
    
    public void comb(int cnt, int idx, int num, String order, String menu){
        if(cnt == num) {
            char[] tmp = menu.toCharArray();
            Arrays.sort(tmp);
            menu = String.valueOf(tmp);
            
            hm.put(menu, hm.getOrDefault(menu, 0) + 1);
            max = Math.max(max, hm.get(menu));
            return;
        }

        for(int i=idx; i<order.length(); i++){
            comb(cnt+1, i+1, num, order, menu+order.charAt(i));
        }
    }
}