class Solution {
    
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int n = arr.length;
        dfs(arr, 0, 0, n);
        return answer;
    }
    
    public void dfs(int[][] arr, int r, int c, int n) {
        int num = arr[r][c];
        boolean canCompress = true;
        
        if(n==1) {
            answer[num] ++;
            return;
        }
        
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(num != arr[i][j]) {
                    canCompress = false;
                }
            }
            if(!canCompress) break;
        }
       
        
        if(canCompress) {
            answer[num]++;
        } else {
            dfs(arr, r, c, n/2);
            dfs(arr, r+n/2, c, n/2);
            dfs(arr, r, c+n/2, n/2);
            dfs(arr, r+n/2,c+n/2, n/2);
        }
    }
}