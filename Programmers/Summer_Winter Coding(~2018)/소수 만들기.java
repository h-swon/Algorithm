class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        dfs(0, 0, 0, nums);
        return answer;
    }
    
    public void dfs(int cnt, int idx, int sum, int[] nums) {
        if(cnt==3) {
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }
        for(int i=idx; i<nums.length; i++) {
            dfs(cnt+1, i+1, sum+nums[i], nums);
        }
    }
    
    public boolean isPrime(int num) {
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}