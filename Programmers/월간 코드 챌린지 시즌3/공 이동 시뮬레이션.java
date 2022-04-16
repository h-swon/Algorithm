class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        
        long r1 = x;
        long c1 = y;
        long r2 = x;
        long c2 = y;
        
        for(int i=queries.length-1; i>=0; i--) {
            int dir = queries[i][0];
            int move = queries[i][1];
            
            switch(dir) {
                case 0: {   // 우 
                    if(c1>0) c1 += move;
                    c2 = Math.min(m-1, c2 + move);
                    break;
                }
                case 1: {   // 좌
                    if(c2<m-1) c2 -= move;
                    c1 = Math.max(0, c1 - move);
                    break;
                }
                case 2: {   // 하
                    if(r1>0) r1 += move;
                    r2 = Math.min(n-1, r2 + move);
                    break;
                }
                case 3: {   // 상
                    if(r2<n-1) r2 -= move;
                    r1 = Math.max(0, r1 - move);
                    break;
                }
            }
            
            if(r1>=n || r2<0 || c1>=m || c2<0) 
                return 0;
        }
        
        answer = (r2-r1+1) * (c2-c1+1);
        return answer;
    }
}