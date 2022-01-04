class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0,0,target,numbers);
        return answer;
    }
    
    public void dfs(int cnt, int sum, int target, int[] numbers){
        if(cnt == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(cnt+1, sum+numbers[cnt], target, numbers);
        dfs(cnt+1, sum-numbers[cnt], target, numbers);
    }
}