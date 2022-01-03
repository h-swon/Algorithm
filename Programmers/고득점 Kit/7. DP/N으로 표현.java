import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        int answer = 0;
        HashSet<Integer>[] dp = new HashSet[9];
        
        int num = N;
        
        for(int i=1; i<9; i++){
            dp[i] = new HashSet<>();
            dp[i].add(num);
            num = 10 * num + N;
        }
        
        if(number == N) 
            return 1;
        
        for(int i=2; i<9; i++){
            for(int j=1; j<i; j++){
                Iterator<Integer> firstIt = dp[i-j].iterator();
                Iterator<Integer> secondIt = dp[j].iterator();
                
                while(firstIt.hasNext()){
                    int firstNum = firstIt.next();
                    
                    while(secondIt.hasNext()){
                        int secondNum = secondIt.next();
                        dp[i].add(firstNum + secondNum);
                        dp[i].add(firstNum - secondNum);
                        dp[i].add(firstNum * secondNum);
                        if(secondNum!=0){
                            dp[i].add(firstNum / secondNum);
                        }
                    }
                    secondIt = dp[j].iterator();
                }
            }
            if(dp[i].contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}