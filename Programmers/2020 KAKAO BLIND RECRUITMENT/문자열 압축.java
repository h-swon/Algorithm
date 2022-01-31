class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = s.length();
        
        for(int i=1; i<=len/2; i++){
            String sub = s.substring(0, i);
            String res = "";
            int count = 1;
            
            for(int j=i; j<len; j+=i){
                
                int end = (j+i > len)? len : j+i;
                String tmp = s.substring(j, end);
                
                if(sub.equals(tmp)){
                    count++;
                    continue;
                } 
                
                if(count > 1){
                    res += count + sub;
                    count = 1;
                } else{
                    res += sub;
                }
                sub = tmp;
            }
            
            if(count > 1){
                res += count + sub;
            } else{
                res += sub;
            }
            
            answer = Math.min(answer, res.length());
        }
        
        return answer;
    }
}