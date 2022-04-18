import java.util.*;

class Solution {
    public int solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int len = s.length();
        
        for(int i=0; i<len; i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            boolean correct = true;
            
            for(int j=0; j<len; j++) {
                char c = tmp.charAt(j);
                if(c=='[' || c=='{' || c=='(') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        correct = false;
                        break;
                    }
                    
                    char p = stack.pop();
                    if(!((p=='[' && c==']') || (p=='{' && c=='}') || (p=='(' && c==')'))) {
                        correct = false;
                        break;
                    }
                }
            }
            if(correct && stack.isEmpty()) answer++;
            stack.clear();
        }
        
        return answer;
    }
}