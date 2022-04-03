import java.util.*;

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m+1][n+1];
        dp[0][1][1] = dp[1][1][1] = 1;
        
        for(int r=1; r<=m; r++) {
            for(int c=1; c<=n; c++) {
                switch(cityMap[r-1][c-1]) {
                    case 0: {
                        dp[0][r][c] += (dp[0][r-1][c] + dp[1][r][c-1]) % MOD;
                        dp[1][r][c] += (dp[0][r-1][c] + dp[1][r][c-1]) % MOD;
                        break;
                    }
                    case 2: {
                        dp[0][r][c] = dp[0][r-1][c];
                        dp[1][r][c] = dp[1][r][c-1];
                        break;
                    }
                }
            
            }
        }
        return dp[0][m][n];
    }
}