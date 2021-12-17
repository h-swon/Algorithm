import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length ; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i] ){
                int j = stack.pop();
                prices[j] = i-j; 
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            prices[j] = prices.length-j-1;        
        }
        return prices;
    }
}