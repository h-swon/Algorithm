import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n = n / k;
        }
        
        String numK = sb.reverse().toString();
        StringTokenizer st = new StringTokenizer(numK, "0");
        
        while(st.hasMoreTokens()){
            long num = Long.parseLong(st.nextToken());
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num<2) 
            return false;
        for(long i=2; i*i<=num; i++){
            if(num % i ==0)
                return false;
        }
        return true;
    }
}