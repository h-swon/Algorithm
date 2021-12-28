import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int len = number.length();
        StringBuilder answer = new StringBuilder();
        int startIdx = 0;
        
        for(int i=0; i<len-k; i++){
            int maxValue = 0;
            for(int j=startIdx; j< k+i+1; j++){
                int compareValue = number.charAt(j)-'0';
                if(maxValue < compareValue){
                    maxValue = compareValue;
                    startIdx = j+1;
                }
            } 
            
            answer.append(maxValue);
        }
        return answer.toString();
    }
}

// Stack 활용
class Solution {
    public String solution(String number, int k) {
        
        int len = number.length();
        int deleteCount = k;
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<len; i++){
            int num = number.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek() < num && k>0){
                k--;
                stack.pop();
            }
            if(stack.size() < len-deleteCount)
                stack.push(num);
        }
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }
}