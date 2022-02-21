import java.util.*;

class Solution {
    
    char[] opArr = new char[]{'+','-','*'};
    List<Long> numList = new LinkedList<>();
    List<Character> opList = new LinkedList<>();
    boolean[] visited = new boolean[3];
    long answer = 0;
    
    public long solution(String expression) {
        
        String number = "";
        for(char c : expression.toCharArray()) {
            if(c >= '0' && c<='9') {
                number += c;
            } else {
                numList.add(Long.parseLong(number));
                opList.add(c);
                number = "";
            }
        }
        numList.add(Long.parseLong(number));
        dfs(0, new char[3]);
        
        return answer;
    }
    
    public void dfs(int cnt, char[] op) {
        if(cnt == 3) {
            List<Long> tmpNumList = new ArrayList<>(numList);
            List<Character> tmpOpList = new ArrayList<>(opList);
            for(int i=0; i<op.length; i++) {
                for(int j=0; j<tmpOpList.size(); j++) {
                    if(op[i] == tmpOpList.get(j)) {
                        long tmp = cal(tmpNumList.remove(j), tmpNumList.remove(j), op[i]);
                        tmpNumList.add(j, tmp);
                        tmpOpList.remove(j--);
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tmpNumList.get(0)));
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                op[cnt] = opArr[i];
                dfs(cnt+1, op);
                visited[i] = false;
            }
        }
    }
    
    public long cal(long num1, long num2, char op) {
        long res = 0;
        switch(op) {
            case '+': 
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
        }
        return res;
    }
}