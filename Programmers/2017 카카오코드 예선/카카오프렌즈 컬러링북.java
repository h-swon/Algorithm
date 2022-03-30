class Solution {
    
    boolean[][] visited;
    int[][] map;
    int M,N;
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int cnt = 0;
    public int[] solution(int m, int n, int[][] picture) {
        
        M = m;
        N = n;
        map = picture;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    numberOfArea++;   
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j, map[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }
            
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(int r, int c, int num) {
        
        for(int i=0; i<4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];
            if(nr<0 || nc<0 || nr>=M || nc>=N || visited[nr][nc] || map[nr][nc]!=num)
                continue;
            visited[nr][nc] = true;
            cnt++;
            dfs(nr, nc, num);
        }
    }
}