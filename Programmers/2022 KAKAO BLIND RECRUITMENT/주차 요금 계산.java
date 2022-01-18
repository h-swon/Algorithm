import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, String> hm = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNumber = st.nextToken();
            String state = st.nextToken();
            
            if(state.equals("IN")){
                hm.put(carNumber, time);
            } else{ // OUT
                int parkTime = getTime(fees, hm.get(carNumber), time);
                result.put(carNumber, result.getOrDefault(carNumber, 0) + parkTime);
                hm.remove(carNumber);
            }
        }
        
        for(String carNumber : hm.keySet()){
            int parkTime = getTime(fees, hm.get(carNumber), "23:59");
            result.put(carNumber, result.getOrDefault(carNumber, 0) + parkTime);
        }

        int[] answer = new int[result.size()];
        int i = 0;
        for(int time : result.values()){
            answer[i++] = getFee(fees, time);
        }

        return answer;
    }
    
    public int getTime(int[] fees, String inTime, String outTime){
        StringTokenizer st = new StringTokenizer(inTime, ":");
        int enter = Integer.parseInt(st.nextToken())*60 + 
            Integer.parseInt(st.nextToken());
        st = new StringTokenizer(outTime, ":");
        int out = Integer.parseInt(st.nextToken())*60 + 
            Integer.parseInt(st.nextToken());
        
        int time = out - enter;
        return time;
    }
    
    public int getFee(int[] fees, int time){
        if(fees[0] >= time){
            return fees[1];
        } else{
            int extratime = time-fees[0];
            return fees[1] + (int)(Math.ceil((double)extratime / fees[2])) * fees[3]; 
        }
    }
}