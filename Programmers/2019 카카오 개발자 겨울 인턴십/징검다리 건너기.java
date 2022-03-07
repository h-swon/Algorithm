class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = 200_000_000;
        
        while(min <= max) {
            int mid = (min+max) / 2;
            if(canAcross(mid, k, stones)) {
                answer = mid;
                min = mid + 1;    
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    
    public boolean canAcross(int num, int k, int[] stones) {
        int cnt = 0;
            
        for(int stone : stones) {
            if(stone < num) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if(cnt == k) {
                return false;
            }
        }
        
        return true;
    }
}