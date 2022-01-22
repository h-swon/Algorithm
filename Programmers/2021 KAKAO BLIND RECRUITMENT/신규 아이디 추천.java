import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        // 1단계
        answer = answer.toLowerCase();
        
        // 2단계
        String tmp = "";
        for(char c : answer.toCharArray()){
            if((c >= 'a' && c<='z') || (c >= '0' && c<= '9') || c=='-' || c=='_' || c=='.'){
                tmp += c;
            }  
        }
        answer = tmp;
        
        // 3단계
        while(answer.contains("..")){
            answer = answer.replace("..", "."); 
        }
        // 4단계
        if(answer.length() > 0 && answer.charAt(0)=='.'){
            answer = answer.substring(1, answer.length());
        }
        if(answer.length() > 0 && answer.charAt(answer.length() - 1)=='.'){
            answer = answer.substring(0, answer.length()-1);
        }
        
        // 5단계
        if(answer.length() == 0){
            answer = "a";
        }
        
        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0,14);
            }
        }
        
        // 7단계
        if(answer.length() <= 2){
            char last = answer.charAt(answer.length() - 1);
            while(answer.length() < 3){
                answer += last;
            }
        }
        return answer;
    }
}