import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cacheList = new LinkedList<>();
        
        if(cacheSize == 0)
            return cities.length * 5;
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            if(cacheList.remove(city)) {
                cacheList.add(city);
                answer += 1;
            } else {
                if(cacheList.size() >= cacheSize) {
                    cacheList.remove(0);
                }
                cacheList.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}