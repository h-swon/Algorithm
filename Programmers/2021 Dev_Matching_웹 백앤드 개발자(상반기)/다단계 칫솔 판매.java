import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> nextSeller = new HashMap<>();
        HashMap<String, Integer> income = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<referral.length; i++) {
            nextSeller.put(enroll[i], referral[i]);
        }
        for(int i=0; i<amount.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;
            
            while(name != "-") {
                income.put(name, income.getOrDefault(name, 0) + money - (int)(money*0.1));
                money *= 0.1;
                name = nextSeller.get(name);
                if(money < 1) 
                    break;
            }
        }
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = income.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}