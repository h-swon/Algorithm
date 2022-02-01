import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    public String convert(String p){
        if(p.length()==0){
            return "";
        }
        int cnt1 = 0;
        int cnt2 = 0;
        String u = "";
        String v = "";
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(') cnt1 ++;
            else cnt2 ++;
            if(cnt1 == cnt2){
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }
        }
        if(isBalance(u)) {
            u += convert(v);    
        } else {
            String tmp = "("+convert(v)+")";
            u = tmp + reverse(u);
        }
        return u;
    }
    
    public boolean isBalance(String p){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<p.length(); i++){
            if(!stack.isEmpty() && p.charAt(i) ==')'){
                stack.pop();
            } else{
                stack.push('(');
            }
        }
        if(stack.size() > 0) 
            return false;
        return true;
    }
    
    public String reverse(String p){
        String tmp = "";
        for(int i=1; i<p.length()-1; i++){
            if(p.charAt(i)=='(')
                tmp += ')';
            else 
                tmp += '(';
        }
        return tmp;
    }
}