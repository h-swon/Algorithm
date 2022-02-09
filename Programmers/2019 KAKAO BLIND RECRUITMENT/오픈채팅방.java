import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> hm = new HashMap<>();
        int cnt = 0;
        
        for(String info : record){
            String[] r = info.split(" ");
            String userId = r[1];
            
            switch(r[0]){
                case "Enter":
                    hm.put(userId, r[2]);
                    cnt++;
                    break;
                    
                case "Change":
                    hm.put(userId, r[2]);
                    break;
                    
                case "Leave":
                    cnt++;
                    break;
            }
        }
        
        String[] answer = new String[cnt];
        int i=0;
        
        for(String info : record){
            String[] r = info.split(" ");
            String nickname = hm.get(r[1]);
            
            if(r[0].equals("Enter")){
                answer[i++] = nickname + "님이 들어왔습니다.";    
            } else if(r[0].equals("Leave")){
                answer[i++] = nickname + "님이 나갔습니다.";    
            }
        }
       
        return answer;
    }
}