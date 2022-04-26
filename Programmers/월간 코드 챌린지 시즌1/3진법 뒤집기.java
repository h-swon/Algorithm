class Solution {
    public int solution(int n) {
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            sb.append(n%3);
            n /= 3;
        }
        
        answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}