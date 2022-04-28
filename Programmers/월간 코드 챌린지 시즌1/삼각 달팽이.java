class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int cnt = n*(n+1)/2;
        int value = 1;
        int r=0;
        int c=0;
        arr[r][c] = value++;
        
        while(value <= cnt) {
            while(r+1<n && arr[r+1][c]==0) {
                arr[r+1][c] = value++;
                r++;
            }
            while(c+1<n && arr[r][c+1]==0) {
                arr[r][c+1] = value++;
                c++;
            }
            while(r-1>0 && arr[r-1][c-1]==0){
                arr[r-1][c-1] = value++;
                r--;
                c--;
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}